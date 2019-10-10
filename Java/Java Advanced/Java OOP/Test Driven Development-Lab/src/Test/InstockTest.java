import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

public class InstockTest {
    ProductStock productStock;

    @Before
    public void init(){
        productStock=new Instock();

    }



    @Test
    public  void addOneShouldIncreaseSize(){
        Product product=createProducts(1).get(0);
        productStock.add(product);
        Assert.assertEquals(1,productStock.getCount());

    }
    @Test
    public void testIfCountWorkCorrect(){
        Assert.assertEquals(0,productStock.getCount());
    }
    @Test
    public  void addThenShouldIncreaseSize(){
        List<Product> product=createProducts(10);
        product.forEach(productStock::add);
        Assert.assertEquals(product.size(),productStock.getCount());

    }
    @Test
    public void addShouldContainsCorrectReference(){
        Product product=createProducts(1).get(0);
        productStock.add(product);

        Assert.assertTrue(productStock.contains(product));
    }
    @Test
    public void containsShouldReturnTrueIfProductExists(){
        List<Product>products=createProducts(5);
        products.forEach(productStock::add);
        Product lastProduct=products.get(products.size()-1);
        Assert.assertTrue(this.productStock.contains(lastProduct));
    }
    @Test
    public void containsShouldReturnFalseIfProductDoesntExists(){
       Product product=new Product("Siriniee",5.50,2);
        Assert.assertFalse(this.productStock.contains(product));
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public  void findShouldThrowExceptionIfIndexIsInvalid(){
        this.productStock.find(productStock.getCount());
    }
    @Test
    public void findShouldReturnCorrectProduct(){
        Product product=createProducts(1).get(0);
        productStock.add(product);
        Assert.assertEquals(product,productStock.find(0));
    }
    @Test(expected = IllegalArgumentException.class)
    public void changeQuantityShouldThrowException(){
        this.productStock.changeQuantity("Rakiq",15);


    }
    @Test
    public void changeQuantityShouldChangeProductQuantity(){
        this.productStock.add(new Product("Rakiq",2.90,1));
        this.productStock.changeQuantity("Rakiq",15);
        Assert.assertEquals(15,this.productStock.find(0).getQuantity());
    }
    @Test(expected = IllegalArgumentException.class)
    public void findByLabelShouldThrowException(){
        Product product=createProducts(1).get(0);

        productStock.findByLabel(product.getLabel());


    }
    @Test
    public void findByLabelShouldReturnProductByGivenLabel(){
        Product product=new Product("Rakiq",2.90,1);
        this.productStock.add(product);

        Assert.assertEquals(product,this.productStock.findByLabel("Rakiq"));
    }
    @Test
    public void findFirstByLabelShouldReturnEmptyCollectionIfArgumentIsOutOfRange(){
        Collection<Product>products= (Collection<Product>) this.productStock.findFirstByAlphabeticalOrder(2);
        Assert.assertTrue(products.isEmpty());
    }
    @Test
    public  void findFirstByLabelShouldReturnResultsCorrectly(){
       Product a=new Product("A",2,1);
       Product b=new Product("B",2,1);
       Product c=new Product("C",2,1);
       this.productStock.add(a);
       this.productStock.add(b);
       this.productStock.add(c);
       Collection<Product>products= (Collection<Product>) this.productStock.findFirstByAlphabeticalOrder(2);
       Assert.assertEquals(a,products.stream().limit(1).findFirst().orElse(null));
       Assert.assertEquals(b,products.stream().skip(1).findFirst().orElse(null));

    }
    @Test
    public  void findAllInPriceRangeShouldReturnEmptyCollectionIfThereIsNoSuchProducts(){
        Product a=new Product("A",30,1);
        Product b=new Product("B",2231,1);
        Product c=new Product("C",2231,1);
        this.productStock.add(a);
        this.productStock.add(b);
        this.productStock.add(c);
        Collection<Product>finalResults= (Collection<Product>) productStock.findAllInRange(1,10);
        Assert.assertEquals(0,finalResults.size());
    }
    @Test
    public  void findAllInPriceRangeShouldReturnCorrectResults(){
        Product a=new Product("A",2,1);
        Product b=new Product("B",3,1);
        Product c=new Product("C",8,1);
        this.productStock.add(a);
        this.productStock.add(b);
        this.productStock.add(c);
        Collection<Product>finalResults= (Collection<Product>) productStock.findAllInRange(2,5);
        Assert.assertEquals(b,finalResults.stream().limit(1).findFirst().orElse(null));
        Assert.assertEquals(a,finalResults.stream().skip(1).findFirst().orElse(null));
    }
    @Test
    public  void findAllByPriceShouldReturnEmptyCollectionIfResultIsNotFound(){
        Product a=new Product("A",3,1);
        Product b=new Product("B",3,1);
        Product c=new Product("C",8,1);
        productStock.add(a);
        productStock.add(b);
        productStock.add(c);
        Collection<Product>finalResults= (Collection<Product>) productStock.findAllByPrice(2);
        Assert.assertTrue(finalResults.isEmpty());
    }
    @Test
    public  void findAllByPriceShouldReturnCorrectRessults(){
        Product a=new Product("A",3,1);
        Product b=new Product("B",3,1);
        Product c=new Product("C",8,1);
        productStock.add(a);
        productStock.add(b);
        productStock.add(c);

        Collection<Product>finalResults= (Collection<Product>) productStock.findAllByPrice(3);
        assertEquals(2, finalResults.size());
    }
    @Test(expected =IllegalArgumentException.class)
    public  void findFirstMostExpensiveProductsShouldThrowExceptionIfCountIsLess(){
        Product a=new Product("A",4,1);
        Product b=new Product("B",312,1);
        Product c=new Product("C",8,1);
        productStock.add(a);
        productStock.add(b);
        productStock.add(c);
        productStock.findFirstMostExpensiveProducts(5);
    }
    @Test
    public  void findFirstMostExpensiveProductsShouldReturnCorrectRessults(){
        Product a=new Product("A",4,1);
        Product b=new Product("B",312,1);
        Product c=new Product("C",8,1);
        productStock.add(a);
        productStock.add(b);
        productStock.add(c);
        Collection<Product> finalResults = (Collection<Product>) productStock.findFirstMostExpensiveProducts(2);
        Assert.assertEquals(b,finalResults.stream().limit(1).findFirst().orElse(null));
        Assert.assertEquals(c,finalResults.stream().skip(1).findFirst().orElse(null));

    }
    @Test
    public  void findAllByQuantitShouldReturnEmptyCollectionIfResultIsNotFound(){
        Product a=new Product("A",3,12);
        Product b=new Product("B",3,12);
        Product c=new Product("C",8,12);
        productStock.add(a);
        productStock.add(b);
        productStock.add(c);
        Collection<Product>finalResults= (Collection<Product>) productStock.findAllByQuantity(2);
        Assert.assertTrue(finalResults.isEmpty());
    }
    @Test
    public  void findAllByQuantitShouldReturnCorrectResult(){
        Product a=new Product("A",3,12);
        Product b=new Product("B",3,12);
        Product c=new Product("C",8,12);
        productStock.add(a);
        productStock.add(b);
        productStock.add(c);
        Collection<Product>finalResults= (Collection<Product>) productStock.findAllByQuantity(12);
        Assert.assertEquals(3,finalResults.size());
    }
    @Test
    public void getIterableShouldReturnAllElements(){
        Product a=new Product("A",3,12);
        Product b=new Product("B",3,12);
        Product c=new Product("C",8,12);
        productStock.add(a);
        productStock.add(b);
        productStock.add(c);
        Collection<Product>finalResults= (Collection<Product>) productStock.iterator();
        assertEquals(3,finalResults.size());
    }



    private List<Product>createProducts(int count){
        List<Product> products=new ArrayList<>();

        for (int i = 0; i < count; i++) {
            products.add(new Product(UUID.randomUUID().toString(),12.5*i,10*i));
        }

        return products;
    }



}