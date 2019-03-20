package com.gwd.thecompany.repository;

import com.gwd.thecompany.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {


//public interface OfficeRepository extends CrudRepository<Office, Integer> { //wersja z wykorzystaniem MySQL

    @Query(value = "delete from Task t where t.name = ?1") // zapis JPQL
    @Transactional //potrzebne aby dziłac tranzakcjami
    @Modifying
    void deleteByTaskName(String taskName);

}
