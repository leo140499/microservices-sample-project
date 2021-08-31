package com.Msoftwares.userservice.controller;

import com.Msoftwares.userservice.VO.ResponseTemplateVO;
import com.Msoftwares.userservice.entity.User;
import com.Msoftwares.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("Inside saveUser of UserController");
       return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDept(@PathVariable("id") Long userId){
        log.info("Inside getUserWithDept of UserController");
        return userService.getUserWithDept(userId);
    }


}
