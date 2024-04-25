package se.iths.consumer;

import se.iths.service.CurrencyConverter;

import java.util.Scanner;
import java.util.ServiceLoader;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ServiceLoader<CurrencyConverter> loader = ServiceLoader.load(CurrencyConverter.class);



        boolean running = true;
        while (running) {
            System.out.println("Welcome to the EUR-SEK currency converter!");
            chooseConverterAndConvert(sc, loader);

            System.out.println("Do you want to convert another currency? (yes/no)");
            String continueChoice = sc.next();

            if (!continueChoice.equalsIgnoreCase("yes")) {
                running = false;
                System.out.println("Good-bye.");
            }
        }
    }

    private static void chooseConverterAndConvert(Scanner sc, ServiceLoader<CurrencyConverter> loader) {
        // Visa tillgängliga konverterare
        int converterIndex = 1;
        System.out.println("Choose what currency you want to convert from:");
        for (CurrencyConverter converter : loader) {
            System.out.println(converterIndex + ". " + converter.currencyName());
            converterIndex++;
        }

        // Läs användarens val av konverterare
        int chosenConverterIndex = sc.nextInt();
        CurrencyConverter chosenConverter = null;
        int currentIndex = 1;
        for (CurrencyConverter converter : loader) {
            if (currentIndex == chosenConverterIndex) {
                chosenConverter = converter;
                break;
            }
            currentIndex++;
        }

        // Utför konvertering
        if (chosenConverter != null) {
            performConversion(sc, chosenConverter);
        } else {
            System.out.println("Invalid converter choice.");
        }
    }

    private static void performConversion(Scanner sc, CurrencyConverter converter) {
        // Läs in belopp från användaren
        System.out.println("Insert amount:");
        double amount = sc.nextDouble();

        // Utför konvertering med vald konverterare
        String result = converter.convert(amount);
        System.out.println(result);
    }
}
