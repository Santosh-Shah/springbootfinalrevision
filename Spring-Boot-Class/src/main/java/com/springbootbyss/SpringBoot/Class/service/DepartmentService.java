package com.springbootbyss.SpringBoot.Class.service;

import com.springbootbyss.SpringBoot.Class.entity.Department;
import com.springbootbyss.SpringBoot.Class.error.DepartmentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Optional<Department> fetchDepartmentById(Long id) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long id);

    public Department updateDepartmentById(Long id, Department department);

    public Department fetchDepartmentByName(String name);
}
