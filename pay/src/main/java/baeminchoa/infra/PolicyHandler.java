package baeminchoa.infra;

import baeminchoa.config.kafka.KafkaProcessor;
import baeminchoa.domain.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    PaymentHistoryRepository paymentHistoryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderCanceled'"
    )
    public void wheneverOrderCanceled_PayCancel(
        @Payload OrderCanceled orderCanceled
    ) {
        OrderCanceled event = orderCanceled;
        System.out.println(
            "\n\n##### listener PayCancel : " + orderCanceled + "\n\n"
        );

        // Sample Logic //
        PaymentHistory.payCancel(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Ordered'"
    )
    public void wheneverOrdered_PayResquest(@Payload Ordered ordered) {
        Ordered event = ordered;
        System.out.println(
            "\n\n##### listener PayResquest : " + ordered + "\n\n"
        );

        // Sample Logic //
        PaymentHistory.payResquest(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
