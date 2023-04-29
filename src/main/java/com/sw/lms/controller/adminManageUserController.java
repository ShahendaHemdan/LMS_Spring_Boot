package com.sw.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sw.lms.services.*;
import com.sw.lms.interfaces.user.UserDeleter;
import com.sw.lms.interfaces.user.UserRetriever;
import com.sw.lms.interfaces.user.UserSaver;
import com.sw.lms.interfaces.user.UserUpdater;
import com.sw.lms.model.*;

@RestController
@RequestMapping("/admin")
public class adminManageUserController {
    @Autowired
    public adminManageUserService adminService;

    @Autowired
    private UserSaver userSaver;

    @Autowired
    private UserDeleter userDeleter;

    @Autowired
    private UserRetriever userRetriever;

    @Autowired
    private UserUpdater userUpdater;

    @GetMapping("/allUsers")
    public List<User> findAll() {
        return userRetriever.findAll();
    }

    @GetMapping("/findUser/{id}")
    public User findById(@PathVariable Long id) {
        return userRetriever.findById(id);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteById(@PathVariable Long id) {
        userDeleter.deleteById(id);
        return " user with id: " + id + " deleted from the database";
    }

    @PostMapping("addUser")
    public ResponseEntity<User> save(@RequestBody User user) {
        userSaver.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/updateUser/{id}")
    public String update(@RequestBody User user, @PathVariable Long id) {
        return userUpdater.update(user, id) + " user updated successfully";
    }

}
