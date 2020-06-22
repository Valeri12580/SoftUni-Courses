package bg.softuni.examprep.init;

import bg.softuni.examprep.models.entities.Category;
import bg.softuni.examprep.models.enums.CategoryType;
import bg.softuni.examprep.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Init implements CommandLineRunner {
    private CategoryRepository categoryRepository;

    @Autowired
    public Init(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args)  {
        if(this.categoryRepository.count()==0){
            this.categoryRepository.save(new Category(CategoryType.DENIM,"Original denim"));
            this.categoryRepository.save(new Category(CategoryType.JACKET,"Original jackets"));
            this.categoryRepository.save(new Category(CategoryType.SHIRT,"Original shirts"));
            this.categoryRepository.save(new Category(CategoryType.SHORTS,"Original shorts"));
        }
    }
}
