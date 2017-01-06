package ru.juriasan.clothshop.database;

import ru.juriasan.clothshop.database.repository.CartRepository;
import ru.juriasan.clothshop.database.repository.ShopItemRepository;
import ru.juriasan.clothshop.database.repository.UserRepository;
import ru.juriasan.clothshop.domain.ShopItem;

/**
 * Created by GiulioRM on 12/28/2016.
 */
public class DatabaseContextHolder {

    private static DbClient client = null;
    private static UserRepository userRepository;
    private static CartRepository cartRepository;
    private static ShopItemRepository shopItemRepository;
    private DatabaseContextHolder() {
    }

    private static synchronized DbClient getClient() {
        if (client == null) {
            client = new PostgresDbClient("127.0.0.1",
                    5432, "shop", "postgres", "1");
            client.connect();
        }
        return client;
    }

    public static synchronized UserRepository getUserRepository() {
        DbClient client = getClient();
        if (userRepository == null) {
            userRepository = new UserRepository(client);
        }
        return userRepository;
    }

    public static synchronized ShopItemRepository getShopRepository() {
        DbClient client = getClient();
        if (shopItemRepository == null) {
            shopItemRepository = new ShopItemRepository(client);
        }
        return shopItemRepository;
    }

    public static synchronized CartRepository getCartRepository() {
        DbClient client = getClient();
        UserRepository userRepo = getUserRepository();
        ShopItemRepository shopItemRepo = getShopRepository();

        if (cartRepository == null) {
            cartRepository = new CartRepository(client, userRepo, shopItemRepo);
        }
        return cartRepository;
    }
}
