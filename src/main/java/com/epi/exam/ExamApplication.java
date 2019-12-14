package com.epi.exam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.epi.exam.*")
@MapperScan(basePackages = {"com.epi.exam.dao"})
@EnableTransactionManagement
public class ExamApplication {

	public static void main(String[] args) {
		SpringApplication.run( ExamApplication.class, args );
		System.out.println( "启动完成" );
	}

}
