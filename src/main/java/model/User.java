package model;

public class User {
    private int id;
    private String name;
    private FavouriteCurrency favouriteCurrency;

    public User(int id, String name, FavouriteCurrency favouriteCurrency) {
        this.id = id;
        this.name = name;
        this.favouriteCurrency = favouriteCurrency;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public FavouriteCurrency getFavouriteCurrency() {
        return favouriteCurrency;
    }
}
