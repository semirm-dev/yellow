package ns.yellow.offer.dto;

import lombok.Getter;
import lombok.Setter;
import ns.yellow.offer.Status;
import ns.yellow.offer.entity.Event;
import ns.yellow.offer.entity.Market;

import java.util.List;

@Getter
@Setter
public class EventMarketDto {

    private String id;

    private Market market;

    private Status status;

    private List<EventMarketOutcomeDto> outcomes;

    private Event event;
}
