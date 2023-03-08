package ordr.yellow.dataseed;

import ordr.yellow.offer.Event;
import ordr.yellow.offer.Market;
import ordr.yellow.offer.OfferRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaDataWriter implements DataWriter {

    private static final Logger logger = LoggerFactory.getLogger(JpaDataWriter.class);
    private final OfferRepository offerRepository;

    public JpaDataWriter(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public void write(DataContent dataContent) {
        logger.info("writing market data to jpa datastore...");
        List<Market> markets = dataContent.getMarkets();

        markets.forEach(market -> {
            this.offerRepository.getMarketOutcomeRepository().saveAll(market.getOutcomes());
        });

        this.offerRepository.getMarketRepository().saveAll(markets);
        logger.info("finished writing market data to jpa datastore");

        logger.info("writing events data to jpa datastore...");
        List<Event> events = dataContent.getEvents();

        events.forEach(event -> {
            event.getMarkets().forEach(market -> {
                this.offerRepository.getEventMarketOutcomeRepository().saveAll(market.getOutcomes());
            });

            this.offerRepository.getEventMarketRepository().saveAll(event.getMarkets());
        });

        this.offerRepository.getEventRepository().saveAll(events);
        logger.info("finished writing events data to jpa datastore");
    }
}
