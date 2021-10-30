package view;

import CustomComponet.CustomListbox;
import common.Session;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;

public class CurrencyWindow extends BasicWindow {
    private Button refreshButton;
    private Button calculateButton;
    private CustomListbox currenciesListbox;

    public CurrencyWindow(String title) {
        super(title);

        Panel panel = new Panel();
        panel.setLayoutManager(new LinearLayout());
        panel.addComponent(new Label("Hello " + Session.activeUser.getName() + "!"));
        panel.addComponent(new Label("Your choice is " + Session.activeUser.getFavouriteCurrency().getCode()));
        panel.addComponent(new EmptySpace(new TerminalSize(1,1)));
        panel.addComponent(new Label("Instant Currencies"));

        //currenciesListbox = new CustomListbox()


        //panel.addComponent(popularCurrencies);

        this.setComponent(panel);
    }
}
