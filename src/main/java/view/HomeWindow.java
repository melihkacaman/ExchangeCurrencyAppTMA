package view;

import com.googlecode.lanterna.gui2.*;

public class HomeWindow extends BasicWindow {
    public HomeWindow(String title) {
        super(title);

        Panel contentPanel = new Panel();
        contentPanel.setLayoutManager(new GridLayout(2));
        contentPanel.addComponent(new Label("Name:"));
        contentPanel.addComponent(new TextBox());
        contentPanel.addComponent(new Label("Favourite Currency:"));


    }
}
