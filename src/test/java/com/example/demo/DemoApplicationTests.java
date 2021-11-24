package com.example.demo;

import com.example.demo.domain.entity.User;
import com.example.demo.utils.JWTUtils;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() throws InterruptedException {

		User user = new User();
		user.setName("myxym");
		user.setHeadImg("png");
		user.setId(55);

		String token = JWTUtils.geneJsonWebToken(user);
		Claims claims = JWTUtils.checkJWT(token);
		System.out.println(claims.get("name"));
	}

}
