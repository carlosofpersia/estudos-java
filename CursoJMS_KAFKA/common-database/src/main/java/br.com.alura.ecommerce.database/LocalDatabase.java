package br.com.alura.ecommerce.database;

import java.io.IOException;
import java.sql.*;

public class LocalDatabase {

    private final Connection connection;

    public LocalDatabase(String dbname) throws SQLException {
        //users_database
        String url = "jdbc:sqlite:target/"+dbname+".db";
        connection = DriverManager.getConnection(url);
    }

    // yes, this is way too generic
    // according to your database tool, avoid injection.
    public void createIfNotExists(String sql) {
        try {
            // "create table Users ( uuid varchar (200) primary key, email varchar(200)  )"
            connection.createStatement().execute(sql);
        } catch (SQLException ex) {
            // be careful, the sql could be wrong, be realllly careful
            ex.printStackTrace();
        }
    }

    private PreparedStatement prepare(String statement, String[] params) throws SQLException {
        var prepareStatement = connection.prepareStatement(statement);
        for (int i = 0; i < params.length; i++) {
            prepareStatement.setString(i+1, params[i]);
        }
        return prepareStatement;
    }

    public boolean update(String statement, String ... params ) throws SQLException {
        // var statement = "insert into Users (uuid, email) values (?, ? )";
        // insert.setString(1, uuid);
        // insert.setString(2, email);
        return prepare(statement, params).execute();
    }

     public ResultSet query ( String statement, String ... params ) throws SQLException {
         // var statement = "select uuid from Users where email = ? limit 1"
         // exists.setString(1, email);
         return  prepare(statement, params).executeQuery();
     }

     public void close() throws SQLException {
        connection.close();
     }

}
