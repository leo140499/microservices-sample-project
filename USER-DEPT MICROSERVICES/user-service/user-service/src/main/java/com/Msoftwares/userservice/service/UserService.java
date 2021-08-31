package com.Msoftwares.userservice.service;

import com.Msoftwares.userservice.VO.Department;
import com.Msoftwares.userservice.VO.ResponseTemplateVO;
import com.Msoftwares.userservice.entity.User;
import com.Msoftwares.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        log.info("Inside saveUser of UserService");
       return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDept(Long userId) {
        log.info("Inside getUserWithDept of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);
        Department department = restTemplate.getForObject("http://DEPT-SERVICE/departments/" + user.getDepartmentId(), Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
