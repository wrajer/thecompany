package com.gwd.thecompany.repository;

import com.gwd.thecompany.model.Employee;
import com.gwd.thecompany.model.Office;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {


}
