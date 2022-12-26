package com.student.demo.Repos;


import com.student.demo.Entities.Note;
import com.student.demo.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRepository extends CrudRepository<Student,Integer> {


}
