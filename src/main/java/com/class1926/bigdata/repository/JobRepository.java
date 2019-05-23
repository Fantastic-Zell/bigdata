package com.class1926.bigdata.repository;

import com.class1926.bigdata.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {


    @Query(value = "select address as city,AVG(salary) as avgByCity,SUM(hiring) as countByCity,AVG(experience) as experience,SUM(salary) as budget FROM job group by address", nativeQuery = true)
    List<Object[]> findGroupByCity();

    @Query(value = "select province,AVG(salary) as avgByProvince,SUM(hiring) as countByProvince,AVG(experience) as experience,SUM(salary) as budget FROM job group by province", nativeQuery = true)
    List<Object[]> findGroupByProvince();
}
