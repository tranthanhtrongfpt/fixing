
/**
 * @author HAT team Group 3
 * Nguyen Dong Hung, Ho Duy Anh, Tran Thanh Trong
 */
public class CommentException extends Exception {

    /**
     * Class for mention the exception
     *
     * @param message
     */
    public CommentException(String message) {
        super("Comment Exception: " + message);
    }
}
