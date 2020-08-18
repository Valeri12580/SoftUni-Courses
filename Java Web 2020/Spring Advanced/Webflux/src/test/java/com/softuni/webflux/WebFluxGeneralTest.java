package com.softuni.webflux;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

import java.util.function.Consumer;

@SpringBootTest
public class WebFluxGeneralTest {

    private String[] getSpringProjects() {
        return new String[]{"Spring REST", "SPRING MVC", "SPRING TEST", "SPRING Webflux"};

    }

    @Test
    public void fluxToStream(){
        Flux<String>springProjectsFlux=Flux.just(getSpringProjects());

        springProjectsFlux.toStream().map(String::toLowerCase).forEach(System.out::println);
    }

    @Test
    public void subscribeToFlux(){
        Flux<String>springProjectsFlux=Flux.just(getSpringProjects());

        Consumer<String >onNext= System.out::println;
        Consumer<Throwable >onError= Throwable::printStackTrace;
        Runnable finish= ()-> System.out.println("Done");
        springProjectsFlux.subscribe(onNext,onError,finish);
    }

    @Test
    public void testOnError(){
        Flux<Integer>springProjectsFlux=Flux.just("1","2","Three")
                .map(Integer::parseInt);

        Consumer<Integer >onNext= System.out::println;
        Consumer<Throwable >onError= (Throwable ex)-> System.out.println("Error!");
        Runnable finish= ()-> System.out.println("Done");
        springProjectsFlux.subscribe(onNext,onError,finish);
    }


}
