package ru.juriasan.clothshop.domain;

/**
 * Created by GiulioRM on 12/6/2016.
 */
public class Cart {
    private long id;
    private User user;
    private ShopItem shopItem;

    public Cart() {

    }

    public Cart(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

    public ShopItem getShopItem() {
        return this.shopItem;
    }
    public void setShopItem(ShopItem item) {
        this.shopItem = item;
    }
}
