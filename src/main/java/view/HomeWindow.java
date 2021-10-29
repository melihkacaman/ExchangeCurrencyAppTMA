package view;

import com.googlecode.lanterna.gui2.*;
import model.FavouriteCurrency;

import java.util.List;

public class HomeWindow extends BasicWindow {
    public HomeWindow(String title, List<FavouriteCurrency> currencies) {
        super(title);

        Panel contentPanel = new Panel();
        contentPanel.setLayoutManager(new GridLayout(2));
        contentPanel.addComponent(new Label("Name:"));
        contentPanel.addComponent(new TextBox());
        contentPanel.addComponent(new Label("Favourite Currency:"));
        // TODO: 10/29/2021 fill combobox with currencies  

    }
}
