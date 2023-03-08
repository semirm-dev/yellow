package ordr.yellow.offer;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class EventMarket {

    @Id
    private String id;

    @OneToOne
    private Market market;

    private Status status;

    @OneToMany
    private List<EventMarketOutcome> outcomes;

    @OneToOne
    private Event event;
}
