package com.springbootbyss.SpringBoot.Class.repository;

import com.springbootbyss.SpringBoot.Class.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Department findByDepartmentNameIgnoreCase(String deptName);
    public Department findByDepartmentName(String name);
}
