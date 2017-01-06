package ru.juriasan.clothshop.database;

import java.sql.Connection;

/**
 * Created by GiulioRM on 12/7/2016.
 */
public interface DbClient {

    String getDbUrl();
    boolean isConnected();
    Connection getConnection();
    void connect();
    void close();

}
