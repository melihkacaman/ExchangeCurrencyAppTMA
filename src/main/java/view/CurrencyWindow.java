package view;

import Common.Session;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;

public class CurrencyWindow extends BasicWindow {
    private Button refreshButton;
    private Button calculateButton;
    private Panel popularCurrencies;

    public CurrencyWindow(String title) {
        super(title);

        Panel panel = new Panel();
        panel.setLayoutManager(new LinearLayout());
        panel.addComponent(new Label("Hello " + Session.activeUser.getName() + "!"));
        panel.addComponent(new Label("Your choice is " + Session.activeUser.getFavouriteCurrency().getCode()));
        panel.addComponent(new EmptySpace(new TerminalSize(1,1)));
        panel.addComponent(new Label("Instant Currencies"));

        popularCurrencies = new Panel(new GridLayout(2));
        popularCurrencies.addComponent(new Label("USD"));
        popularCurrencies.addComponent(new Label("3 TL"));


        panel.addComponent(popularCurrencies);

        this.setComponent(panel);
    }
}
