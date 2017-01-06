package ru.juriasan.clothshop.database.repository;

import org.apache.log4j.Logger;
import ru.juriasan.clothshop.database.DbClient;
import ru.juriasan.clothshop.database.PostgresDbClient;
import ru.juriasan.clothshop.database.DbRepositoryAbs;
import ru.juriasan.clothshop.domain.Cart;
import ru.juriasan.clothshop.domain.ShopItem;
import ru.juriasan.clothshop.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by GiulioRM on 12/7/2016.
 */
public class ShopItemRepository extends DbRepositoryAbs<ShopItem, Long> {

    PostgresDbClient client;

    private static final Logger logger =
            Logger.getLogger(ShopItemRepository.class.getName());

    private static final String TABLE_NAME = "shopitem";
    private static final String GET_FORMAT = "SELECT * FROM " + TABLE_NAME +
            " WHERE id=%d";
    private static final String CREATE_FORMAT = "INSERT INTO " + TABLE_NAME +
            "(name, description, price) VALUES('%s', '%s', %.2f)";
    private static final String UPDATE_FORMAT = "UPDATE " + TABLE_NAME +
            " SET name='%s', description='%s', price=%.2f WHERE id=%d";
    private static final String DELETE_FORMAT = "DELETE FROM " + TABLE_NAME +
            " WHERE id=%d";
    private static final String FIND_FORMAT = "SELECT * FROM " + TABLE_NAME +
            " WHERE name LIKE '%%%s%%' OR description LIKE '%%%s%%'";

    public ShopItemRepository(DbClient client) {
        super(client);
    }
    @Override
    public DbClient getClient() {
        return this.client;
    }

    @Override
    public String tableName() {
        return TABLE_NAME;
    }

    private List<ShopItem> retreiveShopItem(ResultSet result) throws SQLException {
        List<ShopItem> items = new ArrayList<>();
        String name = "name";
        String id = "id";
        String description = "description";
        String price = "price";
        while (result.next()) {
            //Retrieve by column name
            //  user = new User( result.getString("email"),
            //      result.getString("password"));

            ShopItem item = new ShopItem(result.getInt(id));
            item.setName(result.getString(name));
            item.setDescription(result.getString(description));
            item.setPrice(result.getFloat(price));

            items.add(item);
        }

        return items;
    }

    @Override
    public ShopItem get(Long id) {
        String query = String.format(GET_FORMAT, id);

        Function<ResultSet, List<ShopItem>> handler = result -> {
            List<ShopItem> shopItems = null;
            try {
                shopItems = retreiveShopItem(result);
            }
            catch(SQLException ex) {
                logger.error(ex.getMessage());
            }
            return shopItems;
        };
        List<ShopItem> rez = executeQuery(query, handler);
        return rez.size() > 0 ? rez.get(0) : null;
    }

    @Override
    public void save(ShopItem shopItem) {
        String query = String.format(UPDATE_FORMAT,
                shopItem.getName(), shopItem.getDescription(), shopItem.getPrice(),
                shopItem.getId());

        executeUpdate(query);
    }

    @Override
    public List<ShopItem> find(String searchString) {

        String query = String.format(FIND_FORMAT, searchString, searchString);
        Function<ResultSet, List<ShopItem>> handler = result -> {
            List<ShopItem> rez = null;
            try {
                rez = retreiveShopItem(result);
            }
            catch(SQLException ex) {
                logger.error(ex.getMessage());
            }
            return rez;
        };
        return executeQuery(query, handler);

    }

    @Override
    public void remove(ShopItem shopItem) {
        String query = String.format(DELETE_FORMAT,
                shopItem.getId());

        executeUpdate(query);
    }
    @Override
    public void create(ShopItem shopItem) {
        String query = String.format(CREATE_FORMAT, shopItem.getName(),
                shopItem.getDescription(), shopItem.getPrice());

        executeUpdate(query);
    }


}
