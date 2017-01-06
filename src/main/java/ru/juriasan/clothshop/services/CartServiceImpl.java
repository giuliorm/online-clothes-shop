package ru.juriasan.clothshop.services;

import ru.juriasan.clothshop.database.repository.CartRepository;
import ru.juriasan.clothshop.domain.Cart;
import ru.juriasan.clothshop.domain.ShopItem;
import ru.juriasan.clothshop.domain.User;

/**
 * Created by GiulioRM on 12/27/2016.
 */
public class CartServiceImpl implements CartService {

    CartRepository cartRepository;
    public CartServiceImpl(CartRepository repository) {
        cartRepository =  repository;
    }
    @Override
    public void create(Cart cart) {
        cartRepository.create(cart);
    }

    @Override
    public void update(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public Cart get(long id) {
        return cartRepository.get(id);
    }
}
