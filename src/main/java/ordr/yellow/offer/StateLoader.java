package ordr.yellow.offer;

import java.util.List;

public interface StateLoader {
    List<Market> loadMarkets();

    List<Event> loadEvents();
}
