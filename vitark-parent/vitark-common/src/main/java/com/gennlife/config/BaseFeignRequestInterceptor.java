/**
 * copyRight
 */
package com.gennlife.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2018/5/19
 * Time: 10:56
 */
//@Configuration
public class BaseFeignRequestInterceptor {
    @Bean
    public RequestInterceptor requestTokenBearerInterceptor(){
        return new RequestInterceptor() {
            @Override
            public void apply(feign.RequestTemplate requestTemplate) {
                OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)
                        SecurityContextHolder.getContext().getAuthentication().getDetails();

                requestTemplate.header("Authorization", "bearer " + details.getTokenValue());
            }
        };

    }
}
