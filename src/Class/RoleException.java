package Class;


/**
 * @author HAT team Group 3
 * Nguyen Dong Hung, Ho Duy Anh, Tran Thanh Trong
 */
public class RoleException extends Exception {

    /**
     * create exception
     *
     * @param message
     */
    public RoleException(String message) {
        super("Role Exception: " + message);
    }
}
