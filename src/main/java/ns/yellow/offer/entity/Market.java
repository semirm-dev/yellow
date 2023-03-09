package ns.yellow.offer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import ns.yellow.offer.Status;

import java.util.List;

@Entity
@Getter
@Setter
public class Market {

    @Id
    private String id;

    private String name;

    private Status status;

    @OneToMany(fetch = FetchType.EAGER)
    private List<MarketOutcome> outcomes;
}
