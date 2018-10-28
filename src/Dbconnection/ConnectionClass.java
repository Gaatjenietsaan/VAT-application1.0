package Dbconnection;

        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.util.Properties;

public class ConnectionClass {

    private static Connection connection;

    public static Connection connect() {
        if (connection != null) {
            return connection;
        }

        String dbName = "VATdb";
        String userName = "root";
        String password = "";

        Properties properties = new Properties();
        properties.put("database", dbName);
        properties.put("user", userName);
        properties.put("password", password);
        properties.put("serverTimezone", "UTC");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, properties);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
