package se.iths.provider;

import se.iths.service.CurrencyConverter;

public class SekToEuroConverter implements CurrencyConverter {
    @Override
    public String convert(double amount) {
        double exchangeRate = 0.085;
        double eurAmount = amount * exchangeRate;
        return amount + " SEK is ~" + eurAmount + " Euro";
    }

    @Override
    public String currencyName() {
        return "SEK";
    }
}
