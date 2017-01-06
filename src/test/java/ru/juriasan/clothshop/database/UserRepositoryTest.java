package ru.juriasan.clothshop.database;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.juriasan.clothshop.database.repository.UserRepository;
import ru.juriasan.clothshop.domain.User;

/**
 * Created by GiulioRM on 12/20/2016.
 */
public class UserRepositoryTest {

    @Test(enabled = false, dataProvider = "users")
    public void UserRepositoryGetTest(String id, User expected) {
        PostgresDbClient client = new PostgresDbClient("127.0.0.1",
                5432, "shop", "postgres", "1");
        client.connect();
        if(!client.isConnected())
            Assert.fail();

        UserRepository repo = new UserRepository(client);

        User user = repo.get(id);
        if (id == null || id == "")
            Assert.assertEquals(user, null);
        else {
            Assert.assertEquals(user.getEmail(), expected.getEmail());
            Assert.assertEquals(user.getPassword(), expected.getPassword());
        }
        client.close();
    }

    @Test(enabled = false)
    public void UserRepositoryCreateTest() {
        PostgresDbClient client = new PostgresDbClient("127.0.0.1",
                5432, "shop", "postgres", "1");
        client.connect();
        if(!client.isConnected())
            Assert.fail();

        UserRepository repo = new UserRepository(client);
        User newUser = new User("newuser@mail.ru", "11111111111");
        repo.create(newUser);
        User user = repo.get("newuser@mail.ru");
        Assert.assertEquals(user.getEmail(), newUser.getEmail());
        Assert.assertEquals(user.getPassword(), newUser.getPassword());
        repo.remove(user);

        client.close();
    }

    @DataProvider(name = "users")
    public Object[][] users() {
        return new Object[][] {
                { "giulio.rm95@gmail.com", new User( "giulio.rm95@gmail.com", "12345") },
                { "", null }
        };
    }
}
