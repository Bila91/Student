package com.student.demo.Service.Interfaces;


import com.student.demo.Entities.Role;

import java.util.List;

public interface IRoleService {

    public Integer saveRole(Role Role);

    public List<Role> getAllRoles();

    public Role getRoleBYId(Integer id);

    public void deleteRole(Integer id);

}
