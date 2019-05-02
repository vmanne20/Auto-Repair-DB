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
    name = "Cert.activeCerts", 
    query = "select * from certification", 
    resultClass = Cert.class
  )
})

@Entity
@Table(name = "certification")
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Cert
 {
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long cert_id;
  private String cert_name;

//   @Column(name = "r_id")
//   private Long r_id;

//   @Column (name = "m_id")
//   private Long m_id;
}
