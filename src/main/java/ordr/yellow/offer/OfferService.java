package ordr.yellow.offer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class OfferService {

    private static final Logger logger = LoggerFactory.getLogger(OfferService.class);
    private final StateLoader stateLoader;
    private List<Market> markets = new LinkedList<>();
    private List<Event> events = new LinkedList<>();

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

    public List<Market> getMarkets() {
        return this.markets;
    }

    public List<Event> getEvents() {
        // TODO: make sure response corresponds to events.json
        return this.events;
    }

    // TODO: listen for markets and events kafka topics
    // TODO: update local state of markets and events with newly received markets and events from kafka
}
