package ordr.yellow.offer.stateloader;

import ordr.yellow.offer.Event;
import ordr.yellow.offer.Market;
import ordr.yellow.offer.StateLoader;
import ordr.yellow.offer.repository.EventsRepository;
import ordr.yellow.offer.repository.MarketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaStateLoader implements StateLoader {

    private static final Logger logger = LoggerFactory.getLogger(JpaStateLoader.class);
    private final MarketRepository marketRepository;
    private final EventsRepository eventsRepository;

    public JpaStateLoader(MarketRepository marketRepository, EventsRepository eventsRepository) {
        this.marketRepository = marketRepository;
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<Market> loadMarkets() {
        logger.info("loading markets from jpa datastore");
        return this.marketRepository.findAll();
    }

    @Override
    public List<Event> loadEvents() {
        logger.info("loading events from jpa datastore");
        return this.eventsRepository.findAll();
    }
}
