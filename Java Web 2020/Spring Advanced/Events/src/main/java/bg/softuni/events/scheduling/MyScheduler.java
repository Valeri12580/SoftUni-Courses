package bg.softuni.events.scheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyScheduler {

    @Scheduled(fixedDelay = 1000,initialDelay = 5000 )
    public void doSomething(){
        System.out.println("Something");
    }


//    @Scheduled(cron = )
//    public void scheduledByCron(){
//
//    }
}
