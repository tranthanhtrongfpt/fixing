
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author HAT team 
 * Group 3 Nguyen Dong Hung, Ho Duy Anh, Tran Thanh Trong
 */
public class DataConnection {

    //connection
    private static Connection conn;
    //get url
    private static String URL = "jdbc:mysql://localhost:3306/";
    //get user
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
            return conn;
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * check if data is connect or not
     *
     * @return
     * @throws SQLException
     */
    public static boolean isConnection() throws SQLException {
        try {
            return getConnection() != null;
        } catch (SQLException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * close connection
     *
     * @throws SQLException
     */
    public static void closeConnection() throws SQLException {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }
}
