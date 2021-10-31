package view;

import CustomComponet.CustomListbox;
import common.ApiConnect;
import common.Session;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import model.Currency;
import org.json.simple.parser.ParseException;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class CurrencyWindow extends BasicWindow {
    private Button refreshButton;
    private Button calculateButton;
    private CustomListbox currenciesListbox;

    public CurrencyWindow(String title, List<String> dataSourceForLisBox) throws IOException, ParseException {
        super(title);

        Panel panel = new Panel();
        panel.setLayoutManager(new LinearLayout());
        panel.addComponent(new Label("Hello " + Session.activeUser.getName() + "!"));
        panel.addComponent(new Label("Your choice is " + Session.activeUser.getFavouriteCurrency().getCode()));
        panel.addComponent(new EmptySpace(new TerminalSize(1,1)));
        panel.addComponent(new Label("Instant Currencies"));

        currenciesListbox = new CustomListbox(dataSourceForLisBox);
        panel.addComponent(this.currenciesListbox);

        refreshButton = new Button("Refresh the list !");
        panel.addComponent(refreshButton);

        calculateButton = new Button("Calculate Currency !");
        panel.addComponent(calculateButton);

        this.setComponent(panel);
    }

    public void addActionToCalculate(Button.Listener listener){
        calculateButton.addListener(listener);
    }

    public void addActionToRefresh(Button.Listener listener){
        refreshButton.addListener(listener);
    }
}
