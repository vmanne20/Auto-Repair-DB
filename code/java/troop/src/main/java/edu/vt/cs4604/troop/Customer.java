package edu.vt.cs4604.troop;

import lombok.*;
// import java.time.LocalDate;
import javax.persistence.*;
import java.util.*;
// import java.util.stream.Collectors;
// import java.util.stream.Stream;
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
    query = "select * from customer", 
    resultClass = Customer.class
  )
})

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @OneToMany
    // // (cascade = CascadeType.ALL)
    // @JoinColumn(name = "id")
  private Long c_id;

  private String c_name;
  private String c_address;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "c_id", referencedColumnName = "c_id", nullable = false)
  List<PhoneNumber> phone_numbers = new ArrayList<>();
}
