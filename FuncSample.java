
import java.util.Scanner; 

//function with argument 

public class FuncSample { 
    public static void main( String a[]) {
        Scanner ray = new Scanner(System.in); 
        System.out.println("Enter a two numbers: "); 

        int num1 = ray.nextInt();
        int num2 = ray.nextInt(); 

        int result = sum( num1, num2); 
        System.out.println("result:" + result);
    }

    static int sum( int a, int b) { 
        int c = a + b; 
        return c; 

    }
}
