public class CallThem {
    public static void main(String a[]) {

        ClassObjTwo s1=new ClassObjTwo();
        ClassObjTwo s2 = new ClassObjTwo();

        s1.a = 20;
        s1.b = 40;
        s2.a = 100;
        s2.b = 80;

        s1.display();
        s2.display();

    }
}