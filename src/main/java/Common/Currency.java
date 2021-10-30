package Common;

import model.FavouriteCurrency;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Currency {
    static private List<FavouriteCurrency> currencies = readCurrencies();

    private Currency(){

    }

    private static List<FavouriteCurrency> readCurrencies(){
        JSONParser jsonParser = new JSONParser();

        try(FileReader reader = new FileReader("Resource/currencies.json")) {
            Object obj = jsonParser.parse(reader);

            JSONArray currencyList = (JSONArray) obj;
            System.out.println(currencyList);

            List<FavouriteCurrency> favouriteCurrencies = new ArrayList<>();
            for (Object currency : currencyList) {
                JSONObject cr = (JSONObject) currency;
                FavouriteCurrency newCurrency =
                        new FavouriteCurrency((String) cr.get("code"),(String) cr.get("name"));
                favouriteCurrencies.add(newCurrency);
            }

            return favouriteCurrencies;

        } catch (IOException | ParseException e) {
            return null;
        }
    }

    public static List<FavouriteCurrency> getCurrencies(){
        return currencies;
    }

    public static FavouriteCurrency getCurrencyFromSelectedItem(String selectedItem){
        String items[] = selectedItem.split("-");
        String code = items[0];

        return getCurrencyFromCode(code);
    }

    public static FavouriteCurrency getCurrencyFromCode(String code){
        for (FavouriteCurrency c : currencies) {
            if (c.getCode().equals(code)) {
                return c;
            }
        }

        return null;
    }
}
