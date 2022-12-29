package com.student.demo.Controller;

import com.student.demo.Entities.User;
import com.student.demo.Service.Interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/UserDetails")
public class UserController {

    @Autowired //  injecter les classes de l'interface
    private IUserService service;


    @PostMapping("/saveUser")
    public ResponseEntity<String> saveUser(@RequestBody User User) {
        Integer id = service.saveUser(User);
        return new ResponseEntity<String>("User with '" + id + "' has been saved", HttpStatus.OK);

    }

    @PostMapping("/RoleToUser/{idu}/{idr}")
    public ResponseEntity<String> assignRoleToUser(@PathVariable Integer idu , @PathVariable Integer idr) {
        Integer id = service.assignRole(idu,idr);
        return new ResponseEntity<String>("User with '" + id + "' has been saved", HttpStatus.OK);

    }
    @PutMapping("/updateUser/{sno}")
    public ResponseEntity<String> updateUser(@PathVariable("sno") Integer sno, @RequestBody User User) {

        User stdFromdb = service.getUserBYId(sno);
        stdFromdb.setUsername(User.getUsername());


        Integer id = service.saveUser(stdFromdb);

        return new ResponseEntity<String>("Sudent with id : " + id + " sno is:" + sno + " has been updated", HttpStatus.OK);
    }


    @GetMapping("/UserList")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> list = service.getAllUsers();
        return new ResponseEntity<List<User>>(list, HttpStatus.OK);
    }


    @GetMapping("/getUserBYId/{sno}")
    public ResponseEntity<User> getUserById(@PathVariable("sno") Integer sno) {

        User std = service.getUserBYId(sno);

        return new ResponseEntity<User>(std, HttpStatus.OK);
    }


    @DeleteMapping("deleteUser/{sno}")
    public ResponseEntity<String> deleteUser(@PathVariable("sno") Integer sno) {
        service.deleteUser(sno);

        return new ResponseEntity<String>(" the User with id :" + sno + " has been deleted", HttpStatus.OK);

    }


}