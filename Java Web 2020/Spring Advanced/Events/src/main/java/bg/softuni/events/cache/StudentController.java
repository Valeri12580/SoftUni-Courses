package bg.softuni.events.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students/all")
    public ResponseEntity<List<Student>>getAllStudents(){
        return ResponseEntity.ok(this.studentService.getAllStudents());
    }


    @GetMapping("/students/update")
    public String  updateAllStudents(){

        this.studentService.updateAllStudents();
        //toesnt update
        return "Done";
    }

    @GetMapping("/students/delete")
    public ResponseEntity<List<Student>>deleteAllStudents(){
        this.studentService.deleteCache();
        return ResponseEntity.ok().build();
    }
}
