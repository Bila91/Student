package com.student.demo.Controller;


import com.student.demo.Entities.Student;
import com.student.demo.Service.DTO.StudentDTO;
import com.student.demo.Service.DTO.StudentDTOName;
import com.student.demo.Service.Interfaces.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/StudentDetails")
public class StudentController {

@Autowired //  injecter les classes de l'interface
   private IStudentService service;


    @PostMapping("/saveStudent")
    public ResponseEntity<String> saveStudent( @RequestBody Student student){
        Integer id = service.saveStudent(student);
        return  new ResponseEntity<String>("Student with '"+id+"' has been saved", HttpStatus.OK);

    }


  @PutMapping("/updateStudent/{sno}")
  public  ResponseEntity<String> updateStudent(@PathVariable("sno") Integer sno, @RequestBody Student student)
  {

      Student stdFromdb = service.getStudentBYId(sno);
      stdFromdb.setStdName(student.getStdName());
      stdFromdb.setSchoolName(student.getSchoolName());
     stdFromdb.setStdClasse(student.getStdClasse());

     Integer id = service.saveStudent(stdFromdb);

    return new ResponseEntity<String>("Sudent with id : "+id+" sno is:"+sno+" has been updated", HttpStatus.OK);
  }



  @GetMapping("/studentList")
   public ResponseEntity<List<Student>>getAllStudents()
  {
   List<Student> list = service.getAllStudents();
   return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
  }


    @GetMapping("/studentListDTO")
    public ResponseEntity<List<StudentDTO>>getAllStudentsDTO()
    {
        List<StudentDTO> list = service.getAllStudentWithoutSchoolName();
        return new ResponseEntity<List<StudentDTO>>(list, HttpStatus.OK);
    }

    @GetMapping("/studentListDTOName")
    public ResponseEntity<List<StudentDTOName>>getAllStudentsNames()
    {
        List<StudentDTOName> list = service.getALLStudentName();
        return new ResponseEntity<List<StudentDTOName>>(list, HttpStatus.OK);
    }

   @GetMapping("/getStudentBYId/{sno}")
   public ResponseEntity<Student> getStudentById( @PathVariable("sno") Integer sno)
    {

      Student std = service.getStudentBYId(sno);

      return new ResponseEntity<Student>(std,HttpStatus.OK);
    }


  @DeleteMapping("deleteStudent/{sno}")
    public ResponseEntity<String> deleteStudent(@PathVariable("sno") Integer sno)
  {
    service.deleteStudent(sno);

    return new ResponseEntity<String>(" the student with id :"+sno+" has been deleted",HttpStatus.OK);

  }





}
