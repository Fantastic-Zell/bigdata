package com.class1926.bigdata.controller;

import com.class1926.bigdata.entity.CityResult;
import com.class1926.bigdata.entity.ProvinceResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {

    @RequestMapping("city")
    public CityResult getInfoByCity(){

        //todo

        return null;

    }

    @RequestMapping("province")
    public ProvinceResult getInfoByProvince(){

        //todo

        return null;
    }


}
