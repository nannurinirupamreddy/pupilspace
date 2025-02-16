/**
 * The IdInvalidException class is a custom exception that is thrown
 * when an invalid student ID is encountered.
 */
public class IdInvalidException extends Exception {

    /**
     * Constructs a new IdInvalidException with the specified detail message.
     *
     * @param message The detail message.
     */
    public IdInvalidException(String message) {
        super(message);
    }
}
