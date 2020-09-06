package com.erensayar.HrApp.Repo;

import com.erensayar.HrApp.Entitys.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author erensayar
 */
@Repository
public interface ApplicantRepo extends JpaRepository <Applicant, Integer> {
}
