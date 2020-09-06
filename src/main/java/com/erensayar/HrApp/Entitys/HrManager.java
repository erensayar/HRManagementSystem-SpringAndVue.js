package com.erensayar.HrApp.Entitys;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

/**
 * @author erensayar
 */
@Entity
@Table(name = "hr_manager")
@Data
public class HrManager implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String mail;

    private String pass;
}
