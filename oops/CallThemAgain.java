
public class CallThemAgain {

    public static void main(String args[]) {
        
         ClassObjThree Obj1 = new ClassObjThree();
         ClassObjThree Obj2 = new ClassObjThree();

         Obj1.a = 55;
         Obj1.b = 30;

         Obj2.a = 45;
         Obj2.b = 66;

         Obj1.cal();
         Obj2.cal();

         Obj1.display();
         Obj2.display();
    }

}