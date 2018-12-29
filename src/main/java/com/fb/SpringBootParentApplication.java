package com.fb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author LYZ
 * @create 2018/12/28 11:44
 **/
@SpringBootApplication
@MapperScan("com.fb.*.mapper")
public class SpringBootParentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootParentApplication.class, args);
	}

}

