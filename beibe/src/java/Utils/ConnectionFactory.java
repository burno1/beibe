/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author Erick Alessi
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection() {
        String host = "jdbc:mysql://localhost/web2";
        String user = "root";
        String password = "admin";
        try {
            return DriverManager.getConnection(
                    host, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
