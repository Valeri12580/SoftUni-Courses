package com.softuni.webflux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class AsyncFlux {

    @Test
    public void asyncFlux(){
        MyInteger sum=new MyInteger(5);
        Flux.just(1,2,3,4).subscribeOn(Schedulers.elastic())
                .reduce(MyInteger::sum)
        .subscribe(sum::setInitialValue);
    }
}

class MyInteger{
    private Integer initialValue;

    public MyInteger(Integer initialValue) {
        this.initialValue = initialValue;
    }

    public static int sum(int a,int b){
        System.out.println("Summing ");
        return a+b;
    }

    public void setInitialValue(Integer initialValue) {
        this.initialValue = initialValue;
    }
}
