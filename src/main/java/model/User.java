package model;

public class User {
    private int id;
    private String name;
    private CurrencyDefinition currencyDefinition;

    public User(int id, String name, CurrencyDefinition currencyDefinition) {
        this.id = id;
        this.name = name;
        this.currencyDefinition = currencyDefinition;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CurrencyDefinition getFavouriteCurrency() {
        return currencyDefinition;
    }
}
