package com.web.service.server.SOPARESTwebserver.controller;

import com.web.service.server.SOPARESTwebserver.service.IUserService;
import com.webservice.soap.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController implements IUserService {

    @Autowired
    @Qualifier("userServiceH2")
    private IUserService userService;

    @Override
    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {
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
