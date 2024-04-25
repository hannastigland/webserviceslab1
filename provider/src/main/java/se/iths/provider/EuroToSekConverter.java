package se.iths.provider;

import se.iths.service.CurrencyConverter;

public class EuroToSekConverter implements CurrencyConverter {
    @Override
    public String convert(double amount) {
        double exchangeRate = 11.72;
        double sekAmount = amount * exchangeRate;
        return amount + " Euro is ~" + sekAmount + " SEK";
    }

    @Override
    public String currencyName() {
        return "Euro";
    }
}
