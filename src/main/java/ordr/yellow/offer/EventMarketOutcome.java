package ordr.yellow.offer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventMarketOutcome {

    @Id
    private String id;

    @OneToOne
    private MarketOutcome outcome;

    private Status status;

    private Double odd;

    @OneToOne
    private EventMarket eventMarket;
}
