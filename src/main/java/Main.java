import common.CurrencyDefinitionProcess;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.WindowBasedTextGUI;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import common.Session;
import controller.CurrencyController;
import controller.HomeController;
import model.User;
import org.json.simple.parser.ParseException;
import view.CurrencyWindow;
import view.HomeWindow;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        Screen screen = null;

        try {
            screen = terminalFactory.createScreen();
            screen.startScreen();

            final WindowBasedTextGUI textGUI = new MultiWindowTextGUI(screen);
            Session.textGui = textGUI;

            // Home Screen
            HomeWindow homeWindow = new HomeWindow("Home", CurrencyDefinitionProcess.getCurrencies());
            HomeController homeController = new HomeController(new User(), homeWindow);
            textGUI.addWindowAndWait(homeWindow);

            // Currency Screen
            CurrencyController currencyController =
                    new CurrencyController(Session.activeUser.getFavouriteCurrency().getCode());
            textGUI.addWindowAndWait(currencyController.getTheView());
        }
        catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        finally {
            if(screen != null) {
                try {
                    screen.stopScreen();
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
