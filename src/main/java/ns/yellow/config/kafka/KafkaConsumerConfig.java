package ns.yellow.config.kafka;

import ns.yellow.offer.dto.EventDto;
import ns.yellow.offer.dto.MarketDto;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {
    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Value(value = "${spring.kafka.consumer.group-id}")
    private String groupId;

    @Bean
    public ConsumerFactory<String, MarketDto> marketConsumerFactory() {
        Map<String, Object> props = kafkaProps();
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new JsonDeserializer<>(MarketDto.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, MarketDto> marketListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, MarketDto> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(marketConsumerFactory());
        return factory;
    }

    @Bean
    public ConsumerFactory<String, EventDto> eventConsumerFactory() {
        Map<String, Object> props = kafkaProps();
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new JsonDeserializer<>(EventDto.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, EventDto> eventListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, EventDto> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(eventConsumerFactory());
        return factory;
    }

    private Map<String, Object> kafkaProps() {
        Map<String, Object> props = new HashMap<>();
        props.put(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapAddress);
        props.put(
                ConsumerConfig.GROUP_ID_CONFIG,
                groupId);
        props.put(
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        props.put(
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                JsonDeserializer.class);

        return props;
    }
}
