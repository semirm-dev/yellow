package ordr.yellow.offer;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Event {

    @Id
    private String id;

    private String name;

    private Date startsAt;

    private Status status;

    @OneToMany
    private List<EventMarket> markets;
}
