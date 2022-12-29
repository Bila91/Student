package com.student.demo.Service.Implementations;


import com.student.demo.Entities.Role;
import com.student.demo.Entities.User;
import com.student.demo.Repos.RoleRepository;
import com.student.demo.Repos.UserRepository;
//import com.student.demo.Service.DTO.UserDTO;
//import com.student.demo.Service.DTO.UserDTOName;
import com.student.demo.Service.Interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserImpl implements IUserService {

 @Autowired // injecter classe jpa
 private UserRepository repository;
    @Autowired // injecter classe jpa
    private RoleRepository roleRepository;


//
//@Autowired
//private UserMap UserMap;


    @Override
    public Integer saveUser(User User) {
        return repository.save(User).getId();
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) repository.findAll();
    }

    @Override
    public User getUserBYId(Integer sno) {
        return repository.findById(sno).get();
    }



    @Override
    public void deleteUser(Integer sno) {
          repository.deleteById(sno);
    }

    @Override
    public Integer assignRole(Integer iduser, Integer idrole) {



       Role role=roleRepository.findById(idrole).get();
        (repository.findById(iduser)).get().getRoles().add(role);

        User uu=repository.findById(iduser).get();

        repository.save(uu);
        return uu.getId();
    }


//    @Override
//    public List<UserDTO> getAllUserWithoutSchoolName() {
//       List<User> Users = (List<User>)repository.findAll();
//
//        List<UserDTO> UserDTOS = Users.stream().map(std->UserMap.mapToUserDTO(std)).collect(Collectors.toList());
//        return UserDTOS;
//    }
//
//    @Override
//    public List<UserDTOName> getALLUserName() {
//        List<User> Users = (List<User>) repository.findAll();
//
//        List<UserDTOName> UserDTONames = Users.stream().map(std->UserMap.mapToUserDTOName(std)).collect(Collectors.toList());
//        return UserDTONames;
//    }


}
