package com.example.kafak.four.to.one.demo.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "result_log")
public class ResultLogEntity implements Serializable {

    @Id
    private int id;

    @Column(nullable = true, name = "user_name")
    private String userName;

    @Column(name = "create_date")
    private Date createdDate;

    @Column(name = "download_cnt")
    private Integer downloadCnt;

    @Column(name = "download_date")
    private Date downloadDate;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "is_succeed")
    private Integer isSucceed;

    @Column(name = "origin_location")
    private String originLocation;

    @Column(name = "result_location")
    private String resultLocation;

    @Column(name = "result_file_name")
    private String resultFileName;

}
