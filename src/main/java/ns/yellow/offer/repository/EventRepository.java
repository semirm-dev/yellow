package ns.yellow.offer.repository;

import ns.yellow.offer.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, String> {
}
