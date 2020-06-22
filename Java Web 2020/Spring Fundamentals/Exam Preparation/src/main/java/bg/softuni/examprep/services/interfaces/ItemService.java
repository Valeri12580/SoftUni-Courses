package bg.softuni.examprep.services.interfaces;

import bg.softuni.examprep.models.view.ItemHomeViewModel;

import java.util.List;

public interface ItemService {

    List<ItemHomeViewModel> getAllItems();

    long getCount();

}
