package baeminchoa.domain;

import baeminchoa.PayApplication;
import baeminchoa.domain.PayCanceled;
import baeminchoa.domain.PayCompleted;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "PaymentHistory_table")
@Data
//<<< DDD / Aggregate Root
public class PaymentHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    private Long orderId;

    private String orderName;

    private Long payId;

    private String paymentTyp;

    private Integer totalAmount;

    private String status;

    private Date payDt;

    @PostPersist
    public void onPostPersist() {
        PayCompleted payCompleted = new PayCompleted(this);
        payCompleted.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        PayCanceled payCanceled = new PayCanceled(this);
        payCanceled.publishAfterCommit();
    }

    public static PaymentHistoryRepository repository() {
        PaymentHistoryRepository paymentHistoryRepository = PayApplication.applicationContext.getBean(
            PaymentHistoryRepository.class
        );
        return paymentHistoryRepository;
    }

    //<<< Clean Arch / Port Method
    public static void payCancel(OrderCanceled orderCanceled) {
        //implement business logic here:

        /** Example 1:  new item 
        PaymentHistory paymentHistory = new PaymentHistory();
        repository().save(paymentHistory);

        PayCanceled payCanceled = new PayCanceled(paymentHistory);
        payCanceled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderCanceled.get???()).ifPresent(paymentHistory->{
            
            paymentHistory // do something
            repository().save(paymentHistory);

            PayCanceled payCanceled = new PayCanceled(paymentHistory);
            payCanceled.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void payResquest(Ordered ordered) {
        //implement business logic here:

        /** Example 1:  new item 
        PaymentHistory paymentHistory = new PaymentHistory();
        repository().save(paymentHistory);

        PayCompleted payCompleted = new PayCompleted(paymentHistory);
        payCompleted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(ordered.get???()).ifPresent(paymentHistory->{
            
            paymentHistory // do something
            repository().save(paymentHistory);

            PayCompleted payCompleted = new PayCompleted(paymentHistory);
            payCompleted.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
