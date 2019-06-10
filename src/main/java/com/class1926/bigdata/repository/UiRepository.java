package com.class1926.bigdata.repository;

import com.class1926.bigdata.entity.Ui;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UiRepository extends JpaRepository<Ui, Long> {


    /**
     * 根据城市分组查询各个城市的评价薪资、岗位需求人数、评价工作经验、城市对该岗位总投入
     *
     * @return
     */
    @Query(value = "select address as city,AVG(salary) as avgByCity,SUM(hiring) as countByCity,AVG(experience) as experience,SUM(salary) as budget FROM job_ui group by address", nativeQuery = true)
    List<Object[]> findGroupByCity();

    /**
     * 根据省份分组查询各个省份的评价薪资、岗位需求人数、评价工作经验、城市对该岗位总投入
     *
     * @return
     */
    @Query(value = "select province,AVG(salary) as avgByProvince,SUM(hiring) as countByProvince,AVG(experience) as experience,SUM(salary) as budget FROM job_ui group by province", nativeQuery = true)
    List<Object[]> findGroupByProvince();
}
