package bg.softuni.examprep.services.interfaces;

import bg.softuni.examprep.models.binding.ItemRegisterBindingModel;
import bg.softuni.examprep.models.view.ItemHomeViewModel;
import bg.softuni.examprep.models.view.ItemInfoViewModel;

import java.util.List;

public interface ItemService {

    List<ItemHomeViewModel> getAllItems();

    long getCount();

    void register(ItemRegisterBindingModel item);

    ItemInfoViewModel getSpecificItemInfo(String id);

    void delete(String id );



}
