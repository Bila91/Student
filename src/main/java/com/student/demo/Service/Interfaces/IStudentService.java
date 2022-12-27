package com.student.demo.Service.Interfaces;



import com.student.demo.Entities.Student;
import com.student.demo.Service.DTO.StudentDTO;
import com.student.demo.Service.DTO.StudentDTOName;

import java.util.List;

public interface IStudentService {

    public Integer saveStudent(Student student);

    public List<Student> getAllStudents();

    public Student getStudentBYId(Integer sno);

    public void deleteStudent(Integer sno);

    public List <StudentDTO> getAllStudentWithoutSchoolName ();

    public List<StudentDTOName> getALLStudentName();

}
