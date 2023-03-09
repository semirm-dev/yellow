package ns.yellow.offer.dto;

import lombok.Getter;
import lombok.Setter;
import ns.yellow.offer.Status;

import java.util.List;

@Getter
@Setter
public class MarketDto {
    private String id;

    private String name;

    private Status status;

    private List<MarketOutcomeDto> outcomes;
}
