package ordr.yellow.dataseed;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ordr.yellow.offer.Event;
import ordr.yellow.offer.Market;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class FileDataReader implements DataReader {

    private static final Logger logger = LoggerFactory.getLogger(FileDataReader.class);

    @Override
    public DataContent read() {
        logger.info("reading data from file...");
        DataContent dataContent = new DataContent();
        ObjectMapper mapper = new ObjectMapper();

        List<Market> markets = readMarkets(mapper);
        dataContent.setMarkets(markets);
        List<Event> events = readEvents(mapper);
        dataContent.setEvents(events);
        logger.info("finished reading data from file");

        return dataContent;
    }

    private List<Market> readMarkets(ObjectMapper mapper) {
        File marketsFile = new File("src/main/resources/static/markets.json");

        try {
            return mapper.readValue(marketsFile, new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Event> readEvents(ObjectMapper mapper) {
        File eventsFile = new File("src/main/resources/static/events.json");

        try {
            return mapper.readValue(eventsFile, new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
