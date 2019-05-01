package edu.vt.cs4604.troop;

import java.util.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.query.Param;

@RepositoryRestResource
interface RepairRepository extends JpaRepository<Repair, Long> {
  /**
   * Finds active scouts
   * @return  A list of scouts who have attended a trip recently.
   */
  @Query(nativeQuery = true)
  public List<Repair> activeRepairs(@Param("days")String days);
}
