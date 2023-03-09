package ns.yellow.offer;

import lombok.Getter;
import lombok.Setter;
import ns.yellow.offer.repository.*;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class OfferRepository {
    private final MarketRepository marketRepository;
    private final MarketOutcomeRepository marketOutcomeRepository;
    private final EventRepository eventRepository;
    private final EventMarketRepository eventMarketRepository;
    private final EventMarketOutcomeRepository eventMarketOutcomeRepository;

    public OfferRepository(
            MarketRepository marketRepository,
            MarketOutcomeRepository marketOutcomeRepository,
            EventRepository eventRepository,
            EventMarketRepository eventMarketRepository,
            EventMarketOutcomeRepository eventMarketOutcomeRepository
    ) {
        this.marketRepository = marketRepository;
        this.marketOutcomeRepository = marketOutcomeRepository;
        this.eventRepository = eventRepository;
        this.eventMarketRepository = eventMarketRepository;
        this.eventMarketOutcomeRepository = eventMarketOutcomeRepository;
    }
}
