import java.util.Scanner;

public class MachineProblem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input syempre yung user
        System.out.print("Enter a string: ");
        String string = scanner.nextLine();

        int vowels = 0;
        int consonants = 0;
        int digits = 0;
        int whitespaces = 0;

        string = string.toLowerCase();

        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);

            // vowels
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels++;
            }
            // consonant
            else if ((ch >= 'a' && ch <= 'z')) {
                consonants++;
            }
            // digits
            else if (Character.isDigit(ch)) {
                digits++;
            }
            // white spaces
            else if (Character.isWhitespace(ch)) {
                whitespaces++;
            }
        }
        // i-print na yung outputs
        System.out.println("Number of vowels: " + vowels);
        System.out.println("Number of consonants: " + consonants);
        System.out.println("Number of digits: " + digits);
        System.out.println("Number of white spaces: " + whitespaces);
    }
}
