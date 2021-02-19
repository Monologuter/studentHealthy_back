package com.cqjtu.studentdocument;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;
@MapperScan(basePackages = "com.cqjtu.studentdocument.dao")
@SpringBootApplication
public class StudentdocumentApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentdocumentApplication.class, args);
    }

}
