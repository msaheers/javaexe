import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;


public class Calculator implements ActionListener {

    JFrame jf;
    JLabel displayLabel;
    String expression = "";

    Timer cursorTimer;
    boolean showCursor = true;

    public Calculator() {

        jf = new JFrame("Calculator");
        jf.setLayout(null);
        jf.setSize(600, 600);
        jf.setLocation(300, 150);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        displayLabel = new JLabel();
        displayLabel.setBounds(30, 50, 540, 40);
        displayLabel.setBackground(Color.GRAY);
        displayLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        displayLabel.setOpaque(true);
        displayLabel.setFont(displayLabel.getFont().deriveFont(25f));
        jf.add(displayLabel);

        // Create Buttons
        String[] buttons = { 
            "7","8","9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        int x = 30, y = 130;

        for ( int i = 0; i < buttons.length; i++) {

            JButton btn = new JButton(buttons[i]);
            btn.setBounds(x, y, 80, 80);
            btn.setFont(btn.getFont().deriveFont(30f));
            btn.addActionListener(this);
            jf.add(btn);

            x += 90;

            if ((i + 1) % 4 == 0) {
                x = 30;
                y += 90;
            }
        }

        JButton clear = new JButton("A/C");
        clear.setBounds(390, 400, 80, 80);
        clear.setFont(clear.getFont().deriveFont(20f));
        clear.addActionListener(this);
        jf.add(clear);

        //Blinking Cursor
        cursorTimer = new Timer (500, e -> {
            showCursor = !showCursor;
            UpdateDisplay();

        }); 
            
        
        cursorTimer.start();

        jf.setVisible(true);
    }

    private void UpdateDisplay() {
        if (showCursor) {
            displayLabel.setText(expression + "|");
        } else {
            displayLabel.setText(expression + " ");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton btn = (JButton) e.getSource();
        String text = btn.getText();

        if (text.equals("A/C")) {
            expression = "";
        }

        else if (text.equals("=")) {
            calculateExpression();
        }

        else {
            expression += text;
        }

        UpdateDisplay();

    }

    private void calculateExpression() {

        try {
           double result = evaluate(expression);
           expression = String.valueOf(result);

        } catch (Exception e) {
            expression = "Error";
        }
    }

    private double evaluate(String expr) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < expr.length()) ? expr.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < expr.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm();
                    else if (eat('-')) x -= parseTerm();
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor();
                    else if (eat('/')) x /= parseFactor();
                    else return x;
                }
            }

            double parseFactor() {
                if      (eat('+')) return parseFactor();
                if      (eat('-')) return parseFactor();

                double x;
                int startPos = this.pos;

                if ((ch >= '0' && ch <= '9') || ch == '.') {
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(expr.substring(startPos, this.pos));
                } else {
                    throw new RuntimeException("Unexcepted: " + (char)ch);
                }
                return x;
            }
        }.parse();

    }
}