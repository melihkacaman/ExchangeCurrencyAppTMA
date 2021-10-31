package view;

import com.googlecode.lanterna.gui2.*;
import common.CurrencyDefinitionProcess;

import java.util.List;

public class CalculateWindow extends BasicWindow {
    private Button calculateBtn;
    private Button backButton;
    private ComboBox<String> from;
    private ComboBox<String> to;
    private Label resultText;

    public CalculateWindow(String title, List<String> datasourceForCombo) {
        super(title);
        Panel panel = new Panel(new GridLayout(2));

        panel.addComponent(new Label("From:"));
        from = new ComboBox<String>();
        to = new ComboBox<String>();
        for (String s : datasourceForCombo) {
            from.addItem(s);
            to.addItem(s);
        }
        from.addTo(panel);

        panel.addComponent(new Label("To:"));
        to.addTo(panel);

        panel.addComponent(new Label("Result: "));
        resultText = new Label("");
        resultText.addTo(panel);

        calculateBtn = new Button("Calculate!");
        backButton = new Button("Go Back!");
    }
}
