package com.class1926.bigdata.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CityResult {

    //城市
    private Object[] city;
    //平均工资
    private Object[] avgByCity;
    //人数需求(总和)
    private Object[] countByCity;
    //工作经验(平均值)
    private Object[] experience;
    //总投入
    private Object[] budget;

}

