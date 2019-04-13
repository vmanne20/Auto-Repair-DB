package edu.vt.cs4604.troop;

import java.util.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.query.Param;

@RepositoryRestResource
interface PhoneNumberRepository extends JpaRepository<PhoneNumber, String> {
  /**
   * Finds active customers
   * @return  A list of customers.
   */
  @Query(nativeQuery = true)
  public List<PhoneNumber> activeNums(@Param("days")String days);
}
