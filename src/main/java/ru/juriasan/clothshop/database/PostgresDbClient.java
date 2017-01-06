package ru.juriasan.clothshop.database;

import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by GiulioRM on 12/7/2016.
 */
public class PostgresDbClient implements DbClient {
    private String user;
    private String password;
    Connection connection;
    private String url;

    private static Logger logger = Logger.getLogger(PostgresDbClient.class.getName());
    public PostgresDbClient(String host, int port, String databaseName, String user,
                            String password) {
        this.user = user;
        this.password = password;
        this.url =  "jdbc:postgresql://" + host + ":" + String.valueOf(port) + "/"
                + databaseName;
    }

    @Override
    public String getDbUrl() {
        return this.url;
    }

    @Override
    public Connection getConnection() {
        return this.connection;
    }

    @Override
    public void connect() {

        logger.info("Trying to connect to db...");

        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            this.connection = DriverManager.getConnection(url, user, password);
          }
         catch(SQLException ex) {
            logger.error(ex.getMessage());
         }
         logger.info("Connected to db with url " + url);
     }

     @Override
     public boolean isConnected() {
         return this.connection != null;
     }

    @Override
    public void close() {
        logger.info("Trying to close the connection " + url);
         try {
             if (this.connection != null)
                 this.connection.close();
             logger.info("connection has been successfully closed.");
         }
         catch (SQLException ex) {
             logger.error(ex.getMessage());
         }
     }
}
