package hu.petrik.adatbaziskonzol;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DagDB {
    private Connection connection;
    private static String DB_DRIVER = "mysql";
    private static String DB_HOST = "localhost";
    private static String DB_PORT = "3306";
    private static String DB_USERNAME = "root";
    private static String DB_PASSWORD = "";
    private static String DB_NAME = "java";

    public DagDB() throws SQLException {
        String url = String.format("jdbc:%s://%s:%s/%s", DB_DRIVER, DB_HOST, DB_PORT, DB_NAME);
        connection = DriverManager.getConnection(url, DB_USERNAME, DB_PASSWORD);
    }

    public List<Dog> getDogs() throws SQLException {
        List<Dog> dogs = new ArrayList<>();
        String sql = "SELECT * FROM dogs";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            int id = result.getInt("id");
            String name = result.getString("name");
            int age = result.getInt("age");
            String breed = result.getString("breed");
            Dog dog = new Dog(id, name, age, breed);
            dogs.add(dog);
        }
        return dogs;
    }
}
