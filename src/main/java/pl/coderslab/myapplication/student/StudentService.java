package pl.coderslab.myapplication.student;

import java.time.OffsetDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public void save(String name, OffsetDateTime registrationDate) {
        if (OffsetDateTime.now().isBefore(registrationDate)) {
            throw new IllegalArgumentException("Registration date can't be from future");
        }

        Student student = Student.builder()
            .name(name)
            .registrationDate(registrationDate)
            .build();

        studentRepository.save(student);
    }

}
