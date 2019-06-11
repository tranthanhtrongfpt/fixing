
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author HAT team Group 3 Nguyen Dong Hung, Ho Duy Anh, Tran Thanh Trong
 */
public class CategoryModel {

    private String tableName = "Category";
    private Connection conn;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private String sqlStr;
    private ArrayList<Category> cates;

    public CategoryModel() throws SQLException {
        try {
            conn = DataConnection.getConnection();
            st = conn.createStatement();
            pst = null;
            rs = null;
            sqlStr = "";
            cates = new ArrayList<>();
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    public void load() throws SQLException {
        try {
            sqlStr = "SELECT * FROM " + tableName + ";";
            rs = st.executeQuery(sqlStr);
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int id = rs.getInt("ID");
                    String name = rs.getString("Name");
                    boolean status = rs.getBoolean("Status");
                    cates.add(new Category(id, name, status));
                }
            }
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Function for add the new category
     * @param Name
     * @param Status
     * @return 
     * @throws java.sql.SQLException
     */
    public boolean add(String Name, boolean Status) throws SQLException {
        try {
            sqlStr = "INSERT INTO " + tableName + " VALUES (null,?,?);";
            pst = conn.prepareStatement(sqlStr);
            pst.setString(1, Name);
            pst.setBoolean(2, Status);
            pst.executeUpdate();
            int sz = cates.size();
            cates.add(new Category(sz, Name, Status));
            return true;
        } catch (SQLException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * function for update
     *
     * @param id
     * @param name
     * @param status
     * @return
     */
    public boolean update(int id, String name, boolean status) {
        try {
            sqlStr = "UPDATE " + tableName + " where `ID`=? VALUES (?,?,?);";
            pst = conn.prepareStatement(sqlStr);
            pst.setInt(1, id);
            pst.setInt(2, id);
            pst.setString(3, name);
            pst.setBoolean(4, status);
            pst.executeUpdate();
            cates.set(id, new Category(id, name, status));
            return true;
        } catch (SQLException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }

}
