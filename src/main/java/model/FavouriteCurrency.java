package model;

import org.json.simple.JSONObject;

public class FavouriteCurrency {
    private String code;
    private String name;

    public FavouriteCurrency(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
