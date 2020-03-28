package alararestaurant.service;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface OrderService {

    Boolean ordersAreImported() throws JAXBException;

    String readOrdersXmlFile() throws IOException;

    String importOrders() throws JAXBException;

    String exportOrdersFinishedByTheBurgerFlippers();
}
