package CustomComponet;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.LinearLayout;
import com.googlecode.lanterna.gui2.Panel;

import java.util.List;

public class CustomListbox extends Panel {
    private List<String> datasource;
    public CustomListbox(List<String> datasource) {
        this.datasource = datasource;
        this.setLayoutManager(new LinearLayout());
        //this.setPreferredSize(new TerminalSize(40,2));
        fillListBox();
    }

    private void fillListBox(){
        int idx = 0;
        for (String item : datasource) {
            this.addComponent(idx, new Label(item));
        }
    }
}
