package edu.vt.cs4604.troop;

import lombok.*;

// import java.sql.Timestamp;
import javax.persistence.*;
// import java.io.*;

/*
 * NamedNativeQueries allow us to use _SQL_ queries
 * to perform complex queries against the database.
 * Alternatively NamedQueries use _JPQL_ to accomplish
 * the same thing.
 * https://en.wikipedia.org/wiki/Java_Persistence_Query_Language
 */

@NamedNativeQueries({
  @NamedNativeQuery(
    name = "PhoneNumber.findByCustomerId", 
    query = "select p.c_id, p.p_id, p.p_number from phone_number p, customer c where p.c_id = :customerId", 
    resultClass = PhoneNumber.class
  )
})

@Entity
@Table(name = "phone_number")
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class PhoneNumber {

    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long p_id;

    @Column(name = "c_id")
    private Long c_id;

    private String p_number;
}
