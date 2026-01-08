/*import java.util.Scanner; 

public class Forloop { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 

        int num = sc.nextInt();
        int sum = 0;
        for ( int i = 0; i < num; i++) {
            sum = sum + i; 
        }

        System.out.println("Result: " + sum);
    }
} */

import java.util.Scanner; 

public class Forloop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 

        int num = sc.nextInt();
        int sum = 0;
        for ( int i = 0; i < num; i++) {
            sum = sum + i;
        }

        System.out.println("Result: " + sum);

        sc.next();
    }
}

