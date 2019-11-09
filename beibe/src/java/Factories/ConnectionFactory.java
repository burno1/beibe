package Factories;

import java.sql.Connection;
import java.sql.DriverManager;



public class ConnectionFactory {

    final private static String urlMysql = "jdbc:mysql://localhost:3306/beibe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
    final private static String userMysql = "root";
    final private static String passwordMysql = "1234";



    static public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(urlMysql, userMysql, passwordMysql);


        } catch (Exception e) {
            System.out.println("NÃO CONECTO 34503495034950394503495039450349503");
            e.printStackTrace();
        }
        return con;
    }
}
