package controller;

import common.ApiConnect;
import model.Currency;
import org.json.simple.parser.ParseException;
import view.CurrencyWindow;

import java.io.IOException;
import java.util.List;

public class CurrencyController {
    private CurrencyWindow currencyWindow;
    private String baseCurrency;


    public CurrencyController(String baseCurrencyCode) throws IOException, ParseException {
        this.baseCurrency = baseCurrencyCode;
        this.currencyWindow = new CurrencyWindow("Currency",
                ApiConnect.getBunchOfCurrencies(baseCurrency, new String[]{"USD", "EUR", "TRY", "JPY", "RUB"}));


    }

    public CurrencyWindow getTheView() {
        return currencyWindow;
    }
}
