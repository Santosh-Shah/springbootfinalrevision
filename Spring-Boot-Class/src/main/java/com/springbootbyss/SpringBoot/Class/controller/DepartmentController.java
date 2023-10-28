package com.springbootbyss.SpringBoot.Class.controller;

import com.springbootbyss.SpringBoot.Class.entity.Department;
import com.springbootbyss.SpringBoot.Class.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Optional<Department> fetchDepartmentById(@PathVariable Long id) {
        return departmentService.fetchDepartmentById(id);
    }
}
