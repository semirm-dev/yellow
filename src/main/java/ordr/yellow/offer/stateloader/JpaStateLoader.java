package ordr.yellow.offer.stateloader;

import ordr.yellow.offer.Event;
import ordr.yellow.offer.Market;
import ordr.yellow.offer.OfferRepository;
import ordr.yellow.offer.StateLoader;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaStateLoader implements StateLoader {

    private final OfferRepository offerRepository;

    public JpaStateLoader(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public List<Market> loadMarkets() {
        return this.offerRepository.getMarketRepository().findAll();
    }

    @Override
    public List<Event> loadEvents() {
        return this.offerRepository.getEventRepository().findAll();
    }
}
