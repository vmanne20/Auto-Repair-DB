package edu.vt.cs4604.troop;

import lombok.*;
// import java.time.LocalDate;
import javax.persistence.*;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "repair_info_view")
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class RepairInfoView
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cert_id;

    private String cert_name;

    public Long getCertId() {
        return cert_id;
    }

    public String getCertName() {
        return cert_name;
    }
//   @Column(name = "r_id")
//   private Long r_id;

//   @Column (name = "m_id")
//   private Long m_id;
}
