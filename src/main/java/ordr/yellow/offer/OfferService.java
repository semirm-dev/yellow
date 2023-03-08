package ordr.yellow.offer;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

// expose http api with events [event markets, event market outcomes]
// can be filtered by startsAt
//
// load initial data from .json files to database
// load initial state from database
// data will then be updated from kafka
//
// offer service will keep track of app state
// linkedlist to store all events

@Service
public class OfferService {

    private final StateLoader stateLoader;

    private List<Event> events = new LinkedList<>();

    public OfferService(StateLoader stateLoader) {
        this.stateLoader = stateLoader;
    }

    public String healthz() {
        return "ok";
    }

    public void loadState() {
        this.events = this.stateLoader.load();
    }

    public List<Event> getEvents() {
        return this.events;
    }

    // TODO: listen for markets and events kafka topics

    // TODO: update local state (events) with newly received markets and events from kafka
}
