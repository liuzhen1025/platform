/**
 * copyRight
 */
package com.gennlife.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2018/5/10
 * Time: 20:02
 * https://blog.csdn.net/liuchuanhong1/article/details/62236793
 */
public class ZuulPreFilter extends ZuulFilter {
    private static Logger LOG = LoggerFactory.getLogger(ZuulPreFilter.class);
    /**
     *   pre：可以在请求被路由之前调用
         route：在路由请求时候被调用
         post：在route和error过滤器之后被调用
         error：处理请求时发生错误时被调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
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
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        return null;
    }
}
