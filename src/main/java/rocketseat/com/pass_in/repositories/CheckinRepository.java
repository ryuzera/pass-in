package rocketseat.com.pass_in.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rocketseat.com.pass_in.domain.checkin.Checkin;

public interface CheckinRepository extends JpaRepository<Checkin, Integer> {
}
