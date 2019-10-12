package competitorEntries.controllers;

import competitorEntries.bindingModels.CompetitorBindingModel;
import competitorEntries.entities.Competitor;
import competitorEntries.repositories.CompetitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CompetitorController {
    private final CompetitorRepository competitorRepository;

    @Autowired
    public CompetitorController(CompetitorRepository competitorRepository) {
        this.competitorRepository = competitorRepository;
    }


    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {
        List<Competitor>data=this.competitorRepository.findAll();
        modelAndView.setViewName("base-layout");
        modelAndView.addObject("view","competitor/Index");
        modelAndView.addObject("competitors",data);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create(ModelAndView modelAndView) {
        modelAndView.setViewName("base-layout");
        modelAndView.addObject("view","competitor/Create");

        return modelAndView;
    }

    @PostMapping("/create")
    public String create(Competitor competitor) {
        this.competitorRepository.saveAndFlush(competitor);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable(value = "id") Integer id, ModelAndView modelAndView) {
        modelAndView.setViewName("base-layout");
        modelAndView.addObject("view","competitor/Edit");
        Competitor competitor=this.competitorRepository.findById(id).get();
        modelAndView.addObject("competitor",competitor);
        return modelAndView;
    }

    @PostMapping("edit/{id}")
    public String edit(@PathVariable(value = "id") Integer id, CompetitorBindingModel bookBindingModel) {
        Competitor competitor=this.competitorRepository.getOne(id);
        competitor.setName(bookBindingModel.getName());
        competitor.setAge(bookBindingModel.getAge());
        competitor.setCategory(bookBindingModel.getCategory());
        competitor.setTeam(bookBindingModel.getTeam());
        this.competitorRepository.saveAndFlush(competitor);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView remove(@PathVariable(value = "id") Integer id, ModelAndView modelAndView) {
        Competitor competitor=this.competitorRepository.getOne(id);
        modelAndView.setViewName("base-layout");
        modelAndView.addObject("view","competitor/Remove");
        modelAndView.addObject("competitor",competitor);
        return modelAndView;
    }

    @PostMapping("/delete/{id}")
    public String remove(Competitor competitor) {
        this.competitorRepository.delete(competitor);
        return "redirect:/";
    }
}
