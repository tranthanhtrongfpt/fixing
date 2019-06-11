
/**
 * @author HAT team Group 3
 * Nguyen Dong Hung, Ho Duy Anh, Tran Thanh Trong
 */
public class CategoryException extends Exception {

    /**
     * Class for mention the exception
     * @param message 
     */
    public CategoryException(String message) {
        super("Category Exception: " + message);
    }
}
