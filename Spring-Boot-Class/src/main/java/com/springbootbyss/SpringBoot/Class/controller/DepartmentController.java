package com.springbootbyss.SpringBoot.Class.controller;

import com.springbootbyss.SpringBoot.Class.entity.Department;
import com.springbootbyss.SpringBoot.Class.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping
    public Department saveDepartment(@Valid @RequestBody Department department) {
        logger.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping
    public List<Department> fetchDepartmentList() {
        logger.info("Inside fetchDepartmentList of DepartmentController");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/{id}")
    public Optional<Department> fetchDepartmentById(@PathVariable Long id) {
        logger.info("Inside fetchDepartmentById of DepartmentController");
        return departmentService.fetchDepartmentById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteDepartmentById(@PathVariable Long id) {
        logger.info("Inside deleteDepartmentById of DepartmentController");
        departmentService.deleteDepartmentById(id);
        return "Department is deleted";
    }

    @PutMapping("/{id}")
    public Department updateDepartmentById(@PathVariable Long id, @RequestBody Department department) {
        logger.info("Inside updateDepartmentById of DepartmentController");
        return departmentService.updateDepartmentById(id, department);
    }

    @GetMapping("/name/{name}")
    public Optional<Department> fetchDepartmentByName(@PathVariable String name) {
        logger.info("Inside fetchDepartmentByName of DepartmentController");
        return Optional.ofNullable(departmentService.fetchDepartmentByName(name));
    }
}
