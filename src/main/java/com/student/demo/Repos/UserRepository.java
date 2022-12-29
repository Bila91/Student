package com.student.demo.Repos;

import com.student.demo.Entities.Note;
import com.student.demo.Entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
