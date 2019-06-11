package com.class1926.bigdata.controller;

import com.class1926.bigdata.entity.CityResult;
import com.class1926.bigdata.entity.MapResult;
import com.class1926.bigdata.entity.ProvinceResult;
import com.class1926.bigdata.service.JavaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("java")
public class JavaController {

    @Autowired
    private JavaService jobService;

    @RequestMapping("city")
    public CityResult getInfoByCity() {
        Object[][] citys = jobService.getCity();

        CityResult cityResult = CityResult.builder().city(citys[0])
                .avgByCity(citys[1])
                .countByCity(citys[2])
                .experience(citys[3])
                .budget(citys[4]).build();
        return cityResult;

    }

    @RequestMapping("province")
    public ProvinceResult getInfoByProvince() {
        Object[][] provinces = jobService.getProvinc();

        ProvinceResult provinceResult = ProvinceResult.builder().province(provinces[0])
                .avgByProvince(provinces[1])
                .countByProvince(provinces[2])
                .experience(provinces[3])
                .budget(provinces[4]).build();
        return provinceResult;

    }

    @RequestMapping("cityMap")
    public List<MapResult> getMapByCity() {

        List mapResult = jobService.getMapByCity();

        return mapResult;
    }

    @RequestMapping("provinceMap")
    public List<MapResult> getMapByProvince() {

        List mapResult = jobService.getMapByProvince();

        return mapResult;
    }

    @RequestMapping("education")
    public List<Object> getCountByEducation(){

        List<Object> all = jobService.getCountByEducation();
        return all;
    }


}
