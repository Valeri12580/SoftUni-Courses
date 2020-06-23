package bg.softuni.examprep.services;

import bg.softuni.examprep.models.binding.ItemRegisterBindingModel;
import bg.softuni.examprep.models.entities.Item;
import bg.softuni.examprep.models.view.ItemHomeViewModel;
import bg.softuni.examprep.models.view.ItemInfoViewModel;
import bg.softuni.examprep.repositories.CategoryRepository;
import bg.softuni.examprep.repositories.ItemRepository;
import bg.softuni.examprep.services.interfaces.ItemService;
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
        ItemInfoViewModel result = this.modelMapper.map(this.itemRepository.findById(id).get(), ItemInfoViewModel.class);
        return result;
    }

    @Override
    public void delete(String id) {
        this.itemRepository.deleteById(id);
    }

    @Override
    public List<ItemHomeViewModel> getAllItems() {
        return List.of(this.modelMapper.map(this.itemRepository.findAll(),ItemHomeViewModel[].class));
    }
}
