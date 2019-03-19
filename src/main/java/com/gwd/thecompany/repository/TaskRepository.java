package com.gwd.thecompany.repository;

import com.gwd.thecompany.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
//public interface OfficeRepository extends CrudRepository<Office, Integer> { //wersja z wykorzystaniem MySQL


}
