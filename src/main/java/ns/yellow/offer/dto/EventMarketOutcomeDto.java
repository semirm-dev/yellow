package ns.yellow.offer.dto;

import lombok.Getter;
import lombok.Setter;
import ns.yellow.offer.Status;
import ns.yellow.offer.entity.MarketOutcome;

@Getter
@Setter
public class EventMarketOutcomeDto {

    private String id;

    private MarketOutcome outcome;

    private Status status;

    private Double odd;
}
