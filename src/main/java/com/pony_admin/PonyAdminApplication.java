package com.pony_admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.pony_admin.dao")
public class PonyAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(PonyAdminApplication.class, args);
	}
}
