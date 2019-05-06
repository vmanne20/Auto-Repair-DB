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
    name = "Repair.activeRepairs", 
    query = "select * from repair", 
    resultClass = Repair.class
  )
})

@Entity
@Table(name = "repair")
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Repair {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long r_id;

    private String r_name;
    private String r_descript;
    private Double parts_cost;
    private Double r_time;

    public Long getId() {
        return r_id;
    }
 
    public String getName() {
        return r_name;
    }
 }
