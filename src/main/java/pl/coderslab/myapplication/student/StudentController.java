package pl.coderslab.myapplication.student;

import java.time.OffsetDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> findAllStudents() {
        return studentService.findAll();
    }

    @PostMapping
    public void createStudent() {
        studentService.save("Zenek", OffsetDateTime.now().minusDays(1));
    }

}
