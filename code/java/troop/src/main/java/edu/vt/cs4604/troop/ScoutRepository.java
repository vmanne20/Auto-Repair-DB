package edu.vt.cs4604.troop;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@RepositoryRestResource
interface ScoutRepository extends JpaRepository<Scout, String> {
  @Transactional
  @Modifying
  @Query("delete from scout where scout.id=:id")
  public Scout deleteScout(@Param("id") Long scoutId);
}
