package edu.vt.cs4604.troop;

import lombok.*;
// import java.time.LocalDate;
import javax.persistence.*;

/*
 * NamedNativeQueries allow us to use _SQL_ queries
 * to perform complex queries against the database.
 * Alternatively NamedQueries use _JPQL_ to accomplish
 * the same thing.
 * https://en.wikipedia.org/wiki/Java_Persistence_Query_Language
 */
@NamedNativeQueries({
  @NamedNativeQuery(
    name = "Customer.activeCustomers", 
    query = "select * from Customer", 
    resultClass = Customer.class
  )
})

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Customer {
  @Id
  @SequenceGenerator(name="customer_id", sequenceName="customer_id")
  @GeneratedValue(generator="customer_id")
  private Long id;

  private String c_name;
  private String c_address;
}
