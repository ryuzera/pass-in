package rocketseat.com.pass_in.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rocketseat.com.pass_in.domain.attendee.Attendee;

public interface AttendeeRepository extends JpaRepository<Attendee, String> {
}
