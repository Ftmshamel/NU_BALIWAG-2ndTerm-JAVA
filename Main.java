/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InheritanceActivity;

/**
 *
 * @author Fatima
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("-------------------------------------------------");
            System.out.println("---------------WELCOME TO PIZZARINA--------------");
            System.out.println("-------------------------------------------------\n");
            // Display menu
            displayMenu();
            // Get pizza type
            Pizza pizza = getPizzaType(scanner);
            // Get toppings
            addToppings(scanner, pizza);
            // Get addons
            addAddons(scanner, pizza);
            // Display order summary
            displayOrderSummary(pizza);
            // Payment transaction
            performPaymentTransaction(scanner, pizza);
            // Ask if the customer wants to order again
            askForOrderAgain(scanner);
            // Close the scanner
        }
    }

    private static void displayMenu() {
        System.out.println("-------------------------------------------------");
        System.out.println("---------------PICK A TYPE OF PIZZA--------------");
        System.out.println("-------------------------------------------------");
        System.out.printf("[%-8s] [%-20s] [%-8s]\n" , "CODE" , "DESCRIPTION" , "PRICE");
        System.out.printf("[%-8d] [%-20s] [%-8d]\n" , 1 , "Veggies", 70);
        System.out.printf("[%-8d] [%-20s] [%-8d]\n" , 2 , "Non-Veggies" , 50);
        System.out.println("-------------------------------------------------");
    }

    private static Pizza getPizzaType(Scanner scanner) {
        System.out.print("Enter pizza type (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.println("-------------------------------------------------");

        switch (choice) {
            case 1 -> {
                return new VeggiesPizza();
            }
            case 2 -> {
                return new NonVeggiesPizza();
            }
            default -> {
                System.out.println("Invalid choice. Defaulting to Veggies Pizza.");
                return new VeggiesPizza();
            }
        }
    }

    private static void addToppings(Scanner scanner, Pizza pizza) {
        System.out.println("-------------------------------------------------");
        System.out.println("Available Toppings (Enter comma-separated codes):");
        System.out.println("-------------------------------------------------");
        System.out.printf("[%-8s] [%-20s] [%-8s]\n" , "CODE" , "DESCRIPTION" , "PRICE");
        System.out.printf("[%-8d] [%-20s] [%-8d]\n" , 1 , "Pepperoni", 10);
        System.out.printf("[%-8d] [%-20s] [%-8d]\n" , 2 , "Sausage" , 15);
        System.out.printf("[%-8d] [%-20s] [%-8d]\n" , 3 , "Bacon" , 20);
        System.out.printf("[%-8d] [%-20s] [%-8d]\n" , 4 , "Ham" , 20);
        System.out.printf("[%-8d] [%-20s] [%-8d]\n" , 5 , "Meatballs" , 25);
        System.out.println("-------------------------------------------------");
        //System.out.println("[1] Pepperoni (PHP 10)");
        //System.out.println("[2] Sausage (PHP 15)");
        //System.out.println("[3] Bacon (PHP 20)");
        //System.out.println("[4] Ham (PHP 20)");
        //System.out.println("[5] Meatballs (PHP 25)");

        System.out.print("Enter toppings codes: ");
        String[] toppingCodes = scanner.nextLine().split(",");
        System.out.println("-------------------------------------------------\n");
        for (String code : toppingCodes) {
            int toppingCode = Integer.parseInt(code.trim());
            pizza.addTopping(getToppingName(toppingCode), getToppingPrice(toppingCode));
        }
    }

    private static void addAddons(Scanner scanner, Pizza pizza) {
        System.out.println("-------------------------------------------------");
        System.out.println("Available Addons (Enter comma-separated codes):");
        System.out.println("-------------------------------------------------");
        System.out.printf("[%-8s] [%-20s] [%-8s]\n" , "CODE" , "DESCRIPTION" , "PRICE");
        System.out.printf("[%-8d] [%-20s] [%-8d]\n" , 1 , "Extra Cheese", 15);
        System.out.printf("[%-8d] [%-20s] [%-8d]\n" , 2 , "Corn" , 15);
        System.out.printf("[%-8d] [%-20s] [%-8d]\n" , 3 , "Roasted Red Peppers" , 20);
        System.out.printf("[%-8d] [%-20s] [%-8d]\n" , 4 , "Fresh Herbs" , 20);
        System.out.printf("[%-8d] [%-20s] [%-8d]\n" , 5 , "Pesto Swirl" , 20);
        System.out.printf("[%-8d] [%-20s] [%-8d]\n" , 6 , "BBQ Sauce" , 30);
        System.out.println("-------------------------------------------------");
        //System.out.println("[1] Extra Cheese (PHP 15)");
        //System.out.println("[2] Corn (PHP 15)");
        //System.out.println("[3] Roasted Red Peppers (PHP 20)");
        //System.out.println("[4] Fresh Herbs (PHP 20)");
        //System.out.println("[5] Pesto Swirl (PHP 20)");
        //System.out.println("[6] BBQ Sauce (PHP 30)");

        System.out.print("Enter addons codes: ");
        String[] addonCodes = scanner.nextLine().split(",");
        System.out.println("-------------------------------------------------\n");
        for (String code : addonCodes) {
            int addonCode = Integer.parseInt(code.trim());
            pizza.addAddon(getAddonName(addonCode), getAddonPrice(addonCode));
        }
    }

     private static void displayOrderSummary(Pizza pizza) {
        System.out.println("-------------------------------------------------");
        System.out.println("-----------------Order Receipt:------------------");
        System.out.println("-------------------------------------------------");
        System.out.printf("%-20s%-10s\n", "Item", "Price (PHP)");
        System.out.println("-------------------------------------------------");

        // Display base pizza
        System.out.printf("%-20s%s%-10s\n", pizza.getDescription(), "\t", pizza.getBasePrice());

        // Display toppings and addons
        for (Item item : pizza.getItems()) {
            System.out.printf("%-20s%s%-10s\n", item.getName(), "\t", item.getPrice());
        }

        // Display total price
        System.out.println("-------------------------------------------------");
        System.out.printf("%-20s%s%-10s\n", "Total", "\t", pizza.getTotalPrice());
        System.out.println("-------------------------------------------------");
    }

    private static void performPaymentTransaction(Scanner scanner, Pizza pizza) {
        System.out.print("Enter payment amount (PHP): ");
        double paymentAmount = scanner.nextDouble();
        double remainingAmount = pizza.getTotalPrice() - paymentAmount;
        System.out.println("-------------------------------------------------");

        if (remainingAmount <= 0) {
            System.out.println("Payment successful! Change: " + Math.abs(remainingAmount));
            System.out.println("-------------------------------------------------");
        } else {
            System.out.println("Payment incomplete. Remaining amount: " + remainingAmount);
            System.out.println("-------------------------------------------------");
        }
    }

    private static void askForOrderAgain(Scanner scanner) {
        System.out.print("Do you want to order again? (yes/no): ");
        String orderAgain = scanner.next().toLowerCase();
        System.out.println("-------------------------------------------------");
        if ("no".equals(orderAgain)) {
            System.out.println("Thank you for ordering!");
            System.out.println("-------------------------------------------------");
        } else {
            main(null); // Recursive call to restart the ordering process
        }
    }

    private static String getToppingName(int code) {
        return switch (code) {
            case 1 -> "Pepperoni";
            case 2 -> "Sausage";
            case 3 -> "Bacon";
            case 4 -> "Ham";
            case 5 -> "Meatballs";
            default -> "Unknown Topping";
        };
    }

    private static double getToppingPrice(int code) {
        return switch (code) {
            case 1 -> 10;
            case 2 -> 15;
            case 3 -> 20;
            case 4 -> 20;
            case 5 -> 25;
            default -> 0;
        };
    }

    private static String getAddonName(int code) {
        return switch (code) {
            case 1 -> "Extra Cheese";
            case 2 -> "Corn";
            case 3 -> "Roasted Red Peppers";
            case 4 -> "Fresh Herbs";
            case 5 -> "Pesto Swirl";
            case 6 -> "BBQ Sauce";
            default -> "Unknown Addon";
        };
    }

    private static double getAddonPrice(int code) {
        return switch (code) {
            case 1 -> 15;
            case 2 -> 15;
            case 3 -> 20;
            case 4 -> 20;
            case 5 -> 20;
            case 6 -> 30;
            default -> 0;
        };
    }
}
