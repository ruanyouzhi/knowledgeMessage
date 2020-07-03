package com.km.knowledgemessage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.km.knowledgemessage.Mapper")
public class KnowledgemessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(KnowledgemessageApplication.class, args);
    }
}

