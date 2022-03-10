package com.daeguro;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@WebAppConfiguration
class DaeguroApplicationTests {

	@Test
	void contextLoads() {

	}
	@Test
	public void testAdd() {
		assertEquals(42, Integer.sum(19, 23));
	}

}
