package com.student.demo.Service.Interfaces;



import com.student.demo.Entities.Student;

import java.util.List;

public interface IStudentService {

    public Integer saveStudent(Student student);

    public List<Student> getAllStudents();

    public Student getStudentBYId(Integer sno);

    public void deleteStudent(Integer sno);

}
