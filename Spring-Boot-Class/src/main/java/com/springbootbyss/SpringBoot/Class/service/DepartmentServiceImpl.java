package com.springbootbyss.SpringBoot.Class.service;

import com.springbootbyss.SpringBoot.Class.entity.Department;
import com.springbootbyss.SpringBoot.Class.repository.DepartmentRepository;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Optional<Department> fetchDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartmentById(Long id, Department department) {
        Department dbDep = departmentRepository.findById(id).get();

        // check for name
        if (Objects.nonNull(department.getDepartmentName()) && !"" .equalsIgnoreCase(department.getDepartmentName())) {
            dbDep.setDepartmentName(department.getDepartmentName());
        }

        // for department address
        if (Objects.nonNull(department.getDepartmentAddress()) && !"" .equalsIgnoreCase(department.getDepartmentAddress())) {
            dbDep.setDepartmentAddress(department.getDepartmentAddress());
        }

        // for department code
        if (Objects.nonNull(department.getDepartmentCode()) && !"" .equalsIgnoreCase(department.getDepartmentCode())) {
            dbDep.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(dbDep);
    }
}
