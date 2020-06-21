package com.km.knowledgemessage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@SpringBootApplication
@MapperScan("com.km.knowledgemessage.mapper")
public class KnowledgemessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(KnowledgemessageApplication.class, args);
    }
}

