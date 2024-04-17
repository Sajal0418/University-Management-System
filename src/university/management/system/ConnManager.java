package university.management.system;

import java.sql.*;

public class ConnManager {

    private static Conn instance; // Static member to hold the singleton instance

    // Private constructor to prevent instantiation from outside
    private ConnManager() {}

    // Static method to get the Singleton instance of Conn class
    public static Conn getInstance() {
        // If the instance is null, create a new one
        if (instance == null) {
            instance = new Conn();
        }
        return instance;
    }
}
