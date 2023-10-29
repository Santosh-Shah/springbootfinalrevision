package com.springbootbyss.SpringBoot.Class.controller;

import com.springbootbyss.SpringBoot.Class.entity.Department;
import com.springbootbyss.SpringBoot.Class.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping
    public List<Department> fetchDepartmentList() {
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/{id}")
    public Optional<Department> fetchDepartmentById(@PathVariable Long id) {
        return departmentService.fetchDepartmentById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteDepartmentById(@PathVariable Long id) {
        departmentService.deleteDepartmentById(id);
        return "Department is deleted";
    }

    @PutMapping("/{id}")
    public Department updateDepartmentById(@PathVariable Long id, @RequestBody Department department) {
        return departmentService.updateDepartmentById(id, department);
    }

    @GetMapping("/name/{name}")
    public Optional<Department> fetchDepartmentByName(@PathVariable String name) {
        return Optional.ofNullable(departmentService.fetchDepartmentByName(name));
    }
}
