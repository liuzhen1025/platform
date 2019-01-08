/**
 * copyRight
 */
package com.gennlife.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2018/5/23
 * Time: 10:53
 */
public class ZuulPostFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String responseBody = ctx.getResponseBody();
        return null;
    }
}
