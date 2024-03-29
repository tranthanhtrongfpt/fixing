package Class;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author HAT team Group 3 Nguyen Dong Hung, Ho Duy Anh, Tran Thanh Trong
 */
public class DataConnection {

    //get connection
    private static Connection conn;
    //get url
    private static String URL = "jdbc:mysql://localhost:3306/db";
    //get User
    private static String USER = "root";
    //get pass
    private static String PASS = "";

    /**
     * get connection
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        } finally {
            return conn;
        }
    }

    /**
     * check connection
     *
     * @return
     * @throws SQLException
     */
    public static boolean isConnection() throws SQLException {
        try {
            if (getConnection() != null) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }
}
