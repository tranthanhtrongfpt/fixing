
import java.util.Date;

/**
 * @author HAT team Group 3 Nguyen Dong Hung, Ho Duy Anh, Tran Thanh Trong
 */
public class ArticleModel {

    public ArticleModel() {
        throw new UnsupportedOperationException();
    }

    public void load() {
        throw new UnsupportedOperationException();
    }

    /**
     *
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
    public void add(String content, int mainAuthorID, int editorID, Date datePub, int CateID, String DesPic, String DesText, String Title, boolean status) {
        throw new UnsupportedOperationException();
    }

    /**
     *
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
    public void update(int id, String content, int mainAuthorID, int EditorID, Date datePub, String CateID, String DesPic, String DesText, String Title, boolean Status) {
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param id
     */
    public void remove(int id) {
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param id
     */
    public void searchByID(int id) {
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param name
     */
    public void searchByName(String name) {
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param cateID
     */
    public void searchByCate(int cateID) {
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param authorName
     */
    public void searchByAuthorName(String authorName) {
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param datePub
     */
    public void searchByDatePublic(String datePub) {
        throw new UnsupportedOperationException();
    }

    public void sortByDate() {
        throw new UnsupportedOperationException();
    }

    public void get10lastestArticle() {
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param rows
     */
    public void updateRowsPerPage(int rows) {
        throw new UnsupportedOperationException();
    }

}
