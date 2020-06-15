package com.example.kafak.four.to.one.demo.service;

import com.example.kafak.four.to.one.demo.data.ResultLogEntity;
import com.example.kafak.four.to.one.demo.data.ResultLogRepository;
import com.example.kafak.four.to.one.demo.model.ResultFileResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ResultLogServiceImpl implements ResultLogService {

    @Autowired
    ResultLogRepository repository;

    @Autowired
    public ResultLogServiceImpl(ResultLogRepository repository) {
        this.repository = repository;
    }


    @Override
    public ResultFileResponseModel getFileByResultFileName(String resultFileName) {
        ResultLogEntity resultLogEntity = repository.findByResultFileName(resultFileName);

        ResultFileResponseModel responseModel = new ResultFileResponseModel();

        if (resultLogEntity == null) {
            return responseModel;
        }

        responseModel = new ModelMapper().map(resultLogEntity, ResultFileResponseModel.class);
        log.info(String.valueOf(responseModel));
        return responseModel;
    }
}



