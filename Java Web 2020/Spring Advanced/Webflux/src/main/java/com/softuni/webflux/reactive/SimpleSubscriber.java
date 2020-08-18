package com.softuni.webflux.reactive;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;

public class SimpleSubscriber<T> implements Flow.Subscriber<T> {

    private List<T> consumedElements=new ArrayList<>();
    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription=subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(T item) {
        consumedElements.add(item);
        System.out.println("Added");
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Im done!!");
        consumedElements.forEach(System.out::println);
        System.out.println("-----");
    }

    public int getConsumedElementCount(){
        return consumedElements.size();
    }
}
