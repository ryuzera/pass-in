package rocketseat.com.pass_in.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import rocketseat.com.pass_in.domain.attendee.exceptions.AttendeeAlreadyExistException;
import rocketseat.com.pass_in.domain.attendee.exceptions.AttendeeNotFoundException;
import rocketseat.com.pass_in.domain.checkin.exceptions.CheckInAlreadyExistException;
import rocketseat.com.pass_in.domain.event.exceptions.EventFullException;
import rocketseat.com.pass_in.domain.event.exceptions.EventNotFoundException;
import rocketseat.com.pass_in.dto.general.ErrorResponseDTO;

@ControllerAdvice
public class ExceptionEntityHandler {
    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity handleEventNotFound(EventNotFoundException exception) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(EventFullException.class)
    public ResponseEntity<ErrorResponseDTO> handleEventFull(EventFullException exception) {
        return ResponseEntity.badRequest().body(new ErrorResponseDTO(exception.getMessage()));
    }

    @ExceptionHandler(AttendeeNotFoundException.class)
    public ResponseEntity handleAttendeeNotFound(AttendeeNotFoundException exception) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(AttendeeAlreadyExistException.class)
    public ResponseEntity handleAttendeeAlreadyExists(AttendeeAlreadyExistException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @ExceptionHandler(CheckInAlreadyExistException.class)
    public ResponseEntity handleCheckinAlreadyExists(CheckInAlreadyExistException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
}
