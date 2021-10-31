package controller;

import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.dialogs.MessageDialog;
import common.ApiConnect;
import common.Session;
import model.Currency;
import org.json.simple.parser.ParseException;
import view.CurrencyWindow;

import java.io.IOException;
import java.util.List;

public class CurrencyController {
    private CurrencyWindow currencyWindow;
    private String baseCurrency;

    private final static String[] popularCurrencies = new String[]{"USD", "EUR", "TRY", "JPY", "RUB"};

    public CurrencyController(String baseCurrencyCode) throws IOException, ParseException {
        this.baseCurrency = baseCurrencyCode;
        this.currencyWindow = new CurrencyWindow("Currency",
                ApiConnect.getBunchOfCurrencies(baseCurrency, popularCurrencies));

        this.currencyWindow.addActionToRefresh(new RefreshListener(baseCurrency));
        this.currencyWindow.addActionToCalculate(new CalculateListener());
    }

    public CurrencyWindow getTheView() {
        return currencyWindow;
    }

    private class RefreshListener implements Button.Listener {
        private String baseCurrency;
        public RefreshListener(String baseCurrency) {
            this.baseCurrency = baseCurrency;
        }

        @Override
        public void onTriggered(Button button) {
            System.out.println("Refreshment! ");
            List<String> newDatasource = null;
            try {
                newDatasource = ApiConnect.getBunchOfCurrencies(baseCurrency, popularCurrencies);
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }

            CurrencyController.this.currencyWindow.notifyCurrencyListBox(newDatasource);
            MessageDialog.showMessageDialog(Session.textGui, "Refreshment", "Successfully refreshed!");

        }
    }


    private class CalculateListener implements Button.Listener {
        @Override
        public void onTriggered(Button button) {
            CurrencyController.this.currencyWindow.close();
        }
    }
}
