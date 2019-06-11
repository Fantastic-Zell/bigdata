package com.class1926.bigdata.service;

import com.class1926.bigdata.entity.MapResult;
import com.class1926.bigdata.repository.JavaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Service
public class JavaService {

    @Autowired
    private JavaRepository jobRepository;

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

    public List<MapResult> getMapByCity() {

        List<MapResult> mapResult = new ArrayList<>();
        List<Object[]> groupByCity = jobRepository.findGroupByCity();
        for (int i = 0; i < groupByCity.size(); i++) {
            mapResult.add(MapResult.builder().name(groupByCity.get(i)[0]).value(groupByCity.get(i)[2]).build());
        }
        return mapResult;
    }

    public List<MapResult> getAvgSalaryByCity() {

        List<MapResult> mapResult = new ArrayList<>();
        List<Object[]> groupByCity = jobRepository.findGroupByCity();
        for (int i = 0; i < groupByCity.size(); i++) {
            mapResult.add(MapResult.builder().name(groupByCity.get(i)[0]).value(groupByCity.get(i)[1]).build());
        }
        return mapResult;
    }

    public List<MapResult> getAvgExperienceByCity() {

        List<MapResult> mapResult = new ArrayList<>();
        List<Object[]> groupByCity = jobRepository.findGroupByCity();
        for (int i = 0; i < groupByCity.size(); i++) {
            mapResult.add(MapResult.builder().name(groupByCity.get(i)[0]).value(groupByCity.get(i)[3]).build());
        }
        return mapResult;
    }

    public List<MapResult> getMapByProvince() {

        List<MapResult> mapResult = new ArrayList<>();
        List<Object[]> groupByCity = jobRepository.findGroupByProvince();
        for (int i = 0; i < groupByCity.size(); i++) {
            mapResult.add(MapResult.builder().name(groupByCity.get(i)[0]).value(groupByCity.get(i)[2]).build());
        }
        return mapResult;
    }
    public List<MapResult> getAvgSalaryByProvince() {

        List<MapResult> mapResult = new ArrayList<>();
        List<Object[]> groupByCity = jobRepository.findGroupByProvince();
        for (int i = 0; i < groupByCity.size(); i++) {
            mapResult.add(MapResult.builder().name(groupByCity.get(i)[0]).value(groupByCity.get(i)[1]).build());
        }
        return mapResult;
    }

    public List<MapResult> getAvgExperienceByProvince() {

        List<MapResult> mapResult = new ArrayList<>();
        List<Object[]> groupByCity = jobRepository.findGroupByProvince();
        for (int i = 0; i < groupByCity.size(); i++) {
            mapResult.add(MapResult.builder().name(groupByCity.get(i)[0]).value(groupByCity.get(i)[3]).build());
        }
        return mapResult;
    }

    public List<Object> getCountByEducation(){
        ArrayList<Object> all = new ArrayList<>();
        List<Object[]> count = jobRepository.findCountGroupByEducation();

        double item = 0;
        for (int i = 0; i < count.size(); i++) {
            item = item + Double.valueOf(count.get(i)[1].toString());
        }
        for (int i = 1; i < count.size(); i++) {
            ArrayList<Object> data = new ArrayList<>();
            double x = Double.valueOf(count.get(i)[1].toString())/item*100;
            MapResult other = MapResult.builder().name("other").value(100-(x)).build();
            MapResult result = MapResult.builder().name(count.get(i)[0]).value(x).build();
            data.add(other);
            data.add(result);
            all.add(data);
        }
        return all;
    }
}
