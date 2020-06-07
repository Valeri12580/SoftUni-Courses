package bg.softuni.carshop.init;

import bg.softuni.carshop.models.entity.*;
import bg.softuni.carshop.models.enums.Roles;
import bg.softuni.carshop.repositories.BrandRepository;
import bg.softuni.carshop.repositories.ModelRepository;
import bg.softuni.carshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class Init implements CommandLineRunner {
    private List<User> USERS = List.of(new User("Valeri12580", "Valeri", "Stoqnov"
            , false, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__340.jpg",
            new UserRole(Roles.ADMIN)), new User("Tester", "Krasimir", "Enchev",
            true, "data:image/jpeg;base64,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",
            new UserRole(Roles.USER)));

    private Map<Brand, Set<Model>> MODELS = Map.of(new Brand("Ford"), Set.of(new Model("Mustang", "data:image/jpeg;base64,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",
            1978, 2050), new Model("Focus", "asd", 2001, 2008)), new Brand("BMW"), Set.of(new Model("M1", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/26/BMW_M1%2C_front_right_%28Brooklyn%29.jpg/560px-BMW_M1%2C_front_right_%28Brooklyn%29.jpg", 1978, 1981), new Model("X5", "data:image/jpeg;base64,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", 2000, 2050)));


    private ModelRepository modelRepository;
    private UserRepository userRepository;
    private BrandRepository brandRepository;

    @Autowired
    public Init(ModelRepository modelRepository, UserRepository userRepository, BrandRepository brandRepository) {
        this.modelRepository = modelRepository;
        this.userRepository = userRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        this.USERS.forEach(u -> {
            this.userRepository.save(u);
        });

        this.MODELS.entrySet().forEach(e -> {
            Brand brand = e.getKey();
            this.brandRepository.save(brand);
            e.getValue().forEach(m -> {
                m.setBrand(brand);
                this.modelRepository.save(m);
            });
        });


    }
}
