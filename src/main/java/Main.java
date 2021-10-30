import IO.Currency;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.WindowBasedTextGUI;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import controller.HomeController;
import model.User;
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

            HomeWindow homeWindow = new HomeWindow("Home", Currency.getCurrencies());
            HomeController homeController = new HomeController(new User(), homeWindow);
            textGUI.addWindowAndWait(homeWindow);
            //textGUI.addWindowAndWait(new window("lorem ipsum"));
        }
        catch (IOException e) {
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
