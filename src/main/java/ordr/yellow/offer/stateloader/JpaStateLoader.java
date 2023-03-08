package ordr.yellow.offer.stateloader;

import ordr.yellow.offer.Event;
import ordr.yellow.offer.Market;
import ordr.yellow.offer.OfferRepository;
import ordr.yellow.offer.StateLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaStateLoader implements StateLoader {

    private static final Logger logger = LoggerFactory.getLogger(JpaStateLoader.class);
    private final OfferRepository offerRepository;

    public JpaStateLoader(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public List<Market> loadMarkets() {
        logger.info("loading markets from datastore");
        List<Market> markets = this.offerRepository.getMarketRepository().findAll();
        logger.info("finished loading markets from datastore");
        return markets;
    }

    @Override
    public List<Event> loadEvents() {
        logger.info("loading events from datastore");
        List<Event> events = this.offerRepository.getEventRepository().findAll();
        logger.info("finished loading events from datastore");
        return events;
    }
}
