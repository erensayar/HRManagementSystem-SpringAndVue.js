package com.erensayar.HrApp.Entitys;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author erensayar
 */
@Entity
@Table(name = "applicant")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Applicant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "surname", length = 20)
    private String surname;

    @Column(name = "mail", length = 70)
    private String mail;

    @Column(name = "telephone", length = 13)
    private String telephone;

    @Column(name = "residence", length = 50)
    private String residence;

    @Column(name = "gitLink", length = 100)
    private String gitLink;

    @Column(name = "linkedInLink", length = 100)
    private String linkedInLink;

    @JoinColumn(name = "job_applicant_id")
    @ManyToMany(fetch = FetchType.EAGER)
    Set<Job> job;
    
    //private MultipartFile cv;
}
