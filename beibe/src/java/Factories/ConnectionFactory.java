package Factories;


import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/testeJava",
                    "postgres", "123");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
