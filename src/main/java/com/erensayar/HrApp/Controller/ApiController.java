package com.erensayar.HrApp.Controller;

import com.erensayar.HrApp.Entitys.Applicant;
import com.erensayar.HrApp.Entitys.HrManager;
import com.erensayar.HrApp.Entitys.Job;
import com.erensayar.HrApp.Service.IHrManagerService;
import com.erensayar.HrApp.Service.IJobService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import com.erensayar.HrApp.Service.IApplicantService;

/**
 * @author erensayar
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    //<=====================================================================>
    private final IJobService jobService;
    private final IApplicantService applicantService;
    private final IHrManagerService hrManagerService;

    @Autowired // Constructor Injection
    public ApiController(IJobService jobService, IApplicantService applicantService, IHrManagerService hrManagerService) {
        this.jobService = jobService;
        this.applicantService = applicantService;
        this.hrManagerService = hrManagerService;
    }

    // GET ALL
    //<=====================================================================>
    @GetMapping(value = "/getAllJob")
    public List<Job> getAllJob() {
        return jobService.getAll();
    }

    @GetMapping(value = "/getAllApplicant")
    public List<Applicant> getAllApplicant() {
        return applicantService.getAll();
    }

    @GetMapping(value = "/getAllHrManager")
    public List<HrManager> getAllHrManager() {
        return hrManagerService.getAll();
    }

    // GET BY ID
    //<=====================================================================>
    @GetMapping(value = "/getJob/{id}")
    public Optional<Job> getJobById(@PathVariable("id") Integer id) {
        return jobService.getJobById(id);
    }

    @GetMapping(value = "/getApplicant/{id}")
    public Optional<Applicant> getApplicantById(@PathVariable("id") Integer id) {
        return applicantService.getApplicantById(id);
    }

    @GetMapping(value = "/getHrManager/{id}")
    public Optional<HrManager> getHrManagerById(@PathVariable("id") Integer id) {
        return hrManagerService.getHrManagerById(id);
    }

    // ADD
    //<=====================================================================>
    @PostMapping(value = "/addJob")
    public ResponseEntity<String> addJob(@RequestBody Job job) {
        //System.out.println(job.toString());
        jobService.addJob(job);
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }

    @PostMapping(value = "/addApplicant")
    public ResponseEntity<String> addApplicant(@RequestBody Applicant applicant) {
        //System.out.println(applicant.toString());
        applicantService.addApplicant(applicant);
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }

    @PostMapping(value = "/addHrManager")
    public ResponseEntity<String> addHrManager(@RequestBody HrManager hrManager) {
        //System.out.println(hrManager.toString());
        hrManagerService.addHrManager(hrManager);
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }

    // DELETE
    //<========================================================================>
    @PostMapping(value = "/deleteJob")
    public ResponseEntity<String> deleteJob(@RequestBody Job job) {
        if (jobService.deleteById(job.getId())) {
            return new ResponseEntity<>("OK", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("DB Error. Check relations.", HttpStatus.CREATED);
        }
    }

    @PostMapping(value = "/deleteApplicant")
    public ResponseEntity<String> deleteApplicant(@RequestBody Applicant applicant) {
        if (applicantService.deleteById(applicant.getId())) {
            return new ResponseEntity<>("OK", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("DB Error. Check relations.", HttpStatus.CREATED);
        }
    }

    @PostMapping(value = "/deleteHrManager")
    public ResponseEntity<String> deleteHrManager(@RequestBody HrManager hrManager) {
        hrManagerService.deleteById(hrManager.getId());
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }

    // DENEME EndPoint
    //<========================================================================>
    @PostMapping(value = "/deneme")
    public ResponseEntity<String> deneme(@RequestBody String text) {
        System.out.println(text);
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }
}