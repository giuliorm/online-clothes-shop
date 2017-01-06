package ru.juriasan.clothshop.database.repository;

import org.apache.log4j.Logger;
import ru.juriasan.clothshop.database.DbClient;
import ru.juriasan.clothshop.database.PostgresDbClient;
import ru.juriasan.clothshop.database.DbRepositoryAbs;
import ru.juriasan.clothshop.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by GiulioRM on 12/7/2016.
 */
public class UserRepository extends DbRepositoryAbs<User, String> {

    private DbClient client;

    private static final String TABLE_NAME = "users";
    private static final String GET_FORMAT = "SELECT * FROM " + TABLE_NAME +
            " WHERE email='%s'";
    private static final String CREATE_FORMAT = "INSERT INTO " + TABLE_NAME +
            "(email, password, firstname, lastname, role) VALUES('%s', '%s', '%s', '%s', '%c')";
    private static final String UPDATE_FORMAT = "UPDATE " + TABLE_NAME +
            " SET email='%s', password='%s', firstname='%s', lastname='%s', role='%c' WHERE email='%s'";
    private static final String DELETE_FORMAT = "DELETE FROM " + TABLE_NAME +
            " WHERE email='%s'";
    private static final String FIND_FORMAT = "SELECT * FROM " + TABLE_NAME +
            " WHERE email LIKE '%%%s%%' OR firstname LIKE '%%%s%%' OR" +
            " lastname LIKE '%%%s%%'";

    public UserRepository(DbClient client) {
        super(client);
    }

    private static final Logger logger =
            Logger.getLogger(CartRepository.class.getName());

    @Override
    public DbClient getClient() {
        return this.client;
    }

    @Override
    public String tableName() {
        return TABLE_NAME;
    }

    private List<User> retreiveUser(ResultSet result) throws SQLException {
        ArrayList<User> resultList = new ArrayList<>();
        String email = "email";
        String password = "password";
        String role = "role";
        String lastName = "lastName";
        String firstName = "firstName";
        while (result.next()) {
            //Retrieve by column name
          //  user = new User( result.getString("email"),
              //      result.getString("password"));
            User u = new User(result.getString(email),
                    result.getString(password));
            String roleString = result.getString(role);
            if (roleString != null)
                 u.setRole(roleString.charAt(0));
            u.setFirstName(result.getString(firstName));
            u.setLastName(result.getString(lastName));
            resultList.add(u);
        }
        return resultList;
    }

    @Override
    public User get(String id) {

        String query = String.format(GET_FORMAT, id);

        Function<ResultSet, List<User>> handler = result -> {
            List<User> user = null;
            try {
                user = retreiveUser(result);
            }
            catch(SQLException ex) {
                logger.error(ex.getMessage());
            }
            return user;
        };
        List<User> rez = executeQuery(query, handler);
        return rez.size() > 0 ? rez.get(0) : null;
    }

    @Override
    public void save(User user) {
        String query = String.format(UPDATE_FORMAT,
                user.getEmail(), user.getPassword(), user.getFirstName(), user.getLastName(),
                user.getRole(), user.getEmail());

        executeUpdate(query);
    }

    @Override
    public List<User> find(String searchString) {
        String query = String.format(FIND_FORMAT, searchString, searchString, searchString);
        Function<ResultSet, List<User>> handler = result -> {
            List<User> rez = null;
            try {
                rez = retreiveUser(result);
            }
            catch(SQLException ex) {
                logger.error(ex.getMessage());
            }
            return rez;
        };
        return executeQuery(query, handler);
    }

    @Override
    public void remove(User user) {
        String query = String.format(DELETE_FORMAT,
                user.getEmail());

        executeUpdate(query);
    }

    @Override
    public void create(User user) {
        String query = String.format(CREATE_FORMAT, user.getEmail(),
                user.getPassword(), user.getFirstName(), user.getLastName(), user.getRole());

        executeUpdate(query);
    }
}
