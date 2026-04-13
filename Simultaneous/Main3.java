public class Main3 {
    public static void main(String[] args) {

        Coding c = new Coding();
        Learning l = new Learning();

        Thread t1 = new Thread(c);
        Thread t2 = new Thread(l);

        t1.start();
        t2.start();


        
    }
}