package com.Msoftwares.department.controller;

import com.Msoftwares.department.entity.Department;
import com.Msoftwares.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department){
        log.info("Inside department method save");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable("id") Long deptId){
        log.info("Inside department method get");
        return departmentService.findDepartmentById(deptId);

    }







}
