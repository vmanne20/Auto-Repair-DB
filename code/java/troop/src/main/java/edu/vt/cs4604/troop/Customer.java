package edu.vt.cs4604.troop;

import lombok.*;
import javax.persistence.*;
import java.util.*;

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
@Table(name = "customer")
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

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "c_id", referencedColumnName = "c_id", nullable = false)
    List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();

    public void addPhoneNumber(PhoneNumber pn) {
        pn.setCustomer(this);
        phoneNumbers.add(pn);
    }

    public Long getId() {
        return c_id;
    }
 }
