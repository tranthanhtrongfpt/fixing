package Class;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author HAT team Group 3 Nguyen Dong Hung, Ho Duy Anh, Tran Thanh Trong
 */
public class CategoryModel {

    //declare some variables
    private String tableName = "Category";
    private Connection conn;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private String sqlStr;
    private ArrayList<Category> cates;

    /**
     * Constructor for initial the things
     *
     * @throws SQLException
     */
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
    public ArrayList<Category> getCates(){
        return cates;
    }

    /**
     * Load function for loading the stuff
     *
     * @throws SQLException
     */
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
     *
     * @param Name
     * @param Status
     * @return
     * @throws java.sql.SQLException
     */
    public boolean add(String Name, boolean Status) throws SQLException {
        try {
            sqlStr = "INSERT INTO " + tableName + " (`ID`, `NAME`, `Status`) VALUES (null,?,?);";
            pst = conn.prepareStatement(sqlStr, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, Name);
            pst.setBoolean(2, Status);
            pst.executeUpdate();
            rs = pst.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                cates.add(new Category(id, Name, Status));
            }
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
            sqlStr = "UPDATE " + tableName + " SET `ID`=?,`NAME`=?,`Status`=? where `ID`=?;";//UPDATE `category` SET `ID`=1,`NAME`="Super Word",`Status`=true WHERE `ID`=1
            pst = conn.prepareStatement(sqlStr);
            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setBoolean(3, status);
           
            pst.setInt(4, id);
            pst.executeUpdate();
            cates.set(id, new Category(id, name, status));
            return true;
        } catch (SQLException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * get article function
     *
     * @param la
     * @param id
     * @return
     */
    public ArrayList<Article> getArticlesByCateID(ArrayList<Article> la, int id) {
        ArrayList<Article> list = new ArrayList<>();
        for (int i = 0; i < la.size(); i++) {
            if (la.get(i).getCateID() == id) {
                list.add(la.get(i));
            }
        }
        if (list.isEmpty()) {
            return null;
        } else {
            return list;
        }
    }

}
