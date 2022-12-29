package com.student.demo.Service.Interfaces;


import com.student.demo.Entities.Student;
import com.student.demo.Entities.User;
import com.student.demo.Service.DTO.StudentDTO;
import com.student.demo.Service.DTO.StudentDTOName;

import java.util.List;

public interface IUserService {

    public Integer saveUser(User User);

    public List<User> getAllUsers();

    public User getUserBYId(Integer id);

    public void deleteUser(Integer id);


    Integer assignRole(Integer iduser, Integer idrole);
}
