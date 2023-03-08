package ordr.yellow.offer;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MarketOutcome {

    @Id
    private String id;

    private String name;

    private Status status;

    @OneToOne
    private Market market;
}
