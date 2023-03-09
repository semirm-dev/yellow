package ns.yellow.offer;

import ns.yellow.offer.dto.EventDto;
import ns.yellow.offer.dto.MarketDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class OfferService {

    private static final Logger logger = LoggerFactory.getLogger(OfferService.class);
    private final StateLoader stateLoader;
    private List<MarketDto> markets = new LinkedList<>();
    private List<EventDto> events = new LinkedList<>();

    public OfferService(StateLoader stateLoader) {
        this.stateLoader = stateLoader;
    }

    public String healthz() {
        return "ok";
    }

    public void loadState() {
        logger.info("loading initial app state from datastore");

        this.markets = this.stateLoader.loadMarkets();
        this.events = this.stateLoader.loadEvents();

        logger.info("finished loading initial app state from datastore");
    }

    public List<MarketDto> getMarkets() {
        return this.markets;
    }

    public List<EventDto> getEvents() {
        return this.events;
    }

    // TODO: listen for markets and events kafka topics
    // TODO: update local state of markets and events with newly received markets and events from kafka
}