package rocketseat.com.pass_in.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rocketseat.com.pass_in.domain.event.Event;

public interface EventRepository extends JpaRepository<Event, String> {
}
