package com.vtxlab.bootcamp.bootcampsbfakedatabase;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest//Simulate the actual process of "mvn spring-boot:run"
//Testing @SpringBootApplication -> @ComponentScan
//To trigger @SpringBootTest,we use "mvn clean test"
class BootcampsbfakedatabaseApplicationTests {

	//In @SpringBootTest env,
	//the spring context will contain all your custom beans
	//i.e. @Controller,@Service,@Configuration,@Bean

	@Test//At least one @Test to start up the test env.
	void contextLoads() {
		
	}

}
