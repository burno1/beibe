package Factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    final private static String urlMysql = "jdbc:mysql://localhost/beibe";
    final private static String userMysql = "root";
    final private static String passwordMysql = "admin";

    final private static String urlPost = "jdbc:postgresql://localhost:5432/testeJava";
    final private static String userPost = "postgres";
    final private static String passwordPost = "123";

    static public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(urlMysql, userMysql, passwordMysql);
//            Class.forName("org.postgresql.Driver");
//            con = DriverManager.getConnection(urlPost, userPost, passwordPost);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
