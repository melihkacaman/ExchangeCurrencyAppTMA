package view;

import com.googlecode.lanterna.gui2.*;
import model.CurrencyDefinition;
import java.util.List;

public class HomeWindow extends BasicWindow {

    private TextBox name;
    private Button send;
    private ComboBox<String> currencyList;

    public HomeWindow(String title, List<CurrencyDefinition> currencies) {
        super(title);

        Panel contentPanel = new Panel();
        contentPanel.setLayoutManager(new GridLayout(2));
        contentPanel.addComponent(new Label("Name:"));

        name = new TextBox();
        contentPanel.addComponent(name);
        contentPanel.addComponent(new Label("Favourite Currency:"));
        currencyList = new ComboBox<String>();
        for (CurrencyDefinition currencyDefinition : currencies) {
            String c = currencyDefinition.getCode() + "-" + currencyDefinition.getName();
            currencyList.addItem(c);
        }
        contentPanel.addComponent(currencyList);

        send = new Button("Go on!").addTo(contentPanel);

        this.setComponent(contentPanel);
    }

    public String getName(){
        return name.getText();
    }

    public String getSelectedCurrency(){
        return currencyList.getSelectedItem();
    }

    public void addActionListener(Button.Listener listener){
        send.addListener(listener);
    }
}
