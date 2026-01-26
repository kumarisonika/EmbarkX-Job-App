package com.embarkxJobApp.myJobApp.job.impl;

import com.embarkxJobApp.myJobApp.job.Job;
import com.embarkxJobApp.myJobApp.job.JobRepository;
import com.embarkxJobApp.myJobApp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);

    }

    @Override
    public Job getJobById(Long id){
        return jobRepository.findById(id).orElseThrow(()-> new RuntimeException("Job not found!"));
    }

    @Override
    public boolean deleteJobById(Long id){
        if(!jobRepository.existsById(id)){return false;}
        jobRepository.deleteById(id);
        return true;
    }
}
