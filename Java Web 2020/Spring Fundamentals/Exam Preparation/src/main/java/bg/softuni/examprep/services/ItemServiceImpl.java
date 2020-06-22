package bg.softuni.examprep.services;

import bg.softuni.examprep.models.view.ItemHomeViewModel;
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

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, ModelMapper modelMapper) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public long getCount() {
        return this.itemRepository.count();
    }

    @Override
    public List<ItemHomeViewModel> getAllItems() {
        return List.of(this.modelMapper.map(this.itemRepository.findAll(),ItemHomeViewModel[].class));
    }
}
