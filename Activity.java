import java.util.Scanner;

public class Activity {

    public static String classifyMain(int num) {
        int sum = 0;

        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }

        if (sum == num) {
            return "Perfect";
        } else if (sum < num) {
            return "Deficient";
        } else {
            return "Abundant";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        String numbt = classifyMain(num);
        System.out.println("The number " + num + " is " + numbt);
    }
}