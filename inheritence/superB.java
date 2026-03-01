public class superB extends superA {
    int a;

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

    public static void main(String[] args) {
        
        superB b=new superB();

        b.display(); //method overriding mode 
    
        b.baseDisplay();

    }
}