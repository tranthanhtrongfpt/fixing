
/**
 * @author HAT team Group 3
 * Nguyen Dong Hung, Ho Duy Anh, Tran Thanh Trong
 */
public class ArticleException extends Exception {

    public ArticleException(String message) {
        super("Comment Exception: " + message);
    }
}
