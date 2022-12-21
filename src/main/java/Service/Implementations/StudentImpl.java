package Service.Implementations;

import Entity.Student;
import Repos.StudentRepository;
import Service.Interfaces.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class StudentImpl implements IStudentService {

 @Autowired // injecter classe jpa
 private StudentRepository repository;

    @Override
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return null;
    }

    @Override
    public Student getStudentBYId(Integer sno) {
        return null;
    }

    @Override
    public void deleteStudent(Integer sno) {

    }
}
