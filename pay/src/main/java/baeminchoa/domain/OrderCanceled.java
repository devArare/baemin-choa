package baeminchoa.domain;

import baeminchoa.domain.*;
import baeminchoa.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderCanceled extends AbstractEvent {

    private Long id;
    private String userId;
    private String orderName;
    private Long orderId;
    private Integer qty;
    private String status;
    private Date orderDt;
    private String address;
}
