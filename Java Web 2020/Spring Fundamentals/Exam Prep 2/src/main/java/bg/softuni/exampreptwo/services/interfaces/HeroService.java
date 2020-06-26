package bg.softuni.exampreptwo.services.interfaces;

import bg.softuni.exampreptwo.models.binding.HeroCreateBindingModel;
import bg.softuni.exampreptwo.models.view.HeroDetailViewModel;
import bg.softuni.exampreptwo.models.view.HeroHomeViewModel;

import java.util.List;

public interface HeroService {
    List<HeroHomeViewModel> getAllHeroes();

    void addHero(HeroCreateBindingModel heroCreateBindingModel);

    HeroDetailViewModel findById(String id);

    void delete(String id);
}
