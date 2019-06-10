package com.class1926.bigdata.controller;

import com.class1926.bigdata.service.UiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AllController {

    @Autowired
    private UiService jobService;

    @RequestMapping("all")
    public List getAllJob(){

        List allJob = jobService.getAllJob();

        return allJob;

    }


}
