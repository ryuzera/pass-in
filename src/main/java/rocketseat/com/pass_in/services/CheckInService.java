package rocketseat.com.pass_in.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rocketseat.com.pass_in.domain.attendee.Attendee;
import rocketseat.com.pass_in.domain.checkin.Checkin;
import rocketseat.com.pass_in.domain.checkin.exceptions.CheckInAlreadyExistException;
import rocketseat.com.pass_in.repositories.CheckinRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CheckInService {
    private final CheckinRepository checkinRepository;

    public void registerCheckIn(Attendee attendee){
        this.verifyCheckInExists(attendee.getId());
        Checkin newCheckin = new Checkin();
        newCheckin.setAttendee(attendee);
        newCheckin.setCreatedAt(LocalDateTime.now());
        this.checkinRepository.save(newCheckin);
    }

    private void verifyCheckInExists(String attendeeId) {
        Optional<Checkin> isCheckedIn = this.checkinRepository.findByAttendeeId(attendeeId);
        if (isCheckedIn.isPresent()) throw new CheckInAlreadyExistException("Attendee with id: " + attendeeId + " already exists!");
    }
}
