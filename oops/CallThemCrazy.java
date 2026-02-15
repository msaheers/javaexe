public class CallThemCrazy {

    public static void main( String aeo[]) {

        int num1 = 100;
        int num2 = 200;

        int num3 = 300;
        int num4 = 400;

        ClassObjFour s = new ClassObjFour();
        ClassObjFour s1 = new ClassObjFour();

        s.cal( num1, num2);
        s.display();

        s.cal(num3, num4);
        s.display();

         s1.cal( num1, num2);
        s1.display();

        s1.cal(num3, num4);
        s1.display();
    }
}