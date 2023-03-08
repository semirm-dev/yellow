package ordr.yellow.dataseed;

import lombok.Getter;
import lombok.Setter;
import ordr.yellow.offer.Event;
import ordr.yellow.offer.Market;

import java.util.List;

@Getter
@Setter
public class DataContent {

    private List<Market> markets;

    private List<Event> events;
}
