package com.class1926.bigdata.service;

import com.class1926.bigdata.entity.MapResult;
import com.class1926.bigdata.repository.UiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Service
public class UiService {

    @Autowired
    private UiRepository jobRepository;

    public Object[][] getCity() {

        List<Object[]> groupByCity = jobRepository.findGroupByCity();
        Object[][] citys = new Object[5][groupByCity.size()];
        for (int i = 0; i < groupByCity.size(); i++) {
            citys[0][i] = groupByCity.get(i)[0];
            citys[1][i] = groupByCity.get(i)[1];
            citys[2][i] = groupByCity.get(i)[2];
            citys[3][i] = groupByCity.get(i)[3];
            citys[4][i] = groupByCity.get(i)[4];
        }
        return citys;

    }


    public Object[][] getProvinc() {

        List<Object[]> groupByProvince = jobRepository.findGroupByProvince();
        Object[][] provinces = new Object[5][groupByProvince.size()];
        for (int i = 0; i < groupByProvince.size(); i++) {
            provinces[0][i] = groupByProvince.get(i)[0];
            provinces[1][i] = groupByProvince.get(i)[1];
            provinces[2][i] = groupByProvince.get(i)[2];
            provinces[3][i] = groupByProvince.get(i)[3];
            provinces[4][i] = groupByProvince.get(i)[4];
        }
        return provinces;
    }

    public List<MapResult> getMapInfo() {

        List<MapResult> mapResult = new ArrayList<>();
        List<Object[]> groupByCity = jobRepository.findGroupByCity();
        for (int i = 0; i < groupByCity.size(); i++) {
            mapResult.add(MapResult.builder().name(groupByCity.get(i)[0]).value(groupByCity.get(i)[2]).build());
        }
        return mapResult;
    }

    public List getAllJob(){

        List<List> allJob = new ArrayList<>();
        List<Object> city = new ArrayList<>();
        List<Object> uisalary = new ArrayList<>();
        List<Object> javasalary = new ArrayList<>();
        List<Object> bigdatasalary = new ArrayList<>();
        List<Object> cloudsalary = new ArrayList<>();
        city.add("city");
        uisalary.add("UI");
        javasalary.add("JAVA");
        bigdatasalary.add("大数据");
        cloudsalary.add("云计算");
        List<Object[]> avgs = jobRepository.findAvg();
        for (int i = 0; i <avgs.size(); i++){
            if ("北京".equals(avgs.get(i)[0]) || "上海".equals(avgs.get(i)[0]) || "广州".equals(avgs.get(i)[0]) || "深圳".equals(avgs.get(i)[0]) || "杭州".equals(avgs.get(i)[0]) || "南京".equals(avgs.get(i)[0]) || "成都".equals(avgs.get(i)[0]) || "苏州".equals(avgs.get(i)[0]) || "武汉".equals(avgs.get(i)[0]) || "合肥".equals(avgs.get(i)[0])){
                city.add(avgs.get(i)[0]);
                uisalary.add(avgs.get(i)[1]);
                javasalary.add(avgs.get(i)[2]);
                bigdatasalary.add(avgs.get(i)[3]);
                cloudsalary.add(avgs.get(i)[4]);
            }
        }
        allJob.add(city);
        allJob.add(uisalary);
        allJob.add(javasalary);
        allJob.add(bigdatasalary);
        allJob.add(cloudsalary);

        return allJob;

    }
}
