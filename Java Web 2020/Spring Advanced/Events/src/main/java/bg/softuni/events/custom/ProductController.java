package bg.softuni.events.custom;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private AddProductPublisher productPublisher;
    private int prdCounter=1;

    public ProductController(AddProductPublisher productPublisher) {
        this.productPublisher = productPublisher;
    }

    @GetMapping("/add-product")
    public ResponseEntity<String> addProduct(){
        productPublisher.publishAddedProduct("Product "+prdCounter++);
        return ResponseEntity.ok().build();
    }
}
