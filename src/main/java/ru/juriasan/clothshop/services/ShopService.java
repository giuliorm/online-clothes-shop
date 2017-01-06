package ru.juriasan.clothshop.services;

import ru.juriasan.clothshop.domain.Cart;
import ru.juriasan.clothshop.domain.ShopItem;
import ru.juriasan.clothshop.domain.User;

/**
 * Created by GiulioRM on 12/6/2016.
 */
public interface ShopService {
    void create(ShopItem item);
    void update(ShopItem item);
    ShopItem get(long id);
}
