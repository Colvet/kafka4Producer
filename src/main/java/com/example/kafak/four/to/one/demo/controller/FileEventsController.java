package com.example.kafak.four.to.one.demo.controller;

import com.example.kafak.four.to.one.demo.data.FileEvent;
import com.example.kafak.four.to.one.demo.data.FileEventType;
import com.example.kafak.four.to.one.demo.model.ResultFileResponseModel;
import com.example.kafak.four.to.one.demo.producer.FileEventProducer;
import com.example.kafak.four.to.one.demo.service.ResultLogService;
import com.opencsv.exceptions.CsvException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@Slf4j
@RequestMapping("/file")
public class FileEventsController {

    @Autowired
    FileEventProducer fileEventProducer;

    @Autowired
    ResultLogService resultLogService;


    @GetMapping("readfile/{fileName}")
    public ResponseEntity<ResultFileResponseModel> getFile(@PathVariable("fileName") String fileName) throws IOException, CsvException {

        ResultFileResponseModel responseModel = resultLogService.getFileByResultFileName(fileName);
        FileEvent fileEvent = new ModelMapper().map(responseModel, FileEvent.class);

        TopicBuilder.name(fileName).partitions(1).replicas(1).build();

        if(fileEvent.getResultFileName() == null){
            log.info("파일 없습니다.");
            fileEvent.setResultFileName(fileName);
            fileEvent.setFileEventType(FileEventType.NOFILE);
            fileEventProducer.sendDataEvent(fileEvent);

            return ResponseEntity.status(HttpStatus.NO_CONTENT).body( null);

        }else{
            fileEvent.setFileEventType(FileEventType.SEND);
            fileEventProducer.sendDataEvent(fileEvent);

            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
    }

    @GetMapping("/status/check")
    public String status() {
        return String.format("Working on port");

    }

    @GetMapping("/send")
    public String test(){

        return "hello";
    }


}
