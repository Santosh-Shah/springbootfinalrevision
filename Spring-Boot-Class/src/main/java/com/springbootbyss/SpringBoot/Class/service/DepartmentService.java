package com.springbootbyss.SpringBoot.Class.service;

import com.springbootbyss.SpringBoot.Class.entity.Department;
import org.springframework.stereotype.Service;

@Service
public interface DepartmentService {
    public Department saveDepartment(Department department);
}
