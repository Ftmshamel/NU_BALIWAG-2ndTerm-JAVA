import java.util.Scanner;

public class Prime2 {
    static int Prime(int n, int i) {
        if (n <= 1) {
            return 0;
        }
        if (i > Math.sqrt(n)) {
            return 1;
        }
        if (n % i == 0) {
            return 0;
        }
        return Prime(n, i + 1);
    }

    static int Prime3(int a, int b) {
        if (b >= a) {
            return 0;
        }

        int Prime4 = Prime(b, 2) == 1 ? 1 : 0;
        return Prime4 + Prime3(a, b + 1);
    }

    static void Prime5(int a, int b) {
        if (b <= a) {
            int num = b;
            if (Prime(num, 2) == 1) {
                for (int j = 2; j <= num / 2; j++) {
                    if (Prime(j, 2) == 1 && Prime(num - j, 2) == 1) {
                        System.out.print(num + " ");
                        break;
                    }
                }
            }
            Prime5(a, b + 1);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int N = in.nextInt();

        int count = Prime3(N, 2);

        System.out.println("Count of primes that can be expressed as the sum of two primes: " + count);

        System.out.print("Prime Numbers:");
        Prime5(N, 2);
    }
}