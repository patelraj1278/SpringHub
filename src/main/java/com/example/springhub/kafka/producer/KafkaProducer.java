package com.example.springhub.kafka.producer;

import com.example.springhub.kafka.constant.ApplicationConstant;
import com.example.springhub.kafka.dto.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/produce")
public class KafkaProducer {

    Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @PostMapping("/message")
    public String sendMessage(@RequestBody Student message) {
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(ApplicationConstant.TOPIC_NAME, message);
        future.whenComplete((result,throwable) -> {
            if (result != null){
                logger.info("Result ->"+result.toString());
            }else if(throwable != null){
                logger.debug(throwable.getMessage());
            }
        });
        return "json message sent succuessfully";
    }

}
