package com.student.demo.Repos;

import com.student.demo.Entities.Note;
import com.student.demo.Entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

}
