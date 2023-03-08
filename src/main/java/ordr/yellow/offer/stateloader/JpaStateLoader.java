package ordr.yellow.offer.stateloader;

import ordr.yellow.offer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JpaStateLoader implements StateLoader {

    private static final Logger logger = LoggerFactory.getLogger(JpaStateLoader.class);

    @Override
    public List<Event> load() {
        logger.info("loading data from jpa datastore");

        Market market = new Market();
        market.setId("m-1");
        market.setName("Market 1");
        market.setStatus(Status.ACTIVE);

        MarketOutcome mOutcome = new MarketOutcome();
        mOutcome.setId("m-outcome-1");
        mOutcome.setName("Market outcome 1");
        mOutcome.setStatus(Status.ACTIVE);

        market.setOutcomes(List.of(mOutcome));

        Event ev = new Event();
        ev.setId("ev-1");
        ev.setName("Event 1");
        ev.setStatus(Status.ACTIVE);
        ev.setStartsAt(new Date());

        EventMarket evMarket = new EventMarket();
        evMarket.setId("ev-market-1");
        evMarket.setStatus(Status.ACTIVE);
        evMarket.setMarket(market);

        EventMarketOutcome evMarketOutcome = new EventMarketOutcome();
        evMarketOutcome.setId("ev-market-outcome-1");
        evMarketOutcome.setStatus(Status.ACTIVE);
        evMarketOutcome.setOdd(2d);

        evMarketOutcome.setOutcome(mOutcome);
        evMarket.setOutcomes(List.of(evMarketOutcome));
        ev.setMarkets(List.of(evMarket));

        return List.of(ev);
    }
}
