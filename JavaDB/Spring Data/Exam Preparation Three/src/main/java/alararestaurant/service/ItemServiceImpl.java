package alararestaurant.service;

import alararestaurant.domain.dtos.importDtos.ImportItemDto;
import alararestaurant.domain.entities.Category;
import alararestaurant.domain.entities.Item;
import alararestaurant.repository.CategoryRepository;
import alararestaurant.repository.ItemRepository;
import alararestaurant.util.interfaces.FileUtil;
import alararestaurant.util.interfaces.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;

    public ItemServiceImpl(ItemRepository itemRepository, FileUtil fileUtil, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper, CategoryRepository categoryRepository) {
        this.itemRepository = itemRepository;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Boolean itemsAreImported() {


        return this.itemRepository.count() > 0;
    }

    @Override
    public String readItemsJsonFile() throws IOException {
        return this.fileUtil.readContent("src/main/resources/files/items.json");
    }

    @Override
    public String importItems(String items) throws FileNotFoundException {
        ImportItemDto[]importItemDtos=this.gson.fromJson(new FileReader("src/main/resources/files/items.json"),ImportItemDto[].class);
        StringBuilder sb=new StringBuilder();

        for (ImportItemDto itemDto : importItemDtos) {

            if(this.validationUtil.isValid(itemDto)){
                Item item=this.modelMapper.map(itemDto,Item.class);
                if(this.itemRepository.findItemByName(itemDto.getName())==null){
                    if(this.categoryRepository.findCategoryByName(itemDto.getCategory())==null){
                        item.setCategory(new Category(itemDto.getCategory()));
                    }else{

                        item.setCategory(this.categoryRepository.findCategoryByName(itemDto.getCategory()));
                    }
                    this.itemRepository.save(item);
                    sb.append(String.format("Record %s successfully imported.",item.getName()));

                }else{
                    sb.append("Invalid data format.");
                }


            }else{
                sb.append("Invalid data format.");
            }
            sb.append(System.lineSeparator());

        }
        return sb.toString();
    }
}
