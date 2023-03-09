package ns.yellow.offer.repository;

import ns.yellow.offer.entity.Market;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketRepository extends JpaRepository<Market, String> {
}
