
/**
 * @author HAT team Group 3
 * Nguyen Dong Hung, Ho Duy Anh, Tran Thanh Trong
 */
public class UserException extends Exception {

    /**
     * create Role exception
     *
     * @param message
     */
    public UserException(String message) {
        super("User Exception: " + message);
    }
}