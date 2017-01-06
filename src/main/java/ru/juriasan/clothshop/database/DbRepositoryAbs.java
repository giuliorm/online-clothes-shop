package ru.juriasan.clothshop.database;

import org.apache.log4j.Logger;
import ru.juriasan.clothshop.database.repository.CartRepository;
import ru.juriasan.clothshop.domain.Cart;
import ru.juriasan.clothshop.domain.ShopItem;
import ru.juriasan.clothshop.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by GiulioRM on 12/20/2016.
 */
public abstract class DbRepositoryAbs<TEntity, TId> implements DbRepository<TEntity, TId> {

    DbClient client;
    public DbRepositoryAbs(DbClient client) {
        this.client = client;
    }
    private static final Logger logger =
            Logger.getLogger(CartRepository.class.getName());
    @Override
    public DbClient getClient() {
        return client;
    }
    @Override
    public List<TEntity> executeQuery(String query,
                                      Function<ResultSet, List<TEntity>> handler) {
        if (query == null || query.equals(""))
            return null;
        List<TEntity> resultEntity = null;
        try {
            Statement stm = this.client.getConnection().createStatement();
            ResultSet result = stm.executeQuery(query);

            if (result != null) {
                logger.info("Query has executed successfully");
                if (handler != null)
                    resultEntity = handler.apply(result);

            } else
                logger.info("Failed execute query \n" + query + "\n " +
                        "or result set is empty");
        }
        catch (SQLException ex) {
            logger.error(ex.getMessage());
        }
        return resultEntity;
    }

    @Override
    public int executeUpdate(String query) {
        if (query == null || query.equals(""))
            return 0;
        int result = 0;
        TEntity resultEntity = null;
        try {
            Statement stm = this.client.getConnection().createStatement();
            result = stm.executeUpdate(query);
        }
        catch (SQLException ex) {
            logger.error(ex.getMessage());
        }
        return result;
    }
    @Override
    public abstract String tableName();

    @Override
    public abstract TEntity get(TId id);

    @Override
    public abstract void save(TEntity tEntity);

    @Override
    public abstract List<TEntity> find(String searchString);
    @Override
    public abstract void remove(TEntity tEntity);
    @Override
    public abstract void create(TEntity tEntity);
}
