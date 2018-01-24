/*
 * Class InvalidEntry Exeption.
 */
package songmaker;

/**
 *
 * @author Kathleen Hess
 */
public class InvalidEntryException extends Exception {

    /**
     * Creates a new instance of
     * <code>InvalidEntryException</code> without detail message.
     */
    public InvalidEntryException() {
    }

    /**
     * Constructs an instance of
     * <code>InvalidEntryException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidEntryException(String msg) {
        super(msg);
    }
}
