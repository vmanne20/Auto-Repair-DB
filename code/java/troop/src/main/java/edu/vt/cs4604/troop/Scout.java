package edu.vt.cs4604.troop;

import lombok.*;
import java.time.LocalDate;
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
    name = "Scout.activeScouts", 
    query = "select s.* from Scout s, Attends a, ScoutTrip st " +
            "where s.id = a.scout_id and st.id = a.scouttrip_id " +
            "and st.tripdate > now() - ((interval '1 days') * to_number(:days, '99999'))", 
    resultClass = Scout.class
  )
})

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Scout {
  @Id
  @SequenceGenerator(name="scout_id", sequenceName="scout_id")
  @GeneratedValue(generator="scout_id")
  private Long id;

  
  private String name;
  private LocalDate dob;
  private String rank;
  private String tempfield;
}
