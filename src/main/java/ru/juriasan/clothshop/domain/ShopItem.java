package ru.juriasan.clothshop.domain;

/**
 * Created by GiulioRM on 12/6/2016.
 */
public class ShopItem {
    private long id;
    private String name;
    private String description;
    private float price;

    public ShopItem(long id) {
        this.id = id;
    }

    public long getId() {
        return  this.id;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return this.price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
}
