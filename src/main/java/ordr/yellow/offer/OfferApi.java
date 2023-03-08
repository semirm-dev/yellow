package ordr.yellow.offer;

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

    @GetMapping("events")
    public ResponseEntity<List<Event>> getEvents() {
        return ResponseEntity.ok(this.offerService.getEvents());
    }
}
