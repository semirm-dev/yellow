package ordr.yellow.dataseed;

import ordr.yellow.offer.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DataSeeder {

    private final DataReader dataReader;
    private final DataWriter dataWriter;

    private static final Logger logger = LoggerFactory.getLogger(DataSeeder.class);

    public DataSeeder(DataReader dataReader, DataWriter dataWriter) {
        this.dataReader = dataReader;
        this.dataWriter = dataWriter;
    }

    /**
     * Seed data from the source to the destination.
     */
    public void seed() {
        logger.info("loading initial data...");

        Event event = this.dataReader.read();

        this.dataWriter.write(event);

    }
}
