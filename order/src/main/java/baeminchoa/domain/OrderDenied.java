package baeminchoa.domain;

import baeminchoa.domain.*;
import baeminchoa.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderDenied extends AbstractEvent {

    private Long id;
    private String userId;
    private Long orderId;
    private String orderName;
    private Integer qty;
    private String status;
    private Date orderDt;
    private String address;

    public OrderDenied(Order aggregate) {
        super(aggregate);
    }

    public OrderDenied() {
        super();
    }
}
//>>> DDD / Domain Event
