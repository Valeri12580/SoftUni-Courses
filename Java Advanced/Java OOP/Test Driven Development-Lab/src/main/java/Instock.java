import jdk.jshell.spi.ExecutionControl;

import java.util.*;
import java.util.stream.Collectors;

public class Instock implements ProductStock {
    private Map<String,Product> products;

    public Instock() {
        this.products = new LinkedHashMap<>();
    }

    @Override
    public int getCount() {
        return this.products.size();
    }

    @Override
    public boolean contains(Product product) {
        return this.products.containsKey(product.getLabel());
    }

    @Override
    public void add(Product product) {
        this.products.put(product.getLabel(),product);
    }

    @Override
    public void changeQuantity(String product, int quantity) {
        if(!this.products.containsKey(product)){
            throw  new IllegalArgumentException();
        }
        Product newProduct=this.products.get(product);
        newProduct.setQuantity(quantity);
        this.products.put(product,newProduct);
    }

    @Override
    public Product find(int index) {
        if(index>=0 && index<products.size()){
            for (Map.Entry<String, Product> stringProductEntry : products.entrySet()) {
                int indexFor=0;
                if(indexFor++==index){
                    return stringProductEntry.getValue();
                }

            }
        }

        throw  new IndexOutOfBoundsException();

    }

    @Override
    public Product findByLabel(String label) {
        if(!this.products.containsKey(label)){
            throw  new IllegalArgumentException();
        }
        return this.products.get(label);
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
       if(count<0 || count>this.products.size()){
           return new ArrayList<Product>();
       }


       return products.values().stream().sorted(Comparator.comparing(Product::getLabel)).limit(count).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        return this.products.values().stream().filter(e-> e.price>=lo && e.price<hi).sorted((p1,p2)->Double.compare(p2.price,p1.price)).collect(Collectors.toList());

    }


    @Override
    public Iterable<Product> findAllByPrice(double price) {
        return  this.products.values().stream().filter(e->e.getPrice()==price).collect(Collectors.toList());

    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {

        if(count>products.size()){
            throw new IllegalArgumentException();
        }
        return products.values().stream().sorted((p1,p2)->Double.compare(p2.getPrice(),p1.getPrice())).limit(count).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        return  this.products.values().stream().filter(e->e.getQuantity()==quantity).collect(Collectors.toList());
    }

    @Override
    public Iterator<Product> iterator() {
       return products.;
    }
}
