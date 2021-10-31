package common;

import com.googlecode.lanterna.gui2.WindowBasedTextGUI;
import model.User;

public class Session {
    private Session(){

    }

    public static User activeUser;
    public static WindowBasedTextGUI textGui;
}
