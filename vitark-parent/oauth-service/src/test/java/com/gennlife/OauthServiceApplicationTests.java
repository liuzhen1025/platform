package com.gennlife;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OauthServiceApplicationTests {
    private static Logger logger = LoggerFactory.getLogger(OauthServiceApplicationTests.class);
	@Test
	public void contextLoads() {
        logger.info("start test application");
	}

}
