package bg.softuni.exampreptwo.services;

import bg.softuni.exampreptwo.models.binding.HeroCreateBindingModel;
import bg.softuni.exampreptwo.models.entity.Hero;
import bg.softuni.exampreptwo.models.view.HeroDetailViewModel;
import bg.softuni.exampreptwo.models.view.HeroHomeViewModel;
import bg.softuni.exampreptwo.repository.HeroRepository;
import bg.softuni.exampreptwo.services.interfaces.HeroService;
import bg.softuni.exampreptwo.services.interfaces.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class HeroServiceImpl implements HeroService {
    private ModelMapper modelMapper;
    private HeroRepository heroRepository;
    private UserService userService;

    @Autowired
    public HeroServiceImpl(ModelMapper modelMapper, HeroRepository heroRepository, UserService userService) {
        this.modelMapper = modelMapper;
        this.heroRepository = heroRepository;
        this.userService = userService;
    }

    @Override
    public List<HeroHomeViewModel> getAllHeroes() {
        List<HeroHomeViewModel>heroes= Arrays.asList(this.modelMapper.map(this.heroRepository.findAll(),HeroHomeViewModel[].class));
        heroes.forEach(e->e.setImageUrl(String.format("\\img\\%s.jpg",e.getHeroClass().toString().toLowerCase())));

        return heroes;
    }

    @Override
    public void addHero(HeroCreateBindingModel heroCreateBindingModel) {
        Hero hero = this.modelMapper.map(heroCreateBindingModel, Hero.class);
        hero.setUser(this.userService.getUserByUsername(heroCreateBindingModel.getUsername()));
        this.heroRepository.save(hero);
    }

    @Override
    public HeroDetailViewModel findById(String id) {
        return this.modelMapper.map(this.heroRepository.findById(id).get(),HeroDetailViewModel.class);
    }

    @Override
    public void delete(String id) {
        this.heroRepository.deleteById(id);
    }
}
