package com.student.demo.Service.Implementations;



import com.student.demo.Entities.Role;
import com.student.demo.Repos.RoleRepository;
import com.student.demo.Service.Interfaces.IRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleImpl implements IRoleService {

 @Autowired // injecter classe jpa
 private RoleRepository repository;





    @Override
    public Integer saveRole(Role Role) {
        return repository.save(Role).getId();
    }

    @Override
    public List<Role> getAllRoles() {
        return (List<Role>) repository.findAll();
    }

    @Override
    public Role getRoleBYId(Integer sno) {
        return repository.findById(sno).get();
    }



    @Override
    public void deleteRole(Integer sno) {
          repository.deleteById(sno);
    }





}
