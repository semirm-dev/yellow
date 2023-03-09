package ns.yellow.dataseed;

import lombok.Getter;
import lombok.Setter;
import ns.yellow.offer.entity.Event;
import ns.yellow.offer.entity.Market;

import java.util.List;

@Getter
@Setter
public class DataContent {

    private List<Market> markets;

    private List<Event> events;
}
