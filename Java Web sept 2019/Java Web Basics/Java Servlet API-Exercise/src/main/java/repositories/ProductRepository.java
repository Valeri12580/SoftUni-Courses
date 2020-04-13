package repositories;

import models.entities.Product;

import java.util.List;

public interface ProductRepository {
   void  save( Product item);
     List<Product>getAll();

     Product getProductByName(String name);
}
