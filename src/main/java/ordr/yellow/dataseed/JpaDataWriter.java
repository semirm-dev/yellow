package ordr.yellow.dataseed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class JpaDataWriter implements DataWriter {

    private static final Logger logger = LoggerFactory.getLogger(JpaDataWriter.class);

    @Override
    public void write(DataContent dataContent) {
        logger.info("writing data to jpa datastore...");
    }
}
