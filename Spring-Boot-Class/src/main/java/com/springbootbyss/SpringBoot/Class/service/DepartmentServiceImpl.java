package com.springbootbyss.SpringBoot.Class.service;

import com.springbootbyss.SpringBoot.Class.entity.Department;
import com.springbootbyss.SpringBoot.Class.error.DepartmentNotFoundException;
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
    public Optional<Department> fetchDepartmentById(Long id) throws DepartmentNotFoundException {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if (optionalDepartment.isEmpty()) {
            throw new DepartmentNotFoundException("Department not found");
        }
        return optionalDepartment;
    }

    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartmentById(Long id, Department department) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);

        if (optionalDepartment.isPresent()) {
            Department dbDep = optionalDepartment.get();

            // Check and update departmentName
            String newDepartmentName = department.getDepartmentName();
            if (newDepartmentName != null && !newDepartmentName.isEmpty()) {
                dbDep.setDepartmentName(newDepartmentName);
            }

            // Check and update departmentAddress
            String newDepartmentAddress = department.getDepartmentAddress();
            if (newDepartmentAddress != null && !newDepartmentAddress.isEmpty()) {
                dbDep.setDepartmentAddress(newDepartmentAddress);
            }

            // Check and update departmentCode
            String newDepartmentCode = department.getDepartmentCode();
            if (newDepartmentCode != null && !newDepartmentCode.isEmpty()) {
                dbDep.setDepartmentCode(newDepartmentCode);
            }

            return departmentRepository.save(dbDep);
        } else {
            // Handle the case where the department with the given ID is not found
            return null; // or throw an exception, or return an appropriate response
        }

    }

    @Override
    public Department fetchDepartmentByName(String name) {
        return departmentRepository.findByDepartmentNameIgnoreCase(name);
    }

}
