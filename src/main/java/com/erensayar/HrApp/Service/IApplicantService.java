package com.erensayar.HrApp.Service;

import com.erensayar.HrApp.Entitys.Applicant;

import java.util.List;
import java.util.Optional;

/**
 * @author erensayar
 */
public interface IApplicantService {

    List<Applicant> getAll();

    Optional<Applicant> getApplicantById(Integer id);

    void addApplicant(Applicant applicant);

    boolean deleteById(Integer id);
}
