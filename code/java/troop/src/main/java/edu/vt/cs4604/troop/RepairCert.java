package edu.vt.cs4604.troop;

import lombok.*;

// import java.io.Serializable;

// import java.time.LocalDate;
import javax.persistence.*;

/*
 * NamedNativeQueries allow us to use _SQL_ queries
 * to perform complex queries against the database.
 * Alternatively NamedQueries use _JPQL_ to accomplish
 * the same thing.
 * https://en.wikipedia.org/wiki/Java_Persistence_Query_Language
 */

@Entity
// @Table(name = "repair_certification")
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@IdClass(RepairCertId.class)
public class RepairCert
{
    @Id
    private Long r_id;

    @Id
    private Long cert_id;

    public Long getCertId() {
        return cert_id;
    }
}

class RepairCertId {
    Long r_id;
    Long cert_id;
}
