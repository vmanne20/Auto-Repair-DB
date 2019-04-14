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
    query = "select * from Customer", 
    resultClass = Customer.class
  )
})

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table(name="customer")
public class Customer {
  @Id
  @SequenceGenerator(name="customer_id", sequenceName="customer_id")
  @GeneratedValue(generator="customer_id")
  private Long id;

  private String c_name;
  private String c_address;

  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<PhoneNumber> numbers;

    // int i = 0;
    public Customer(String c_name, String c_address, String[] numbers) {
        this.c_name = c_name;
        this.c_address = c_address;

        this.numbers = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            CompositeKey key = new CompositeKey(numbers[i], this);
            PhoneNumber pn = new PhoneNumber(this.c_name, key);
            this.numbers.add(pn);
        }
    }

    public String getName() {
        return c_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long c_id) {
        id = c_id;
    }
}
