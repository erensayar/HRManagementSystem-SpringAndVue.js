package com.erensayar.HrApp.Service.Implementation;

import com.erensayar.HrApp.Entitys.Job;
import com.erensayar.HrApp.Repo.JobRepo;
import com.erensayar.HrApp.Service.IJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author erensayar
 */
@Service
public class JobService implements IJobService {

    //<=====================================================================>
    private final JobRepo jobRepo;

    @Autowired // Constructor Injection
    public JobService(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }
    //<=====================================================================>

    @Override
    public List<Job> getAll() {
        return jobRepo.findAll();
    }

    @Override
    public Optional<Job> getJobById(Integer id) {
        return jobRepo.findById(id);
    }

    @Override
    public void addJob(Job job) {
        jobRepo.save(job);
    }

    @Override
    public boolean deleteById(Integer id) {
        try {
            jobRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return false;
        }
    }
}
