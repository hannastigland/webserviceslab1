package se.iths.consumer;

import se.iths.service.CurrencyConverter;

import java.util.InputMismatchException;
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
        int converterIndex = 1;
        System.out.println("Choose what currency you want to convert from:");
        for (CurrencyConverter converter : loader) {
            System.out.println(converterIndex + ". " + converter.currencyName());
            converterIndex++;
        }

        int chosenConverterIndex;
        while (true) {
            System.out.println("Enter your choice:");
            try {
                chosenConverterIndex = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter 1 (SEK) or 2 (Euro).");
                sc.next();
            }
        }

        CurrencyConverter chosenConverter = null;
        int currentIndex = 1;
        for (CurrencyConverter converter : loader) {
            if (currentIndex == chosenConverterIndex) {
                chosenConverter = converter;
                break;
            }
            currentIndex++;
        }

        if (chosenConverter != null) {
            performConversion(sc, chosenConverter);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    private static void performConversion(Scanner sc, CurrencyConverter converter) {
        while (true) {
            try {
                System.out.println("Insert your amount:");
                double amount = sc.nextDouble();

                String result = converter.convert(amount);
                System.out.println(result);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
            }
        }
    }

}
