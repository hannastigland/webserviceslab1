import se.iths.provider.SekToEuroConverter;
import se.iths.provider.EuroToSekConverter;
import se.iths.service.CurrencyConverter;

module se.iths.provider {
    requires se.iths.service;

    provides CurrencyConverter with SekToEuroConverter, EuroToSekConverter;
}