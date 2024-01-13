import java.util.Scanner;

public class EmengActivity1 {

    public static String ClassifyEmengActivity1(int num) {
        int sum = 0;

        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i + num / i;
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
        int input = scanner.nextInt();

        String numb = ClassifyEmengActivity1(input);
        System.out.println("The number " + input + " is " + numb + ".");
    }
}