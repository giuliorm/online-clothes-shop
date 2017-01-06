package ru.juriasan.clothshop.services;

import ru.juriasan.clothshop.database.repository.ShopItemRepository;
import ru.juriasan.clothshop.domain.ShopItem;

/**
 * Created by GiulioRM on 12/27/2016.
 */
public class ShopServiceImpl implements ShopService {
    ShopItemRepository repository;

    public ShopServiceImpl(ShopItemRepository repository) {
        this.repository = repository;
    }
    @Override
    public void create(ShopItem item) {
        repository.create(item);
    }

    @Override
    public void update(ShopItem item) {
        repository.save(item);
    }

    @Override
    public ShopItem get(long id) {
        return repository.get(id);
    }
}
