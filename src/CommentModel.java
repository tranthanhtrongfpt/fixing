
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author HAT team 
 * Group 3 Nguyen Dong Hung, Ho Duy Anh, Tran Thanh Trong
 */
public class CommentModel {

    private String tableName = "Comment";
    private Connection conn;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private String sqlStr;
    private ArrayList<Comment> coms;

    /**
     * 
     * @throws SQLException 
     */
    public CommentModel() throws SQLException {

        try {
            conn = DataConnection.getConnection();
            st = conn.createStatement();
            pst = null;
            rs = null;
            sqlStr = "";
            coms = new ArrayList<>();
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Load function for loading the stuff
     * @throws SQLException 
     */
    public void load() throws SQLException {
        try {
            sqlStr = "SELECT * FROM " + tableName + ";";
            rs = st.executeQuery(sqlStr);
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int id = rs.getInt("ID");
                    int artID = rs.getInt("Art_ID");
                    String content = rs.getString("Content");
                    String email = rs.getString("Email");
                    Date date = rs.getDate("Date_Comment");
                    boolean status = rs.getBoolean("Status");
                    coms.add(new Comment(id, artID, content, email, date, status));
                }
            }
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     *
     * @param artID
     * @param content
     * @param dateComment
     * @param status
     * @param email
     * @return
     */
    public boolean add(int artID, String content, String email, Date dateComment, boolean status) {
        try {
            sqlStr = "INSERT INTO " + tableName + " VALUES (null,?,?,?,?);";
            pst = conn.prepareStatement(sqlStr);
            pst.setInt(1, artID);
            pst.setString(2, content);
            pst.setString(3, email);
            pst.setDate(4, (java.sql.Date) dateComment);
            pst.setBoolean(5, status);
            pst.executeUpdate();
            int sz = coms.size();
            coms.add(new Comment(sz, artID, content, email, dateComment, status));
            return true;
        } catch (SQLException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     *
     * @param id
     * @param artID
     * @param content
     * @param email
     * @param dateComment
     * @param status
     * @return 
     */
    public boolean update(int id, int artID, String content, String email, Date dateComment, boolean status) {
        try {
            sqlStr = "UPDATE " + tableName + " where `ID`=? VALUES (?,?,?,?,?,?);";
            pst = conn.prepareStatement(sqlStr);
            pst.setInt(1, id);
            pst.setInt(2, id);
            pst.setInt(3, artID);
            pst.setString(4, content);
            pst.setString(5, email);
            pst.setDate(6, (java.sql.Date) dateComment);
            pst.setBoolean(7, status);
            pst.executeUpdate();
            coms.set(id, new Comment(id, artID, content, email, dateComment, status));
            return true;
        } catch (SQLException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     *
     * @param rows
     * @return 
     */
    public int updateRowsPerPage(int rows) {
        return rows;
    }

}
