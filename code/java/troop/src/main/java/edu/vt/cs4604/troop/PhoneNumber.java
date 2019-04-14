package edu.vt.cs4604.troop;

import lombok.*;
// import java.time.LocalDate;
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
    name = "PhoneNumber.activeNums", 
    query = "select * from phone_number", 
    resultClass = PhoneNumber.class
  )
})

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
// @Table(name="phone_number")
// @IdClass(CompositeKey.class)
public class PhoneNumber {
    @Id
      @SequenceGenerator(name="phone_id", sequenceName="phone_id")
      @GeneratedValue(generator="phone_id")
    private Long id;

    private String c_id;
    private String c_number;
    private String c_name;
}


