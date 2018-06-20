package inspera.parser.exception;

/**
 * Exception to denote when two examinations objects in comparison are not the same
 * i.e. based on id
 */
public class NonMatchingEntityException extends RuntimeException {

    public NonMatchingEntityException(String message) {
        super(message);
    }

}
