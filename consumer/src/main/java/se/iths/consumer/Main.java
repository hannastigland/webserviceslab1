package se.iths.consumer;

import se.iths.service.CurrencyConverter;

import java.util.Scanner;
import java.util.ServiceLoader;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ServiceLoader<CurrencyConverter> loader = ServiceLoader.load(CurrencyConverter.class);

        boolean exit = false;

        while (!exit) {
            System.out.println("Welcome to the currency converter!");
            System.out.println("Choose an option:");
            System.out.println("1. Convert from SEK to Euro");
            System.out.println("2. Convert from Euro to SEK");
            System.out.println("3. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    convertToEuro(sc, loader);
                    break;
                case 2:
                    convertToSek(sc, loader);
                    break;
                case 3:
                    exit = true;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        

        for (CurrencyConverter converter : loader) {
            System.out.println(converter.convert(100));
        }
    }

    private static void convertToEuro(Scanner sc, ServiceLoader<CurrencyConverter> loader) {
        System.out.println("Insert amount in SEK: ");
        double amountSEK = sc.nextDouble();

        for (CurrencyConverter converter : loader) {
            String result = converter.convert(amountSEK);
            System.out.println(result);
        }
    }
    private static void convertToSek(Scanner sc, ServiceLoader<CurrencyConverter> loader) {
        System.out.println("Insert amount in Euro:");
        double amountEur = sc.nextDouble();

        for (CurrencyConverter converter : loader) {
            String result = converter.convert(amountEur);
            System.out.println(result);
        }
    }
}
