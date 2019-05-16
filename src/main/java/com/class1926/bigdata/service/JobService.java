package com.class1926.bigdata.service;

import com.class1926.bigdata.entity.Job;
import com.class1926.bigdata.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class JobService {
    @Autowired
    private JobRepository jobRepository;


    public List<Job> getAll(){

        List<Job> all = jobRepository.findAll();

        return all;

    }


}
