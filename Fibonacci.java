import java.util.Scanner;

public class Fibonacci {
    static int num(int x) {
        if (x <= 1) {
            return x;
        } else {
            return num(x - 1) + num(x - 2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int x = scanner.nextInt();

        System.out.print("Fibonacci Series: ");
        for (int i = 0; i < x; i++) {
            System.out.print(num(i) + ",");
        }
    }
}
