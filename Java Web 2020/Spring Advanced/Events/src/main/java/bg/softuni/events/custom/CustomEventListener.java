package bg.softuni.events.custom;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CustomEventListener {

    @EventListener(AddProductEvent.class)
    public void listener(AddProductEvent event){
        System.out.println(event.getMessage());
    }
}
