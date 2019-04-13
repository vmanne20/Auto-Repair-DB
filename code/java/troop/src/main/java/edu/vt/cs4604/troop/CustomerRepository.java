package edu.vt.cs4604.troop;

import java.util.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.query.Param;

@RepositoryRestResource
interface CustomerRepository extends JpaRepository<Customer, Long> {
  /**
   * Finds active customers
   * @return  A list of customers.
   */
  @Query(nativeQuery = true)
  public List<Customer> activeCustomers(@Param("days")String days);
}
