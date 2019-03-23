package com.gwd.thecompany.repository;


import com.gwd.thecompany.model.Employee;
import com.gwd.thecompany.model.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    @Query(value = "SELECT COUNT(e.id) FROM employees e join offices o Where (e.office_id=?1 AND o.id=?1 )", nativeQuery = true)
    Long getNoOfPeoleInOneOfficeById(Long id);


    @Query(value = "select count(id) from Employee e where e.office = ?1")
    Long getNoOfPeoleInOneOffice(Office office);


    @Query(value = "select e from Employee e where e.name = ?1")
    Optional<Employee> findEmployeeByName(String name);

}

