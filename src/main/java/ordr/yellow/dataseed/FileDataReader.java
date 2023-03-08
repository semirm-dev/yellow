package ordr.yellow.dataseed;

import ordr.yellow.offer.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FileDataReader implements DataReader {

    private static final Logger logger = LoggerFactory.getLogger(FileDataReader.class);

    @Override
    public Event read() {
        logger.info("reading data from file...");
        return new Event();
    }
}
