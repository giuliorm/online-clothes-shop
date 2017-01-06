package ru.juriasan.clothshop.services;

import ru.juriasan.clothshop.database.DatabaseContextHolder;

/**
 * Created by GiulioRM on 12/28/2016.
 */
public class ServiceContextHolder {

    private ServiceContextHolder() {

    }
    private static UserService userService;
    private static CartService cartService;
    private static ShopService shopService;

    public static synchronized UserService getUserService () {
        if (userService == null) {
            userService = new UserServiceImpl(DatabaseContextHolder.getUserRepository());
        }
        return userService;
    }

    public static synchronized ShopService getShopService () {
        if (shopService == null) {
            shopService = new ShopServiceImpl(DatabaseContextHolder.getShopRepository());
        }
        return shopService;
    }

    public static synchronized CartService getCartService () {
        if (cartService == null) {
            cartService = new CartServiceImpl(DatabaseContextHolder.getCartRepository());
        }
        return cartService;
    }
}
