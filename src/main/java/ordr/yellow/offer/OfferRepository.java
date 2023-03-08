package ordr.yellow.offer;

import lombok.Getter;
import lombok.Setter;
import ordr.yellow.offer.repository.EventsRepository;
import ordr.yellow.offer.repository.MarketRepository;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class OfferRepository {
    private final MarketRepository marketRepository;
    private final EventsRepository eventsRepository;

    public OfferRepository(MarketRepository marketRepository, EventsRepository eventsRepository) {
        this.marketRepository = marketRepository;
        this.eventsRepository = eventsRepository;
    }
}
