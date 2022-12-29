package com.student.demo.Service.Implementations;


import com.student.demo.Entities.Student;
import com.student.demo.Repos.StudentRepository;
import com.student.demo.Service.DTO.StudentDTO;
import com.student.demo.Service.DTO.StudentDTOName;
import com.student.demo.Service.Interfaces.IStudentService;
import com.student.demo.Service.Mapper.StudentMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentImpl implements IStudentService {

 @Autowired // injecter classe jpa
 private StudentRepository repository;




@Autowired
private StudentMap studentMap;


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


    @Override
    public List<StudentDTO> getAllStudentWithoutSchoolName() {
       List<Student> students = (List<Student>)repository.findAll();

        List<StudentDTO> studentDTOS = students.stream().map(std->studentMap.mapTostudentDTO(std)).collect(Collectors.toList());
        return studentDTOS;
    }

    @Override
    public List<StudentDTOName> getALLStudentName() {
        List<Student> students = (List<Student>) repository.findAll();

        List<StudentDTOName> studentDTONames = students.stream().map(std->studentMap.mapTostudentDTOName(std)).collect(Collectors.toList());
        return studentDTONames;
    }


}
