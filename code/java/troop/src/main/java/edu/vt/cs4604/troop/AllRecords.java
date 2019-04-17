package edu.vt.cs4604.troop;

import lombok.*;
// import java.time.LocalDate;
import javax.persistence.*;
// import java.util.*;
// import java.util.stream.Collectors;
// import java.util.stream.Stream;
/*
 * NamedNativeQueries allow us to use _SQL_ queries
 * to perform complex queries against the database.
 * Alternatively NamedQueries use _JPQL_ to accomplish
 * the same thing.
 * https://en.wikipedia.org/wiki/Java_Persistence_Query_Language
 */

@NamedNativeQueries({
    @NamedNativeQuery(
      name = "allRecordsQuery", 
      query = "select a.c_id, a.c_name, a.c_address, b.c_number, c.make_year, c.make, c.model" + 
       "from customer a, phone_number b, car c where a.c_id = b.c_id and a.c_id = c.c_id", 
      resultSetMapping = "AllRecordsResult"
    )
  })

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
// @SqlResultSetMapping(
//     name="AllRecordsResult",
//     classes={
//       @ConstructorResult(
//         targetClass=AllRecords.class,
//         columns={
//           @ColumnResult(name="c_id", type=Long.class),
//           @ColumnResult(name="c_name"),
//           @ColumnResult(name="c_address"),
//           @ColumnResult(name="c_number"),
//           @ColumnResult(name="make_year"),
//           @ColumnResult(name="make"),
//           @ColumnResult(name="model")
//         })
//     })
public class AllRecords {
    @Id
    private Long c_id;
    private String c_name;
    private String c_address;
    private String c_number;
    private String make_year;
    private String make;
    private String model;

    // public AllRecords(Long c_id, String c_name, String c_address, 
    // String c_number, String make_year, String make, String model) {
    //     this.c_id = c_id;
    //     this.c_name = c_name;
    //     this.c_address = c_address;
    //     this.c_number = c_number;
    //     this.make_year = make_year;
    //     this.make = make;
    //     this.model = model;
    // }

}
