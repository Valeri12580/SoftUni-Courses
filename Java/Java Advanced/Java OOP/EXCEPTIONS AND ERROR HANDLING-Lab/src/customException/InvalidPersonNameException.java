package customException;

public class InvalidPersonNameException extends IllegalArgumentException {
    public InvalidPersonNameException() {
        super("The name is invalid");
    }
}
