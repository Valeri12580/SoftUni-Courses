package com.softuni.webflux;

import com.softuni.webflux.reactive.SimpleSubscriber;
import com.softuni.webflux.reactive.TransformationProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

@SpringBootTest
public class SimpleSubscriberTest {

    @Test
    public void testAllItemsConsumed() {
        SubmissionPublisher<String>publisher=new SubmissionPublisher<>();

        SimpleSubscriber<String>subscriber=new SimpleSubscriber<>();

        publisher.subscribe(subscriber);

        Assertions.assertEquals(1,publisher.getNumberOfSubscribers());

        List<String> names=List.of("Valeri","Ivan","Kacho");

        names.forEach(e->publisher.submit(e));
        publisher.close();

        await().atMost(1, TimeUnit.SECONDS);
        Assertions.assertEquals(3,subscriber.getConsumedElementCount());
    }

    @Test
    public void testProcessor(){
//        TransformationProcessor<String,String>processor=
//                new TransformationProcessor<String,String>(String::toUpperCase);
//
//        SubmissionPublisher<String>start=new SubmissionPublisher<>();
//
//        SimpleSubscriber<String>finish=new SimpleSubscriber<>();
//
//        List<String>lower=List.of("kacho","ivan","valeri");
//        List<String>upper=List.of("KACHO","IVAN","VALERI");
//
//        start.subscribe(processor);
//
//        processor.subscribe(finish);
//        lower.forEach(start::submit);
//        start.close();
//        await().atMost(1,TimeUnit.SECONDS);
//
//
//        Asser
    }

}
