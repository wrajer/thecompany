package com.gwd.thecompany.repository;
import com.gwd.thecompany.model.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Integer> {


//    @Query(value = "delete from Planet p where p.planetName = ?1") // zapis JPQL
//    @Transactional //potrzebne aby dziłac tranzakcjami
//    @Modifying
//    void deleteByTaskTitle(String TaskTitle);

//for updates
    @Query(value = "Select o from Office o where o.name = ?1") // zapis JPQL
    Optional<Office> findByOfficeName(String officeName);

}
