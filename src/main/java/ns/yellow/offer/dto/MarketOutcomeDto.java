package ns.yellow.offer.dto;

import lombok.Getter;
import lombok.Setter;
import ns.yellow.offer.Status;

@Getter
@Setter
public class MarketOutcomeDto {
    private String id;

    private String name;

    private Status status;
}
