package rocketseat.com.pass_in.domain.checkin.exceptions;

public class CheckInAlreadyExistException extends RuntimeException {
    public CheckInAlreadyExistException(String message) {
        super(message);
    }
}
