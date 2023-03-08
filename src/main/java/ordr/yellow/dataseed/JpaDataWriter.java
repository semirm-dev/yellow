package ordr.yellow.dataseed;

import ordr.yellow.offer.OfferRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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
        this.offerRepository.getMarketRepository().saveAll(dataContent.getMarkets());

        logger.info("writing events data to jpa datastore...");
        this.offerRepository.getEventsRepository().saveAll(dataContent.getEvents());
    }
}
