package controller;

import Common.Currency;
import Common.Session;
import com.googlecode.lanterna.gui2.Button;
import model.FavouriteCurrency;
import model.User;
import view.HomeWindow;

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
            Session.activeUser = activeUser;

            HomeController.this.homeWindow.close();
        }
    }
}
