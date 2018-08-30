package edu.vt.cs4604.troop;

import lombok.*;
import java.time.LocalDate;
import javax.persistence.*;

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
}
