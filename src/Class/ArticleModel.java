package Class;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;


/**
 * @author HAT team Group 3 Nguyen Dong Hung, Ho Duy Anh, Tran Thanh Trong
 */
public class ArticleModel {

    //declare some variables
    private String tableName = "article";
    private Connection conn;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private String sqlStr;
    private ArrayList<Article> articles;

    public ArrayList<Article> getsArticleList() {
        return articles;
    }

    /**
     * Article constructor
     *
     * @throws SQLException
     */
    public ArticleModel() throws SQLException {
        try {
            conn = DataConnection.getConnection();
            st = conn.createStatement();
            pst = null;
            rs = null;
            sqlStr = "";
            articles = new ArrayList<>();
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
            sqlStr = "SELECT * FROM " + tableName + ";";
            rs = st.executeQuery(sqlStr);
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int Id = rs.getInt("ID");
                    String content = rs.getString("Content");
                    int Main_Author_ID = rs.getInt("Main_Author_ID");
                    int Editor_ID = rs.getInt("Editor_ID");
                    String Date_Pub = rs.getString("Date_Pub");
                    
                    int Cate_ID = rs.getInt("Cate_ID");
                    String Des_Pic = rs.getString("Des_Pic");
                    String Des_Text = rs.getString("Des_text");
                    String Title = rs.getString("Title");
                    boolean status = rs.getBoolean("Status");
                    articles.add(new Article(Id, Main_Author_ID, Editor_ID, Cate_ID, content, Date_Pub, Des_Text, Des_Pic, Title, status));
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
     *
     * @param iD
     * @param content
     * @param mainAuthorID
     * @param cateID
     * @param editorID
     * @param datePub
     * @param destext
     * @param desPic
     * @param title
     * @param status
     * @return
     * @throws java.sql.SQLException
     */
    public boolean add(int iD, int mainAuthorID, int editorID, int cateID, String content, String datePub, String destext, String desPic, String title, boolean status)
            throws SQLException, Exception {
        try {
            sqlStr = "INSERT INTO " + tableName + " VALUES (null,?,?,?,?,?,?,?,?,?);";
            pst = conn.prepareStatement(sqlStr, Statement.RETURN_GENERATED_KEYS);
            int id = articles.get(articles.size() - 1).getID() + 1;
            pst.setInt(1, id);
            pst.setString(2, content);
            pst.setInt(3, mainAuthorID);
            pst.setInt(4, editorID);
            pst.setString(5,  datePub);
            pst.setInt(6, cateID);
            pst.setString(7, desPic);
            pst.setString(8, destext);
            pst.setString(9, title);
            pst.setBoolean(10, status);
            pst.executeUpdate();
            rs = pst.getGeneratedKeys();
            if (rs.next()) {
                int idNew = rs.getInt(1);
                articles.add(new Article(idNew, mainAuthorID, editorID, cateID, content, datePub, destext, desPic, title, status));
            }
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
     *
     * @param iD
     * @param content
     * @param editorID
     * @param cateID
     * @param mainAuthorID
     * @param datePub
     * @param destext
     * @param desPic
     * @param title
     * @param status
     * @return
     * @throws java.sql.SQLException
     */
    public boolean update(int iD, int mainAuthorID, int editorID, int cateID, String content, String datePub, String destext, String desPic, String title, boolean status)
            throws SQLException, Exception {
        try {
            sqlStr = " UPDATE " + tableName + " where `ID`=? VALUES (?,?,?,?,?,?,?,?,?);";
            pst = conn.prepareStatement(sqlStr);
            int id = articles.get(articles.size() - 1).getID() + 1;
            pst.setInt(1, id);
            pst.setString(2, content);
            pst.setInt(3, mainAuthorID);
            pst.setInt(4, editorID);
            pst.setString(5, datePub);
            pst.setInt(6, cateID);
            pst.setString(7, desPic);
            pst.setString(8, destext);
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
     *
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
     *
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
     *
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
     *
     * @param name
     */
    public Article searchByName(String title) {
        for (int i = 0; i < articles.size(); i++) {
            Article b = articles.get(i);
            if (b.getTittle() == title) {
                return articles.get(i);
            }
        }
        return null;
    }

    /**
     * Search by Cate
     *
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
     *
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
     *
     * @param datePub
     * @return
     */
    public ArrayList<Article> searchByDatePublic(Date datePub) {
        ArrayList<Article> list = new ArrayList<>();
        for (int i = 0; i < articles.size(); i++) {
            if (datePub.equals(articles.get(i).getDatePub())) {
                list.add(articles.get(i));
            }
        }
        if (list.isEmpty()) {
            return null;
        } else {
            return list;
        }
    }

    /**
     * sortbyDate
     *
     * @return
     */
    public ArrayList<Article> sortByDate() {
        ArrayList<Article> list = new ArrayList<>();
        for (int i = 0; i < articles.size(); i++) {
            list.add(articles.get(i));
        }
        for (int i = 0; i < articles.size(); i++) {
            for (int j = 0; j < articles.size() - i; j++) {
//                if (articles.get(j).getDatePub().after(articles.get(j + 1).getDatePub())) {
//                    Article a = list.get(j);
//                    list.set(j, list.get(j + 1));
//                    list.set(j + 1, a);
//                }
            }
        }
        if (list.isEmpty()) {
            return null;
        } else {
            return list;
        }
    }

    /**
     * get 10 latest articles
     *
     * @return
     */
    public ArrayList<Article> get10latestArticle() {
        ArrayList<Article> list = new ArrayList<>();
        int sz = articles.size();
        for (int i = 0; i < 10; i++) {
            list.add(articles.get(sz));
            sz--;
        }
        if (list.isEmpty()) {
            return null;
        } else {
            return list;
        }
    }

    /**
     * updater rows per page
     *
     * @param rows
     */
    public int updateRowsPerPage(int rows) {
        return rows;
    }

    /**
     * toString articles
     *
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

    /**
     * return list of object
     *
     * @return
     */
    public ArrayList<Article> getArticles() {
        return articles;
    }
}
