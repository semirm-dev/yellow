package ns.yellow.offer;

import ns.yellow.offer.dto.EventDto;
import ns.yellow.offer.dto.MarketDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/offers")
public class OfferApi {

    private final OfferService offerService;

    public OfferApi(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("healthz")
    public ResponseEntity<String> healthz() {
        return ResponseEntity.ok(this.offerService.healthz());
    }

    @GetMapping("markets")
    public ResponseEntity<List<MarketDto>> getMarkets() {
        return ResponseEntity.ok(this.offerService.getMarkets());
    }

    @GetMapping("events")
    public ResponseEntity<List<EventDto>> getEvents() {
        return ResponseEntity.ok(this.offerService.getEvents());
    }
}
