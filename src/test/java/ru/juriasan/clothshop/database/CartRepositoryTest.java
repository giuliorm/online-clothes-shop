package ru.juriasan.clothshop.database;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.juriasan.clothshop.database.repository.CartRepository;
import ru.juriasan.clothshop.database.repository.ShopItemRepository;
import ru.juriasan.clothshop.domain.ShopItem;

import java.util.List;

/**
 * Created by GiulioRM on 1/6/2017.
 */
public class CartRepositoryTest {

    PostgresDbClient client;
    public CartRepositoryTest() {
        this.client = new PostgresDbClient("127.0.0.1",
                5432, "shop", "postgres", "1");
    }
    @Test(enabled = false)
    public void createTest() {
        client.connect();
        if(!client.isConnected())
            Assert.fail();

        ShopItemRepository repo = new ShopItemRepository(client);
        ShopItem newItem = new ShopItem(0);
        newItem.setName("name");
        newItem.setDescription("description");
        newItem.setPrice(0.4f);

        repo.create(newItem);

        List<ShopItem> items = repo.find("name");
        if (items == null)
            Assert.fail();

        ShopItem result = repo.get(items.get(0).getId());

        Assert.assertEquals(result.getName(), newItem.getName());
        Assert.assertEquals(result.getDescription(), newItem.getDescription());
        Assert.assertEquals(result.getPrice(), newItem.getPrice());

        repo.remove(result);
        client.close();
    }
}
