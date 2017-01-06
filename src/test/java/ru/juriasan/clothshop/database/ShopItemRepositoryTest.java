package ru.juriasan.clothshop.database;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.juriasan.clothshop.database.repository.ShopItemRepository;
import ru.juriasan.clothshop.database.repository.UserRepository;
import ru.juriasan.clothshop.domain.ShopItem;
import ru.juriasan.clothshop.domain.User;

import java.util.List;

/**
 * Created by GiulioRM on 12/20/2016.
 */
public class ShopItemRepositoryTest {

    @Test(enabled = false)//, dataProvider = "users")
    public void getTest() {
        PostgresDbClient client = new PostgresDbClient("127.0.0.1",
                5432, "shop", "postgres", "1");
        client.connect();
        if(!client.isConnected())
            Assert.fail();

        ShopItemRepository repo = new ShopItemRepository(client);
        long id = 32;
        ShopItem expected = new ShopItem(id);
        expected.setName("aaa");
        expected.setDescription("d1");
        expected.setPrice(0.0f);

        ShopItem item = repo.get(id);
        if (item == null)
            Assert.fail();
        else {
            Assert.assertEquals(item.getName(), expected.getName());
            Assert.assertEquals(item.getDescription(), expected.getDescription());
            Assert.assertEquals(item.getPrice(), expected.getPrice());
        }
        client.close();
    }

    @Test(enabled = false)
    public void createTest() {
        PostgresDbClient client = new PostgresDbClient("127.0.0.1",
                5432, "shop", "postgres", "1");
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
