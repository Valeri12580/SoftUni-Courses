package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entities.Picture;

import java.util.List;

@Repository
public interface PictureRepository  extends JpaRepository<Picture,Integer> {

    List<Picture> getAllByCarId(int id);

}
