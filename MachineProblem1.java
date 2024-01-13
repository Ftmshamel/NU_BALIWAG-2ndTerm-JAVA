import java.util.Scanner;

public class MachineProblem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // user will Input
        System.out.print("Enter your full name: ");
        String fullname = scanner.nextLine();

        // Initializing empty string (para ma-store yung abbreviation)
        String[] name = fullname.split(" ");
        String result = "";

        // Loop through the first to second-to-last names
        for (int i = 0; i < name.length - 1; i++) {
            // may . mula first name hanggang middle name (for abbreviation)
            result += name[i].charAt(0) + ".";
        }
        // hindi kasama yung last name sa ia-abbreviate
        result += name[name.length - 1];

        System.out.println("Abbreviation: " + result);
    }
}
