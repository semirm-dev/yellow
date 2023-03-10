package ns.yellow.offer;

import ns.yellow.offer.dto.EventDto;
import ns.yellow.offer.dto.MarketDto;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class OfferService {

    private static final Logger logger = LoggerFactory.getLogger(OfferService.class);
    private final StateLoader stateLoader;
    private final KafkaTemplate<String, MarketDto> marketKafkaTemplate;
    private final KafkaTemplate<String, EventDto> eventKafkaTemplate;
    private List<MarketDto> markets = new LinkedList<>();
    private List<EventDto> events = new LinkedList<>();

    public OfferService(
            StateLoader stateLoader,
            KafkaTemplate<String, MarketDto> marketKafkaTemplate,
            KafkaTemplate<String, EventDto> eventKafkaTemplate
    ) {
        this.stateLoader = stateLoader;
        this.marketKafkaTemplate = marketKafkaTemplate;
        this.eventKafkaTemplate = eventKafkaTemplate;
    }

    public String healthz() {
        return "ok";
    }

    public void loadState() {
        logger.info("loading initial app state from datastore");

        this.markets = this.stateLoader.loadMarkets();
        this.events = this.stateLoader.loadEvents();

        logger.info("finished loading initial app state from datastore");
    }

    public List<MarketDto> getMarkets() {
        return this.markets;
    }

    public List<EventDto> getEvents() {
        return this.events;
    }

    public void sendMarketMessage(MarketDto market) {
        logger.info("sending kafka market message: " + market.getName());
        this.marketKafkaTemplate.send("market", market);
    }

    public void sendEventMessage(EventDto event) {
        logger.info("sending kafka market message: " + event.getName());
        this.eventKafkaTemplate.send("event", event);
    }

    @KafkaListener(topics = "market", groupId = "offer", containerFactory = "marketListenerContainerFactory")
    public void listenMarkets(MarketDto market) {
        logger.info("kafka markets received: " + market.getName());
    }

    @KafkaListener(
            topicPartitions = @TopicPartition(topic = "event", partitions = {"0", "1"}),
            groupId = "offer",
            containerFactory = "eventListenerContainerFactory")
    public void listenEvents(ConsumerRecord<String, EventDto> record) {
        EventDto event = record.value();
        logger.info("kafka events received on partition " + record.partition() + ", message: " + event.getName());
    }
}
