package ns.yellow.dataseed;

import ns.yellow.offer.OfferRepository;
import ns.yellow.offer.entity.Event;
import ns.yellow.offer.entity.Market;
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
        writeMarkets(dataContent.getMarkets());
        writeEvents(dataContent.getEvents());
    }

    private void writeMarkets(List<Market> markets) {
        markets.forEach(market -> {
            this.offerRepository.getMarketOutcomeRepository().saveAll(market.getOutcomes());
        });

        this.offerRepository.getMarketRepository().saveAll(markets);
    }

    private void writeEvents(List<Event> events) {
        events.forEach(event -> {
            event.getMarkets().forEach(market -> {
                this.offerRepository.getEventMarketOutcomeRepository().saveAll(market.getOutcomes());
            });

            this.offerRepository.getEventMarketRepository().saveAll(event.getMarkets());
        });

        this.offerRepository.getEventRepository().saveAll(events);
    }
}
