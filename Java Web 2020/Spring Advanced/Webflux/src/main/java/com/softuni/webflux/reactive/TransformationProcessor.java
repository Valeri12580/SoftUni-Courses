package com.softuni.webflux.reactive;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;

public class TransformationProcessor<T,R> implements Flow.Processor<T,R> {
    private final Function<T,R>transformation;
    private final SubmissionPublisher<R>submissionPublisher;
    private Flow.Subscription subscription;

    public TransformationProcessor(Function<T, R> transformation) {
        this.transformation = transformation;
        submissionPublisher=new SubmissionPublisher<>();

    }

    //publisher
    @Override
    public void subscribe(Flow.Subscriber<? super R> subscriber) {
        submissionPublisher.subscribe(subscriber);
    }


    //subscriber
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription=subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(T item) {
        R transformed=transformation.apply(item);
        submissionPublisher.submit(transformed);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {
        System.out.println("Transformation is complete");
    }
}
