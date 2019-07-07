package restaurant;

import java.math.BigDecimal;

public class Cake extends Dessert {
    protected static  final double CAKE_GRAMS = 250 ;
    protected static  final double CAKE_CALORIES = 1000 ;
    protected static  final BigDecimal CAKE_PRICE = BigDecimal.valueOf(5);
    public Cake(String name) {
        super(name, CAKE_PRICE, CAKE_GRAMS, CAKE_CALORIES);
   }
}
