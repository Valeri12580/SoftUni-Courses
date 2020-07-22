package bg.softuni.events.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class StudentService {

    @Cacheable("students")
    public List<Student> getAllStudents() {
        System.out.println("Im doing complicated work to generate students..");
        return generateStudents();
    }

    @CachePut("students")
    public List<Student> updateAllStudents(){
        System.out.println("Im updating students");
        return this.getAllStudents();

    }


    @CacheEvict(cacheNames = "students",allEntries = true)
    public void deleteCache(){
        System.out.println("Im deleting students");
    }

    private List<Student> generateStudents() {
            Random random=new Random();
            return List.of(new Student("Valeri",random.nextInt(10)),new Student("Kacho",random.nextInt(10)));
    }




}
