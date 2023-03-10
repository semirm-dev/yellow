package ns.yellow.offer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import ns.yellow.offer.Status;

@Entity
@Getter
@Setter
public class MarketOutcome {

    @Id
    private String id;

    private String name;

    private Status status;
}
