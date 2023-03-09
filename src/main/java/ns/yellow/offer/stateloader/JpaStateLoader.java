package ns.yellow.offer.stateloader;

import ns.yellow.offer.Mapper;
import ns.yellow.offer.OfferRepository;
import ns.yellow.offer.StateLoader;
import ns.yellow.offer.dto.EventDto;
import ns.yellow.offer.dto.MarketDto;
import ns.yellow.offer.entity.Event;
import ns.yellow.offer.entity.Market;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaStateLoader implements StateLoader {

    private final OfferRepository offerRepository;
    private final Mapper mapper;

    public JpaStateLoader(OfferRepository offerRepository, Mapper mapper) {
        this.offerRepository = offerRepository;
        this.mapper = mapper;
    }

    @Override
    public List<MarketDto> loadMarkets() {
        List<Market> markets = this.offerRepository.getMarketRepository().findAll();
        return this.mapper.mapList(markets, MarketDto.class);
    }

    @Override
    public List<EventDto> loadEvents() {
        List<Event> events = this.offerRepository.getEventRepository().findAll();
        return this.mapper.mapList(events, EventDto.class);
    }
}
