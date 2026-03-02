
public class superB extends superA {

    int a;

    /*superB() {  //constructor mode 
        System.out.println("coding saves lives");
    }


    void display() {

        System.out.println("Ditch shazaaam, Spider-man brooo");

        a=20;

        super.a = 20;

        int c = a+super.a;
       System.err.println(c);
    }

    void baseDisplay() {
        super.display();
    }
     */
    superB() {

        System.out.println("Code always saves lives but you gotta code yo");
    }

    superB(int a) {
        super(10);
        System.out.println("Yeah, we need to keep up the momentum, cant slack");
    }

    public static void main(String[] args) {

        superB b = new superB(5);

        //b.display(); //method overriding mode 
        //b.baseDisplay();
    }
}
