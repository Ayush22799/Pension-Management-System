package com.cts.authorization;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.authorization.controller.AuthorizationController;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class AuthorizationServiceApplicationTests {


	@Autowired AuthorizationController controller;

	@LocalServerPort
	private int port;
	
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
