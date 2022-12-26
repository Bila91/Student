package com.student.demo.Service.Implementations;


import com.student.demo.Entities.Student;
import com.student.demo.Repos.StudentRepository;
import com.student.demo.Service.Interfaces.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class StudentImpl implements IStudentService {

 @Autowired // injecter classe jpa
 private StudentRepository repository;

    @Override
    public Integer saveStudent(Student student) {
        return repository.save(student).getSno();
    }

    @Override
    public List<Student> getAllStudents() {
        return (List<Student>) repository.findAll();
    }

    @Override
    public Student getStudentBYId(Integer sno) {
        return repository.findById(sno).get();
    }

    @Override
    public void deleteStudent(Integer sno) {
          repository.deleteById(sno);
    }
}
