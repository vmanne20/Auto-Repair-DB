package edu.vt.cs4604.troop;

import lombok.*;
// import java.time.LocalDate;
import javax.persistence.*;
import java.time.LocalDate;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "repair_info_view")
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class RepairInfoView
{
    private String r_name;
    private String m_name;
    private String make_year;
    private String make;
    private String model;
    private String c_name;
    @Id
    private LocalDate r_date;
}
