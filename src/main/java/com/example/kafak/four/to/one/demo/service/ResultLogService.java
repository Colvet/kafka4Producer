package com.example.kafak.four.to.one.demo.service;

import com.example.kafak.four.to.one.demo.model.ResultFileResponseModel;


public interface ResultLogService {

    ResultFileResponseModel getFileByResultFileName(String resultFileName);

}
