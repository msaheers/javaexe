import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Calculator implements ActionListener {

    JFrame jf;
    JLabel displayLabel;

    JButton[] numberButtons = new JButton[10];
    JButton addButton, subButton, mulButton, divButton;
    JButton eqButton, clrButton;

    public Calculator() {

        jf = new JFrame("Calculator");
        jf.setSize(600, 600);
        jf.setLayout(null);
        jf.setLocation(300, 150);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        displayLabel = new JLabel();
        displayLabel.setBounds(30, 50, 520, 40);
        displayLabel.setOpaque(true);
        displayLabel.setBackground(Color.DARK_GRAY);
        displayLabel.setForeground(Color.WHITE);
        displayLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        jf.add(displayLabel);

        // Numbers
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            jf.add(numberButtons[i]);
        }

        numberButtons[7].setBounds(30, 130, 80, 80);
        numberButtons[8].setBounds(120, 130, 80, 80);
        numberButtons[9].setBounds(210, 130, 80, 80);
        numberButtons[4].setBounds(30, 220, 80, 80);
        numberButtons[5].setBounds(120, 220, 80, 80);
        numberButtons[6].setBounds(210, 220, 80, 80);
        numberButtons[1].setBounds(30, 310, 80, 80);
        numberButtons[2].setBounds(120, 310, 80, 80);
        numberButtons[3].setBounds(210, 310, 80, 80);
        numberButtons[0].setBounds(120, 400, 80, 80);

        // Operators
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");

        addButton.setBounds(300, 130, 80, 80);
        subButton.setBounds(300, 220, 80, 80);
        mulButton.setBounds(300, 310, 80, 80);
        divButton.setBounds(300, 400, 80, 80);

        eqButton = new JButton("=");
        clrButton = new JButton("C");

        eqButton.setBounds(210, 400, 80, 80);
        clrButton.setBounds(390, 400, 80, 80);

        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        eqButton.addActionListener(this);
        clrButton.addActionListener(this);

        jf.add(addButton);
        jf.add(subButton);
        jf.add(mulButton);
        jf.add(divButton);
        jf.add(eqButton);
        jf.add(clrButton);

        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String cmd = e.getActionCommand();

        if (cmd.charAt(0) >= '0' && cmd.charAt(0) <= '9') {
            displayLabel.setText(displayLabel.getText() + cmd);
        }

        else if (cmd.equals("C")) {
            displayLabel.setText("");
        }

        else if (cmd.equals("=")) {
            calculateResult();
        }

        else {
            displayLabel.setText(displayLabel.getText() + cmd);
        }
    }

    // 🔥 EXPRESSION EVALUATOR (handles + - * / with priority)
    private void calculateResult() {

        try {
            String exp = displayLabel.getText();

            java.util.Stack<Double> values = new java.util.Stack<>();
            java.util.Stack<Character> ops = new java.util.Stack<>();

            for (int i = 0; i < exp.length(); i++) {

                char c = exp.charAt(i);

                if (Character.isDigit(c)) {

                    StringBuilder sb = new StringBuilder();

                    while (i < exp.length() &&
                           (Character.isDigit(exp.charAt(i)) || exp.charAt(i) == '.')) {
                        sb.append(exp.charAt(i));
                        i++;
                    }
                    i--;

                    values.push(Double.parseDouble(sb.toString()));
                }

                else if (c == '+' || c == '-' || c == '*' || c == '/') {

                    while (!ops.isEmpty() &&
                           hasPrecedence(c, ops.peek())) {

                        double b = values.pop();
                        double a = values.pop();
                        char op = ops.pop();

                        values.push(applyOp(a, b, op));
                    }

                    ops.push(c);
                }
            }

            while (!ops.isEmpty()) {
                double b = values.pop();
                double a = values.pop();
                char op = ops.pop();

                values.push(applyOp(a, b, op));
            }

            displayLabel.setText(String.valueOf(values.pop()));

        } catch (Exception e) {
            displayLabel.setText("Error");
        }
    }

    private boolean hasPrecedence(char op1, char op2) {
        if ((op2 == '*' || op2 == '/') && (op1 == '+' || op1 == '-')) {
            return true;
        }
        return false;
    }

    private double applyOp(double a, double b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return 0;
    }
}