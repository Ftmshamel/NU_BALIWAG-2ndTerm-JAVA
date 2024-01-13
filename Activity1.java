import java.util.Scanner;

public class Activity1 {
    public static void num(int x, int y) {

        if(y > x) {
            return;
        }
        if(x % y == 0) {
            System.out.print(y + " ");
        }

        num (x, y + 1);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        System.out.print("Enter a number: ");
        int x = scanner.nextInt();

        System.out.print("Factors of "+ x + ": ");
        num(x,1);
    }
}