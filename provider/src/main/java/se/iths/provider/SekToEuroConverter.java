package se.iths.provider;

import se.iths.service.CurrencyConverter;

public class SekToEuroConverter implements CurrencyConverter {
    @Override
    public String convert(double amount) {
        double exchangeRate = 0.085;
        double eurAmount = amount * exchangeRate;
        return String.format(amount + " SEK is ~" + "%.2f Euro", eurAmount);
    }

    @Override
    public String currencyName() {
        return "SEK";
    }
}
