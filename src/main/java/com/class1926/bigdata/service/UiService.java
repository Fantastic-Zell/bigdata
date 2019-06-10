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
}
