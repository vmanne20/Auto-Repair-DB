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
    @Column(name = "r_name")
    private String r_name;
    @Column(name = "m_name")
    private String m_name;
    @Column(name = "make_year")
    private String make_year;
    @Column(name = "make")
    private String make;
    @Column(name = "model")
    private String model;
    @Column(name = "c_name")
    private String c_name;
    @Id
    @Column(name = "r_date")
    private LocalDate r_date;
}
