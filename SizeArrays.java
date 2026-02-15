/*import java.util.Scanner; 

    public class SizeArrays {
        public static void main( String ae[]) { 
        Scanner sc = new Scanner( System.in); 
        System.out.println("Enter the size of the arrays: ");

        int size = sc.nextInt(); // Read the size first 
        
        // Declare  arrays after size is known 

        int [][] array1 = new int[size][size]; 
        int [][] array2 = new int[size][size];
        int[][] sum     = new int[size][size];

        // getting inputs from the user for the array1 
        System.out.println("Enter the values of array1:");
        for ( int i = 0; i < size; i++) {
            for ( int j = 0; j < size; j++) {
                array1[i][j] = sc.nextInt(); 
            }
        }

        // getting inputs from the user for the array2
        System.out.println("Enter the values of array2: ");
        for ( int i = 0; i < size; i++) { 
            for ( int j = 0; j < size; j++) {
                array2[i][j] = sc.nextInt(); 
            }
        }

        // Calculating and print the sum 
        System.out.println("Sum of the arrays: "); 
        for ( int i = 0; i < size; i++) { 
            for ( int j = 0; j < size; j++) { 
                sum[i][j] = array1[i][j] + array2[i][j];
                System.out.print(sum[i][j] + "\t");
            }
            System.out.println();
        }

        
        
        
        

    }

}*/

import java.util.Scanner; 

public class SizeArrays { 
    public static void main ( String ae[]) { 
        Scanner sc = new Scanner(System.in); 
        System.out.println("Enter the size of the arrays: "); 

        int size = sc.nextInt();  //First get the size for the array 

        // Declare arrays after getting the size 

        int[][]array1 = new int[size][size];
        int[][]array2 = new int[size][size];
        int[][]sum = new int[size][size];

        // Getting the inputs from the user for thre arrays1 
        System.out.println("Enter the values of array1: ");
        for ( int i = 0; i < size; i++) {
            for ( int j = 0; j < size; j++) {
                array1[i][j] = sc.nextInt();
            }
        }

        // Getting the inputs from the user for the arrays2 
        System.out.println("Enter the values of array2: ");
        for ( int i = 0; i < size; i++) {
            for ( int j = 0; j < size; j++) {
                array2[i][j] = sc.nextInt();
            }
        }

        System.out.println("The total sum of the arrays: "); 
        for ( int i = 0; i < size; i++) {
            for ( int j = 0; j < size; j++) {
                sum[i][j] = array1[i][j] + array2[i][j];
                System.out.print(sum[i][j] + "\t");
            }
        }

        System.out.println();

 
    }
}
