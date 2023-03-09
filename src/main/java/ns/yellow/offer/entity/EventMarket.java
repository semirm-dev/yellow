package ns.yellow.offer.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ns.yellow.offer.Status;

import java.util.List;

@Entity
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventMarket {

    @Id
    private String id;

    @OneToOne
    private Market market;

    private Status status;

    @OneToMany(fetch = FetchType.EAGER)
    private List<EventMarketOutcome> outcomes;

    @OneToOne
    private Event event;
}
