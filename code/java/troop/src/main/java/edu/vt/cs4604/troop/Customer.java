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
    public Customer(String c_name, String c_address, Object[] numbers) {
        this.c_name = c_name;
        this.c_address = c_address;

        this.numbers = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            PhoneNumber pn = new PhoneNumber(c_name, (String) numbers[i], this);
            this.numbers.add(pn);
        }
        
        // this.numbers.forEach(phoneNumber -> { 
        //     phoneNumber.setName(c_name);
        //     phoneNumber.setNumber((String) numbers[i]);
        //     phoneNumber.setCustomer(this);
        //     i++;
        // });

        // this.numbers = Stream.of(numbers).collect(Collectors.toSet());
        // this.numbers.forEach(x -> x.setCustomer(this));
    }
}
