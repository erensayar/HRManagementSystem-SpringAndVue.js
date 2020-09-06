package com.erensayar.HrApp.Service.Implementation;

import com.erensayar.HrApp.Entitys.Applicant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.erensayar.HrApp.Repo.ApplicantRepo;
import com.erensayar.HrApp.Service.IApplicantService;

/**
 * @author erensayar
 */
@Service
public class ApplicantService implements IApplicantService {

    //<=====================================================================>
    private final ApplicantRepo applicantRepo;

    @Autowired // Constructor Injection
    public ApplicantService(ApplicantRepo applicantRepo) {
        this.applicantRepo = applicantRepo;
    }
    //<=====================================================================>

    @Override
    public List<Applicant> getAll() {
        return applicantRepo.findAll();
    }

    @Override
    public Optional<Applicant> getApplicantById(Integer id) {
        return applicantRepo.findById(id);
    }

    @Override
    public void addApplicant(Applicant applicant) {
        applicantRepo.save(applicant);
    }

    @Override
    public boolean deleteById(Integer id) {
        try {
            applicantRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return false;
        }
    }
}
