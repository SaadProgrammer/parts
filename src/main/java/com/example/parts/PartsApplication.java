package com.example.parts;

import com.example.parts.dto.PartDto;
import com.example.parts.dto.PartDtoMapperPart;
import com.example.parts.model.Part;
import com.example.parts.service.PartsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PartsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PartsApplication.class, args);
    }

}
