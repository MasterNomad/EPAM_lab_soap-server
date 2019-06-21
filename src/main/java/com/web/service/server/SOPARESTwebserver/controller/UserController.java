package com.web.service.server.SOPARESTwebserver.controller;

import com.web.service.server.SOPARESTwebserver.service.IUserService;
import com.webservice.soap.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController implements IUserService {

    @Autowired
    private IUserService userService;

    @Override
    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {
        System.out.println(user.getName());
        return userService.createUser(user);
    }

    @Override
    @GetMapping("/readUser/{id}")
    public User readUser(@PathVariable int id) {
        return userService.readUser(id);
    }

    @Override
    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @Override
    @DeleteMapping("/deleteUser/{id}")
    public boolean deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

}
