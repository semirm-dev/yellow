package ns.yellow.config.dataseed;

import ns.yellow.dataseed.DataSeeder;
import ns.yellow.offer.OfferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeedConfig {

    private final DataSeeder dataSeeder;
    private final OfferService offerService;

    public DataSeedConfig(DataSeeder dataSeeder, OfferService offerService) {
        this.dataSeeder = dataSeeder;
        this.offerService = offerService;
    }

    private static final Logger logger = LoggerFactory.getLogger(DataSeedConfig.class);

    @Bean
    CommandLineRunner load() {
        return args -> {
            this.dataSeeder.seed();
            this.offerService.loadState();
        };
    }
}
