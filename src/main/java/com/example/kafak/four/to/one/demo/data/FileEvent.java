package com.example.kafak.four.to.one.demo.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileEvent {

    private String resultFileName;
    private FileEventType fileEventType;
    private String resultLocation;
    private String data;
}
