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
    name = "Car.activeCars", 
    query = "select * from Car", 
    resultClass = Car.class
  )
})

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Car {
  @Id
  @SequenceGenerator(name="car_id", sequenceName="car_id")
  @GeneratedValue(generator="car_id")
  private Long id;

  private String make_year;
  private String make;
  private String model;
}
