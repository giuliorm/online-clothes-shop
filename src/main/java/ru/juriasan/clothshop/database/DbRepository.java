package ru.juriasan.clothshop.database;

import java.sql.ResultSet;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by GiulioRM on 12/6/2016.
 */
public interface DbRepository<TEntity, TId> {

    DbClient getClient();
    String tableName();
    void create(TEntity entity);
    TEntity get(TId id);
    void save(TEntity entity);
    List<TEntity> find(String searchString);
    void remove(TEntity entity);
    List<TEntity> executeQuery(String query, Function<ResultSet, List<TEntity>> handler);
    int executeUpdate(String query);
}
