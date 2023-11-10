package baeminchoa.domain;

import baeminchoa.domain.*;
import baeminchoa.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class PayCanceled extends AbstractEvent {

    private Long id;
    private String userId;
    private Long orderId;
    private String orderName;
    private Long payId;
    private String paymentTyp;
    private Integer totalAmount;
    private String status;
    private Date payDt;
}
