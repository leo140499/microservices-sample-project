package com.Msoftwares.department.service;

import com.Msoftwares.department.entity.Department;
import com.Msoftwares.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    public Department saveDepartment(Department department) {
        log.info("Inside savedDepartment of departmentService");
        return departmentRepository.save(department);
    }


    public Department findDepartmentById(Long deptId) {
        return departmentRepository.findByDepartmentId(deptId);
    }
}
