package bg.softuni.events.custom;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class AddProductPublisher {

    private final ApplicationEventPublisher publisher;


    public AddProductPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }


    public void publishAddedProduct(String productId){
        AddProductEvent productEvent=new AddProductEvent(this,productId);
        this.publisher.publishEvent(productEvent);
    }
}
