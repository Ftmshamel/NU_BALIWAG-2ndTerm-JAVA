import java.util.Scanner;

public class MachineProblem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter any string: ");
        String anystring = scanner.nextLine().toLowerCase();

        int[] letters = new int[26];

        // Count the occurrences
        for (char c : anystring.toCharArray()){
            if (Character.isLetter(c))
            letters[Character.toLowerCase(c) - 'a']++;
        }
        // Print the occurrences
        for (int i = 0; i < 26; i++) {
            char current = (char) ('A' + i);
            if (letters[i] > 0)
                System.out.println(current + ": " + letters[i]);
        }

        // Print the max occurrence
        char max = ' ';
        int occurrence = 0;

        for (int i = 0; i < 26; i++){
            if (letters[i] > occurrence) {
                max = (char) ('A' + i);
                occurrence = letters[i];
            }
        }
        System.out.println("Alphabet with maximum occurrence: " + max + " = " + occurrence + " times");
    }
}
