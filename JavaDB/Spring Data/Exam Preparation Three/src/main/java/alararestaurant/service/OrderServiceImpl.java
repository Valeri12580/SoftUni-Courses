package alararestaurant.service;

import alararestaurant.domain.dtos.importDtos.ImportOrderRootDto;
import alararestaurant.domain.dtos.importDtos.ItemDto;
import alararestaurant.domain.dtos.importDtos.OrderDto;
import alararestaurant.domain.entities.Employee;
import alararestaurant.domain.entities.Order;
import alararestaurant.repository.EmployeeRepository;
import alararestaurant.repository.ItemRepository;
import alararestaurant.repository.OrderRepository;
import alararestaurant.util.interfaces.FileUtil;
import alararestaurant.util.interfaces.ValidationUtil;
import alararestaurant.util.interfaces.XMLParser;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final XMLParser xmlParser;
    private final EmployeeRepository employeeRepository;
    private final ItemRepository itemRepository;

    public OrderServiceImpl(OrderRepository orderRepository, FileUtil fileUtil, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper, XMLParser xmlParser, EmployeeRepository employeeRepository, ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.employeeRepository = employeeRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public Boolean ordersAreImported() throws JAXBException {

        return this.orderRepository.count() > 0;
    }

    @Override
    public String readOrdersXmlFile() throws IOException {

        return this.fileUtil.readContent("src/main/resources/files/orders.xml");
    }

    @Override
    public String importOrders() throws JAXBException {
        ImportOrderRootDto importOrderRootDto=this.xmlParser.read(ImportOrderRootDto.class,"src/main/resources/files/orders.xml");

        for (OrderDto orderDto : importOrderRootDto.getOrders()) {
            Employee employee=this.employeeRepository.getEmployeeByName(orderDto.getEmployee());

            if(employee==null){
                continue;
            }else{
                boolean isInDb=true;
                for (ItemDto item : orderDto.getItems().getItems()) {
                    if(this.itemRepository.findItemByName(item.getName())==null){
                        isInDb=false;
                        break;
                    }
                }

                if(isInDb){
                    Order order=this.modelMapper.map(orderDto,Order.class);
                    order.setEmployee(employee);

                    this.orderRepository.save(order);
                }
            }
        }
        System.out.println();

        return null;
    }

    @Override
    public String exportOrdersFinishedByTheBurgerFlippers() {
        // TODO : Implement me
        return null;
    }
}
