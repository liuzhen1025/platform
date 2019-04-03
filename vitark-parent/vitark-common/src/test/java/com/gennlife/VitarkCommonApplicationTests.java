package com.gennlife;

import com.gennlife.config.BaseFeignRequestInterceptor;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/*@RunWith(SpringRunner.class)
@SpringBootTest*/
public class VitarkCommonApplicationTests {

	@Test
	public void contextLoads() throws Exception{
        CloseableHttpClient httpclient = HttpClients.createDefault();
        long l = 0;
        CloseableHttpResponse response = null;
        try {
            HttpGet httpGet = new HttpGet("https://10.0.0.0:9099/qq_40543961/article/details/79107112");
            RequestConfig requestConfig = RequestConfig.custom()    .setConnectTimeout(5000).setConnectionRequestTimeout(1000).setSocketTimeout(5000).build();
            httpGet.setConfig(requestConfig);
            l = System.currentTimeMillis();
            response = httpclient.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("得到的结果:" + response.getStatusLine());//得到请求结果
        HttpEntity entity = response.getEntity();//得到请求回来的数据
	}

}
