package ordr.yellow.offer.repository;

import ordr.yellow.offer.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, String> {
}
