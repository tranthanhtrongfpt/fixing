

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
