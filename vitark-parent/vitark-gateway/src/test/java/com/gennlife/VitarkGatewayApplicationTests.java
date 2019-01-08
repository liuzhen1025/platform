package com.gennlife;

import com.google.common.primitives.Bytes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Base64;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class VitarkGatewayApplicationTests {

	@Test
	public void contextLoads() {
        String encode = Base64.getEncoder().encodeToString("/a/b/c/d+详情页".getBytes());
        String s = new String(Base64.getDecoder().decode(encode));
        System.out.println(s+"=="+encode);
    }

}
