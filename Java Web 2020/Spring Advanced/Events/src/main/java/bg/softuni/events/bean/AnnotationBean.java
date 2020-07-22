package bg.softuni.events.bean;

import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class AnnotationBean {

    @PostConstruct
    public void postConstruct(){
        System.out.println("POST CONSTRUCT");

    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("PRE DESTROY");
    }
}
