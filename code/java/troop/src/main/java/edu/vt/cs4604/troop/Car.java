package edu.vt.cs4604.troop;

import lombok.*;
// import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
@Table(name = "car")
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Car {
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long car_id;

  @Column(name = "c_id")
  @NotNull
  private Long c_id;

  @NotNull
  private String make_year;
  @NotNull
  private String make;
  @NotNull
  private String model;

  public Long getId() {
      return car_id;
  }
}
