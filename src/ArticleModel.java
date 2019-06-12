
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author HAT team 
 * Group 3 Nguyen Dong Hung, Ho Duy Anh, Tran Thanh Trong
 */
public class ArticleModel {

    //declare some variables
    private String tableName = "Article";
    private Connection conn;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private String sqlStr;
    private ArrayList<Article> articles;

    /**
     * Article constructor
     * @throws SQLException 
     */
    public ArticleModel() throws SQLException {
        try {
            conn = DataConnection.getConnection();
            st = conn.createStatement();
            pst = null;
            rs = null;
            sqlStr = "";
            articles = new ArrayList<Article>();
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
    public void Load() throws SQLException {
        try {
            sqlStr = "SELECT * FROM " + tableName + "";
            rs = st.executeQuery(sqlStr);
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int Id = rs.getInt("ID");
                    String username = rs.getString("Username");
                    String password = rs.getString("Password");
                    String name = rs.getString("Name");
                    String email = rs.getString("Email");
                    String gender = rs.getString("Gender");
                    String birthday = rs.getString("Birthday");
                    String phone = rs.getString("Phone");
                    int role_id = rs.getInt("Role_ID");
                    boolean status = rs.getBoolean("Status");
                    articles.add(new Article(Id, role_id, role_id, role_id, phone, name, gender, email, phone, status));
                }
            }
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * add function for adding the new article
     * @param content
     * @param mainAuthorID
     * @param editorID
     * @param datePub
     * @param CateID
     * @param DesPic
     * @param DesText
     * @param Title
     * @param status
     */
    public boolean add(int iD, int mainAuthorID, int editorID, int cateID, String content, String datePub, String destext, String desPic, String title, boolean status)
            throws SQLException, Exception {
        try {
            sqlStr = "";
            pst = conn.prepareStatement(sqlStr);
            int id = articles.get(articles.size() - 1).getID() + 1;
            pst.setInt(1, id);
            pst.setInt(2, mainAuthorID);
            pst.setInt(3, editorID);
            pst.setInt(4, cateID);
            pst.setString(5, content);
            pst.setString(6, datePub);
            pst.setString(7, destext);
            pst.setString(8, desPic);
            pst.setString(9, title);
            pst.setBoolean(10, status);
            pst.executeUpdate();
            articles.add(new Article(id, mainAuthorID, editorID, cateID, content, datePub, destext, desPic, title, status));
            return true;
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        } finally {
            return false;
        }
    }

    /**
     * update article
     * @param id
     * @param content
     * @param mainAuthorID
     * @param EditorID
     * @param datePub
     * @param CateID
     * @param DesPic
     * @param DesText
     * @param Title
     * @param Status
     */
    public boolean update(int iD, int mainAuthorID, int editorID, int cateID, String content, String datePub, String destext, String desPic, String title, boolean status)
            throws SQLException, Exception {
        try {
            sqlStr = "";
            pst = conn.prepareStatement(sqlStr);
            int id = articles.get(articles.size() - 1).getID() + 1;
            pst.setInt(1, id);
            pst.setInt(2, mainAuthorID);
            pst.setInt(3, editorID);
            pst.setInt(4, cateID);
            pst.setString(5, content);
            pst.setString(6, datePub);
            pst.setString(7, destext);
            pst.setString(8, desPic);
            pst.setString(9, title);
            pst.setBoolean(10, status);
            pst.executeUpdate();
            getArticle(id).setMainAuthorID(mainAuthorID);
            getArticle(id).setEditorID(editorID);
            getArticle(id).setCateID(cateID);
            getArticle(id).setContent(content);
            getArticle(id).setDatePub(datePub);
            getArticle(id).setDesPic(desPic);
            getArticle(id).setTittle(title);
            getArticle(id).setStatus(status);
            return true;
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        } finally {
            return false;
        }
    }

    /**
     * get articles
     * @param ID
     * @return 
     */
    public Article getArticle(int ID) {
        int idx = searchByID(ID);
        if (idx != -1) {
            return this.articles.get(idx);
        } else {
            return null;
        }
    }

    /**
     * remove articles
     * @param id
     */
    public void remove(int ID) {
        int idx = searchByID(ID);
        if (idx != -1) {
            articles.remove(ID);
        }
    }

    /**
     * search by ID
     * @param id
     */
    public int searchByID(int ID) {
        for (int i = 0; i < articles.size(); i++) {
            Article a = articles.get(i);
            if (a.getID() == ID) {
                return i;
            }
        }
        return -1;
    }

    /**
     * search by Name
     * @param name
     */
    public void searchByName(String title) {
        for (int i = 0; i < articles.size(); i++) {
            Article b = articles.get(i);
            if (b.getTittle() == title) {
                System.out.println("Tao cười tao ỉ********");
            } else {
                System.out.println("No data");
            }
        }
    }

    /**
     * Search by Cate
     * @param cateID
     */
    public int searchByCate(int cateID) {
        for (int i = 0; i < articles.size(); i++) {
            Article d = articles.get(i);
            if (d.getCateID() == cateID) {
                return i;
            }
        }
        return -1;
    }

    /**
     * search by author name
     * @param authorName
     */
    public int searchByAuthorName(int mainAuthorID) {
        for (int i = 0; i < articles.size(); i++) {
            Article e = articles.get(i);
            if (e.getMainAuthorID() == mainAuthorID) {
                return i;
            }
        }
        return -1;
    }

    /**
     * search by Date public
     * @param datePub
     */
    public void searchByDatePublic(String datePub) {
        
    }

    public void sortByDate() {
        
    }

    public void get10lastestArticle() {
       
    }

    /**
     * updater rows per page
     * @param rows
     */
    public int updateRowsPerPage(int rows) {
        return rows;
    }

    /**
     * toString articles
     * @return 
     */
    @Override
    public String toString() {
        String str = "";
        for (Article w : articles) {
            str += w.getID() + ". " + w.getMainAuthorID() + ". " + w.getEditorID()
                    + ". " + w.getCateID() + ". " + w.getContent() + ". " + w.getDatePub()
                    + ". " + w.getDestext() + ". " + w.getDesPic()
                    + ". " + w.getTittle() + ". " + w.getStatus() + "\n";
        }
        return str;
    }

}
