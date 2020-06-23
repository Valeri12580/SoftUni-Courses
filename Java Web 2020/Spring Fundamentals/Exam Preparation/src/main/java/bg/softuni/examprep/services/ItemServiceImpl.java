package bg.softuni.examprep.services;

import bg.softuni.examprep.models.binding.ItemRegisterBindingModel;
import bg.softuni.examprep.models.entities.Item;
import bg.softuni.examprep.models.service.ItemServiceModel;
import bg.softuni.examprep.models.view.ItemHomeViewModel;
import bg.softuni.examprep.models.view.ItemInfoViewModel;
import bg.softuni.examprep.repositories.CategoryRepository;
import bg.softuni.examprep.repositories.ItemRepository;
import bg.softuni.examprep.services.interfaces.ItemService;
import bg.softuni.examprep.unitls.CategoryMap;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;
    private ModelMapper modelMapper;
    private CategoryRepository categoryRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, ModelMapper modelMapper, CategoryRepository categoryRepository) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public long getCount() {
        return this.itemRepository.count();
    }

    @Override
    public void register(ItemRegisterBindingModel item) {
        Item itemEntity=this.modelMapper.map(item,Item.class);
        itemEntity.setCategory(categoryRepository.findByType(item.getCategory()));

        this.itemRepository.save(itemEntity);
    }

    @Override
    public ItemInfoViewModel getSpecificItemInfo(String id) {
        ItemServiceModel data = this.modelMapper.map(this.itemRepository.findById(id).get(), ItemServiceModel.class);
        data.setImageUrl(CategoryMap.getSpecificUrl(data.getGender().toString().toUpperCase()+"-"+data.getCategory().getType().toString().toUpperCase()));

        return this.modelMapper.map(data, ItemInfoViewModel.class);
    }

    @Override
    public void delete(String id) {
        this.itemRepository.deleteById(id);
    }

    @Override
    public boolean isItemNameFree(String itemName) {
        return this.itemRepository.findByName(itemName)==null;
    }

    @Override
    public List<ItemHomeViewModel> getAllItems() {
        List<ItemServiceModel>serviceModel=List.of(this.modelMapper.map(this.itemRepository.findAll(),ItemServiceModel[].class));
        serviceModel.stream().forEach(e->{
            String concat=e.getGender().toString().toUpperCase()+"-"+e.getCategory().getType().toString().toUpperCase();

            e.setImageUrl(CategoryMap.getSpecificUrl(concat));
        });

        return List.of(this.modelMapper.map(serviceModel,ItemHomeViewModel[].class));
    }
}
