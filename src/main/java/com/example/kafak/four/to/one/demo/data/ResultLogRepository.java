package com.example.kafak.four.to.one.demo.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultLogRepository extends CrudRepository<ResultLogEntity, Long> {

    ResultLogEntity findByResultFileName(String resultFileName);
}