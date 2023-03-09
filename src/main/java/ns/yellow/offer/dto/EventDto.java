package ns.yellow.offer.dto;

import lombok.Getter;
import lombok.Setter;
import ns.yellow.offer.Status;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class EventDto {
    private String id;

    private String name;

    private Date startsAt;

    private Status status;

    private List<EventMarketDto> markets;
}
