package bg.softuni.examprep.web.controllers;


import bg.softuni.examprep.services.interfaces.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private ItemService itemService;

    @Autowired
    public HomeController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("items", this.itemService.getAllItems());
        model.addAttribute("count", this.itemService.getCount());
        return "home";
    }
}
