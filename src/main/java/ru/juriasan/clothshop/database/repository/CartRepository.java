package ru.juriasan.clothshop.database.repository;

import org.apache.log4j.Logger;
import ru.juriasan.clothshop.database.DbClient;
import ru.juriasan.clothshop.database.DbRepositoryAbs;
import ru.juriasan.clothshop.domain.Cart;
import ru.juriasan.clothshop.domain.ShopItem;
import ru.juriasan.clothshop.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by GiulioRM on 12/7/2016.
 */
public class CartRepository extends DbRepositoryAbs<Cart, Long> {

    private DbClient client;
    private static final String TABLE_NAME = "shopitem_user";
    private static final String GET_FORMAT = "SELECT * FROM " + TABLE_NAME +
            " WHERE id=%d";
    private static final String CREATE_FORMAT = "INSERT INTO " + TABLE_NAME +
            "(shopitemid, userid) VALUES(%d, '%s')";
    private static final String UPDATE_FORMAT = "UPDATE " + TABLE_NAME +
            " SET shopitemid=%d, userid='%s' WHERE id=%d";
    private static final String DELETE_FORMAT = "DELETE FROM " + TABLE_NAME +
            " WHERE id=%d";
    private static final String FIND_FORMAT = "SELECT * FROM " + TABLE_NAME +
            " WHERE userid LIKE '%%%s%%'";
    private static final Logger logger =
            Logger.getLogger(CartRepository.class.getName());

    private UserRepository userRepository;
    private ShopItemRepository shopItemRepository;

    public CartRepository(DbClient client,
                          UserRepository userRepository,
                          ShopItemRepository shopItemRepository) {
        super(client);
        this.client = client;
        this.userRepository = userRepository;
        this.shopItemRepository = shopItemRepository;
    }

    @Override
    public DbClient getClient() {
        return this.client;
    }

    @Override
    public String tableName() {

        return TABLE_NAME;
    }

    private List<Cart> retreiveCart(ResultSet result) throws SQLException {
        List<Cart> cart = new ArrayList<>();
        String userId = "userid";
        String shopItemIdName = "shopitemid";
        String userEmail = "";
        Long shopItemId = null;
        while (result.next()) {
            //Retrieve by column name
            //  user = new User( result.getString("email"),
            //      result.getString("password"));

            Cart cartItem = new Cart(result.getInt("id"));
            userEmail = result.getString(userId);
            shopItemId = result.getLong(shopItemIdName);

            User user = userRepository.get(userEmail);
            ShopItem item = shopItemRepository.get(shopItemId);
            cartItem.setUser(user);
            cartItem.setShopItem(item);

            cart.add(cartItem);
        }

        return cart;
    }

    @Override
    public Cart get(Long id) {
        String query = String.format(GET_FORMAT, id);

        Function<ResultSet, List<Cart>> handler = result -> {
            List<Cart> cart = null;
            try {
                cart = retreiveCart(result);
            }
            catch(SQLException ex) {
                logger.error(ex.getMessage());
            }
            return cart;
        };
        List<Cart> rez = executeQuery(query, handler);
        return rez.size() > 0 ? rez.get(0) : null;
    }

    @Override
    public void save(Cart cart) {
        String query = String.format(UPDATE_FORMAT,
                cart.getShopItem().getId(), cart.getUser().getEmail(), cart.getId());

        executeUpdate(query);
    }

    @Override
    public List<Cart> find(String searchString) {
        String query = String.format(FIND_FORMAT, searchString);
        Function<ResultSet, List<Cart>> handler = result -> {
            List<Cart> rez = null;
            try {
                rez = retreiveCart(result);
            }
            catch(SQLException ex) {
                logger.error(ex.getMessage());
            }
            return rez;
        };
        return executeQuery(query, handler);
    }

    @Override
    public void remove(Cart cart) {
        String query = String.format(DELETE_FORMAT,
                cart.getId());

        executeUpdate(query);
    }

    @Override
    public void create(Cart cart) {
        String query = String.format(CREATE_FORMAT, cart.getShopItem().getId(),
                cart.getUser().getEmail());

        executeUpdate(query);
    }

}
