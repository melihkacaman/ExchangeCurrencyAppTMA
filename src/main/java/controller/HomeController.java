package controller;

import common.CurrencyDefinitionProcess;
import common.Session;
import com.googlecode.lanterna.gui2.Button;
import model.CurrencyDefinition;
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
            CurrencyDefinition currencyDefinition = CurrencyDefinitionProcess.getCurrencyFromSelectedItem(favouriteCurrencyString);

            User activeUser = new User(100,name, currencyDefinition);
            Session.activeUser = activeUser;

            HomeController.this.homeWindow.close();
        }
    }
}
