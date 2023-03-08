package ordr.yellow.dataseed;

import ordr.yellow.offer.Event;
import ordr.yellow.offer.Market;
import ordr.yellow.offer.OfferRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaDataWriter implements DataWriter {

    private final OfferRepository offerRepository;

    public JpaDataWriter(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public void write(DataContent dataContent) {
        // write markets
        List<Market> markets = dataContent.getMarkets();
        markets.forEach(market -> {
            this.offerRepository.getMarketOutcomeRepository().saveAll(market.getOutcomes());
        });

        this.offerRepository.getMarketRepository().saveAll(markets);

        // write events
        List<Event> events = dataContent.getEvents();
        events.forEach(event -> {
            event.getMarkets().forEach(market -> {
                this.offerRepository.getEventMarketOutcomeRepository().saveAll(market.getOutcomes());
            });

            this.offerRepository.getEventMarketRepository().saveAll(event.getMarkets());
        });

        this.offerRepository.getEventRepository().saveAll(events);
    }
}
