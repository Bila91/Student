package com.student.demo.Controller;



import com.student.demo.Entities.Role;
import com.student.demo.Service.Interfaces.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/RoleDetails")
public class RoleController {

    @Autowired //  injecter les classes de l'interface
    private IRoleService service;


    @PostMapping("/saveRole")
    public ResponseEntity<String> saveRole( @RequestBody Role Role){
        Integer id = service.saveRole(Role);
        return  new ResponseEntity<String>("Role with '"+id+"' has been saved", HttpStatus.OK);

    }


    @PutMapping("/updateRole/{sno}")
    public  ResponseEntity<String> updateRole(@PathVariable("sno") Integer sno, @RequestBody Role role)
    {

        Role stdFromdb = service.getRoleBYId(sno);
        stdFromdb.setRoleName(role.getRoleName());


        Integer id = service.saveRole(stdFromdb);

        return new ResponseEntity<String>("Sudent with id : "+id+" sno is:"+sno+" has been updated", HttpStatus.OK);
    }



    @GetMapping("/RoleList")
    public ResponseEntity<List<Role>>getAllRoles()
    {
        List<Role> list = service.getAllRoles();
        return new ResponseEntity<List<Role>>(list, HttpStatus.OK);
    }




    @GetMapping("/getRoleBYId/{sno}")
    public ResponseEntity<Role> getRoleById( @PathVariable("sno") Integer sno)
    {

        Role std = service.getRoleBYId(sno);

        return new ResponseEntity<Role>(std,HttpStatus.OK);
    }


    @DeleteMapping("deleteRole/{sno}")
    public ResponseEntity<String> deleteRole(@PathVariable("sno") Integer sno)
    {
        service.deleteRole(sno);

        return new ResponseEntity<String>(" the Role with id :"+sno+" has been deleted",HttpStatus.OK);

    }





}
