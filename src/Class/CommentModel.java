package Class;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
     * Constructor for initial the things
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
     * Add the comment
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
            pst = conn.prepareStatement(sqlStr, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, artID);
            pst.setString(2, content);
            pst.setString(3, email);
            pst.setDate(4, (java.sql.Date) dateComment);
            pst.setBoolean(5, status);
            pst.executeUpdate();
            rs = pst.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                coms.add(new Comment(id, artID, content, email, dateComment, status));
            }
            return true;
        } catch (SQLException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Update the comment
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
     * update rows per page
     *
     * @param rows
     * @return
     */
    public int updateRowsPerPage(int rows) {
        return rows;
    }

     /**
     * Sort comment by Date
     * @return 
     */
    public ArrayList<Comment> sortByDateComment(){
        ArrayList<Comment> list = new ArrayList<>();
        System.arraycopy(coms, 0, list, 0, coms.size());
        for (int i = 0; i < coms.size(); i++) {
            for (int j = 0; j < coms.size() - i; j++) {
                if (coms.get(j).getDate_Comment().after(coms.get(j+1).getDate_Comment())) {
                    Comment a = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, a);
                }
            }
        }
        if (list.isEmpty()) {
            return null;
        } else {
            return list;
        }
    }
    /**
     * get commentBy ID
     * @param id
     * @return 
     */
    public Comment getCommentByID(int id) {
        for (int i = 0; i < coms.size(); i++) {
            if (coms.get(i).getID() == id) {
                return coms.get(i);
            }
        }
        return null;
    }

    /**
     * get comment by article ID
     * @param artID
     * @return 
     */
    public ArrayList<Comment> getCommentsByArticleID(int artID) {
        ArrayList<Comment> list = new ArrayList<>();
        for (int i = 0; i < coms.size(); i++) {
            if (coms.get(i).getArt_ID() == artID) {
                list.add(coms.get(i));
            }
        }
        if (list.isEmpty()) {
            return null;
        } else {
            return list;
        }
    }
    /**
     * Sort comment by ID
     * @return 
     */
    public ArrayList<Comment> sortByID(){
        ArrayList<Comment> list = new ArrayList<>();
        System.arraycopy(coms, 0, list, 0, coms.size());
        for (int i = 0; i < coms.size(); i++) {
            for (int j = 0; j < coms.size() - i; j++) {
                if (coms.get(j).getID()>coms.get(j + 1).getID()) {
                    Comment a = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, a);
                }
            }
        }
        if (list.isEmpty()) {
            return null;
        } else {
            return list;
        }
    }
    

}
