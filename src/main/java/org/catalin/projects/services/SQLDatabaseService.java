package org.catalin.projects.services;

/**
 * Created by cci on 17.09.2017.
 */

import java.sql.*;

public class SQLDatabaseService {

    static Connection con = null;
    static int i = 0;
    static Statement statement;

    private static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            if (con == null)
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/firstdb?useSSL=false", "root", "root");
            System.out.println("SQL ... Connected");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void updateRows(String tableName, String column, String value) throws SQLException {
        statement.executeUpdate("UPDATE " + tableName + " SET " + column + "= '" + value + "' WHERE ID=" + i);
    }


    public static void createEmptyRow(String tableName) throws SQLException {
        i++;
        statement.executeUpdate("INSERT INTO " + tableName + "(ID)" + " VALUES (" + i + ")");
    }

    public static void resetRows(String tableName) throws SQLException {
        statement = getConnection().createStatement();
        statement.executeUpdate("TRUNCATE TABLE " + tableName);
    }

}
