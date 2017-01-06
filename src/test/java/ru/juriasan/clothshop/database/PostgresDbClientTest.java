package ru.juriasan.clothshop.database;

import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by GiulioRM on 12/7/2016.
 */
public class PostgresDbClientTest {

    @Test(enabled = false)
    public void PostgresDbClientTest() {
        PostgresDbClient client = new PostgresDbClient("127.0.0.1",
                5432, "shop", "postgres", "1");
        client.connect();
        if(!client.isConnected())
            Assert.fail();
        client.close();
    }


}
