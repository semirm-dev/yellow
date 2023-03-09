package ns.yellow.offer;

import ns.yellow.offer.dto.EventDto;
import ns.yellow.offer.dto.MarketDto;

import java.util.List;

public interface StateLoader {
    List<MarketDto> loadMarkets();

    List<EventDto> loadEvents();
}
