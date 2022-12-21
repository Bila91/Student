package Service.Interfaces;


import Entity.Student;

import java.util.List;

public interface IStudentService {

    public Student saveStudent(Student student);

    public List<Student> getAllStudents();

    public Student getStudentBYId(Integer sno);

    public void deleteStudent(Integer sno);

}
