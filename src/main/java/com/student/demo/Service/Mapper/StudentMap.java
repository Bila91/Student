package com.student.demo.Service.Mapper;


import com.student.demo.Entities.Student;
import com.student.demo.Service.DTO.StudentDTO;
import com.student.demo.Service.DTO.StudentDTOName;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Basic;
@Component
public class StudentMap {
    @Autowired
    private ModelMapper mapper;


    // convert Student into DTO

    public StudentDTO mapTostudentDTO(Student student)
    {
        StudentDTO studentDTO = mapper.map(student, StudentDTO.class);

        return studentDTO;
    }

    // convert DTO into Entity
    public Student mapToEntity (StudentDTO studentDTO)
    {
        Student student = mapper.map(studentDTO, Student.class);

        return student;

    }

    // other example of name
    public StudentDTOName mapTostudentDTOName(Student student)
    {
        StudentDTOName studentDTOName = mapper.map(student, StudentDTOName.class);
        return studentDTOName;
    }

    public Student mapNameToEntity(StudentDTOName studentDTOName)
    {

        Student student = mapper.map(studentDTOName, Student.class);
        return student;
    }


}
