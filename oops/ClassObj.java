public class ClassObj {

    int a;
    int b; 
    public static void main( String ao[]) {
        ClassObj s1= new ClassObj();
        ClassObj s2= new ClassObj(); 

        s1.a = 20;
        s2.a = 50;
        s1.b = 60;
        s2.b = 45;

        System.out.println("S1 - a :"+ s1.a+" S2 - a:"+s2.a+" S1 - b:"+s1.b+" S2 - b:"+s2.b);
    }
}