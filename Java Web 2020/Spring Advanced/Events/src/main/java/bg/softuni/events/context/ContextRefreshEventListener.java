package bg.softuni.events.context;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ContextRefreshEventListener {

    @EventListener
    public void onRefresh(ContextRefreshedEvent event){
        System.out.println("Context refreshed from EVENTLISTENER");
    }
}
