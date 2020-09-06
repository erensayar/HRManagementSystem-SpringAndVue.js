package com.erensayar.HrApp.Entitys;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author erensayar
 */
@Entity
@Table(name = "job")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "jobTitle", length = 100)
    private String jobTitle;

    @Column(name = "jobDescript", length = 5000)
    private String jobDescript;

    @Column(name = "numberOfHires")
    private Integer numberOfHires;

    @Temporal(TemporalType.DATE)
    @Column(name = "lastApplicationDate")
    private Date lastApplicationDate;

    @JoinColumn(name = "applicant_job_id")
    @ManyToMany(fetch = FetchType.EAGER)
    Set<Applicant> applicant;
}
