/**
 * The InvalidAgeException class is a custom exception that is thrown
 * when an invalid student age is encountered.
 */
public class InvalidAgeException extends Exception {

    /**
     * Constructs a new InvalidAgeException with the specified detail message.
     *
     * @param message The detail message.
     */
    public InvalidAgeException(String message) {
        super(message);
    }
}
