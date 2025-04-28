package com.urfu.project.controller;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class JsonController {
    @PostMapping("/process-json")
    public ResponseEntity<ProcessedData> processJson(@RequestBody InputData input) {
        ProcessedData response = new ProcessedData();
        response.setPrice(input.getPrice());

        ProcessedInfo info = new ProcessedInfo();
        info.setId(123);
        info.setDate(input.getInfo().getDate());

        response.setInfo(info);
        return ResponseEntity.ok(response);
    }

    @Data
    private static class InputData {
        private double price;
        private Info info;

        @Data
        private static class Info {
            private String date;
        }
    }

    @Data
    private static class ProcessedData {
        private double price;
        private ProcessedInfo info;
    }

    @Data
    private static class ProcessedInfo {
        private int id;
        private String date;
    }
}
