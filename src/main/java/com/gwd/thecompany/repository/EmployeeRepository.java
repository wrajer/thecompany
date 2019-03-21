package com.gwd.thecompany.repository;

import com.gwd.thecompany.model.Employee;
import com.gwd.thecompany.model.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    @Query(value = "select count(id) from Employee e where e.office = ?1")
    Long getNoOfPeoleInOneOffice(Optional<Office> office);


}
