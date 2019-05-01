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
    name = "Mechanic.activeMechs", 
    query = "select * from mechanic", 
    resultClass = Mechanic.class
  )
})

@Entity
@Table(name = "mechanic")
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Mechanic {
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long m_id;

  private String m_name;
  private Long years_exp;
  private Double hourly_rate;
}
