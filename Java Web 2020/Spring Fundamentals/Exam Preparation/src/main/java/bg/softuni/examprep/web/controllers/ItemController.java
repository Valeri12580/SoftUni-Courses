package bg.softuni.examprep.web.controllers;

import bg.softuni.examprep.models.binding.ItemRegisterBindingModel;
import bg.softuni.examprep.services.interfaces.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/items")
public class ItemController {
    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/add")
    public String addItem(Model model){
        model.addAttribute("item",new ItemRegisterBindingModel());
        return "add-item";
    }


    @PostMapping("/add")
    public String postAddItem(@Valid @ModelAttribute("item")ItemRegisterBindingModel item,
                              BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "add-item";
        }

        this.itemService.register(item);

        return "redirect:/home";
    }


    @GetMapping("/details/{id}")
    public String itemInfo(@PathVariable("id") String id,Model model ){

        model.addAttribute("item",this.itemService.getSpecificItemInfo(id));
        return "details-item";
    }

    @GetMapping("/delete/{id}")
    public String itemDelete(@PathVariable("id") String id ){
       this.itemService.delete(id);
        return "redirect:/home";
    }

}
