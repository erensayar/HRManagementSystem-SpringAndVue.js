package com.erensayar.HrApp.Service;

import com.erensayar.HrApp.Entitys.Job;

import java.util.List;
import java.util.Optional;

/**
 * @author erensayar
 */
public interface IJobService {

    List<Job> getAll();

    Optional<Job> getJobById(Integer id);

    void addJob(Job job);

    boolean deleteById(Integer id);
    
}
