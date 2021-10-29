package controller;

import model.FavouriteCurrency;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import view.HomeWindow;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeController {
    private HomeWindow homeWindow;


    public HomeController() {
        // TODO: 10/29/2021 Use the view!

    }

    private List<FavouriteCurrency> readCurrencies(){
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

}
