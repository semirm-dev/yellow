package ns.yellow.offer.repository;

import ns.yellow.offer.entity.EventMarket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventMarketRepository extends JpaRepository<EventMarket, String> {
}
