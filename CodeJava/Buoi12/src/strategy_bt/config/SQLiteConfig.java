package strategy_bt.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConfig {
    private static final String url = "jdbc:sqlite:./database/strategy_bt.db";  // đường dẫn file SQLite
    private Connection cn;

    private SQLiteConfig() {
        try {
            cn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static SQLiteConfig instance = null;

    public static SQLiteConfig getInstance() {
        if (instance == null) {
            instance = new SQLiteConfig();
        }
        return instance;
    }

    public Connection getCn() {
        return cn;
    }
}
