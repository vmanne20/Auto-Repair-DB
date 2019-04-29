package edu.vt.cs4604.troop;

// import java.sql.Timestamp;
import java.util.*;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.query.Param;

@RepositoryRestResource
interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long> {
  
//   @Query(nativeQuery = true)
//   public List<PhoneNumber> activeNums(@Param("days")String days);

/**
   * Finds phone numbers for particular customer
   * @return  A list of phone numbers.
   */
//   @Query(nativeQuery = true)
  public List<PhoneNumber> findByCustomerId(@Param("c_id") Long c_id);
}
