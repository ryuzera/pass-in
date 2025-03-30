package rocketseat.com.pass_in.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rocketseat.com.pass_in.domain.attendee.Attendee;
import rocketseat.com.pass_in.domain.checkin.Checkin;
import rocketseat.com.pass_in.dto.attendee.AttendeeDetails;
import rocketseat.com.pass_in.dto.attendee.AttendeesListResponseDTO;
import rocketseat.com.pass_in.repositories.AttendeeRepository;
import rocketseat.com.pass_in.repositories.CheckinRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AttendeeService {
    private AttendeeRepository attendeeRepository;
    private CheckinRepository checkinRepository;

    public List<Attendee> getAllAttendeesFromEvent(String eventId) {
        return this.attendeeRepository.findByEventId(eventId);
    }

    public AttendeesListResponseDTO getEventsAttendee(String eventId) {
        List<Attendee> attendeeList = this.getAllAttendeesFromEvent(eventId);

        List<AttendeeDetails> attendeeDetailsList = attendeeList.stream().map(attendee -> {
                    Optional<Checkin> checkIn = this.checkinRepository.findByAttendeeId(attendee.getId());
                    LocalDateTime checkedInAt = checkIn.<LocalDateTime>map(Checkin::getCreatedAt).orElse(null);
                    return new AttendeeDetails(attendee.getId(), attendee.getName(), attendee.getEmail(), attendee.getCreatedAt(), checkedInAt);
                }).toList();

        return new AttendeesListResponseDTO(attendeeDetailsList);
    }
}
