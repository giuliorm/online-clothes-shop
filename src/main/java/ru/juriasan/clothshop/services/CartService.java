package ru.juriasan.clothshop.services;

import ru.juriasan.clothshop.domain.Cart;
import ru.juriasan.clothshop.domain.ShopItem;
import ru.juriasan.clothshop.domain.User;

import java.util.List;

/**
 * Created by GiulioRM on 12/27/2016.
 */
public interface CartService {

    void create(Cart cart);
    void update(Cart cart);
    Cart get(long id);
    List<Cart> getAllForUser(User user);
    void remove(long id);
    void remove(Cart cart);
}
