package edu.vt.cs4604.troop;

import lombok.*;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Scout {
  @Id
  private String name;
  private LocalDate dob;
  private String rank;
}
