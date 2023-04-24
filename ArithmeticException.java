import java.util.Scanner;

public class ArithmeticException {
    void divide(int a, int b) {
        int res;
        try {
            // performing divison and storing th result
            res = a / b;
            System.out.println("Division process has been done successfully.");
            System.out.println("Result came after division is: " + res);
        }
        // handling the exception in the catch block
        catch (java.lang.ArithmeticException ex) {
            System.out.println("Dividing by Zero is undefined. " + ex);
        }

    }

    // main method
    public static void main(String argvs[]) {
        // creating an object of the class ArithmeticException
        ArithmeticException obj = new ArithmeticException();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ywo numbers a(numerator) and b(denumerator): ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        obj.divide(a, b);
        sc.close();
    }

}
