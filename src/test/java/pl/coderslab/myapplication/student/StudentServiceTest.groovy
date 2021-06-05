package pl.coderslab.myapplication.student

import spock.lang.Specification
import spock.lang.Subject

import java.time.OffsetDateTime

class StudentServiceTest extends Specification {

    StudentRepository studentRepository = Mock(StudentRepository) //alternatywnie stworzenie in memory implementacji pod testy

    @Subject
    StudentService service = new StudentService(studentRepository)

    def "should throw error when registration date is from the future"() {
        given: "date from future is provided"
        def futureDate = OffsetDateTime.now().plusDays(1)

        when:
        service.save("Zenek", futureDate)

        then: "exception is thrown"
        thrown(IllegalArgumentException)
    }

    def "should save user to db"() {
        given:
        def pastDate = OffsetDateTime.now().minusHours(4)
        def name = "Zenek"

        when:
        service.save(name, pastDate)

        then:
        1 * studentRepository.save(_ as Student) >> {
            Student student = (Student) it[0]
            assert student.registrationDate == pastDate
            assert student.name == name
        }
    }

}
