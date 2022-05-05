package com.mohsin.zuul.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class PreFilter extends ZuulFilter {

    private static final int FILTER_ORDER = 1;
    private static final boolean SHOULD_FILTER = true;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return PreFilter.FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return PreFilter.SHOULD_FILTER;
    }

    @Override
    public Object run() throws ZuulException {
        log.info("PreFilter has been invoked successfully!");
        return null;
    }
}
