package baeminchoa.domain;

import baeminchoa.domain.*;
import baeminchoa.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class PayCompleted extends AbstractEvent {

    private Long id;
    private String userId;
    private Long orderId;
    private String orderName;
    private Long payId;
    private String paymentTyp;
    private Integer totalAmount;
    private String status;
    private Date payDt;

    public PayCompleted(PaymentHistory aggregate) {
        super(aggregate);
    }

    public PayCompleted() {
        super();
    }
}
//>>> DDD / Domain Event
