package controller;

import IO.Currency;
import com.googlecode.lanterna.gui2.Button;
import model.FavouriteCurrency;
import model.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import view.HomeWindow;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomeController {
    private HomeWindow homeWindow;
    private User modelUser;


    public HomeController(User theModel, HomeWindow theView) {

        homeWindow = theView;
        modelUser = theModel;

        homeWindow.addActionListener(new GoOnListener());
    }

    class GoOnListener implements Button.Listener{
        @Override
        public void onTriggered(Button button) {
            String name = HomeController.this.homeWindow.getName();
            String favouriteCurrencyString = HomeController.this.homeWindow.getSelectedCurrency();
            FavouriteCurrency favouriteCurrency = Currency.getCurrencyFromSelectedItem(favouriteCurrencyString);

            User activeUser = new User(100,name,favouriteCurrency);
            System.out.println("User is registered.");
        }
    }
}
