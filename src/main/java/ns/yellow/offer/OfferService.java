package ns.yellow.offer;

import ns.yellow.offer.dto.EventDto;
import ns.yellow.offer.dto.KafkaMessageDto;
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
    private final KafkaTemplate<String, KafkaMessageDto> kafkaTemplate;
    private List<MarketDto> markets = new LinkedList<>();
    private List<EventDto> events = new LinkedList<>();

    public OfferService(StateLoader stateLoader, KafkaTemplate<String, KafkaMessageDto> kafkaTemplate) {
        this.stateLoader = stateLoader;
        this.kafkaTemplate = kafkaTemplate;
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

    public void sendMessage(KafkaMessageDto msg) {
        logger.info("sending kafka message: " + msg.getMessage());
        this.kafkaTemplate.send("market", msg);
    }

    @KafkaListener(topics = "market", groupId = "offer")
    public void listenMarkets(KafkaMessageDto message) {
        logger.info("kafka markets received: " + message.getMessage());
    }

    @KafkaListener(topicPartitions = @TopicPartition(topic = "event", partitions = {"0", "1"}), groupId = "offer")
    public void listenEvents(ConsumerRecord<String, KafkaMessageDto> record) {
        logger.info("kafka events received on partition " + record.partition() + ", message: " + record.value());
    }
}
