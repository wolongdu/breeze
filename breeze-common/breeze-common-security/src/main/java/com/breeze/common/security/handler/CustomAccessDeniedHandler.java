package com.breeze.common.security.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSON;
import com.breeze.common.core.constant.HttpStatus;
import com.breeze.common.core.domain.R;
import com.breeze.common.core.utils.ServletUtils;

/**
 * 自定义访问无权限资源时的异常
 * 
 * @author breeze
 */
@Component
public class CustomAccessDeniedHandler extends OAuth2AccessDeniedHandler
{
    private final Logger logger = LoggerFactory.getLogger(CustomAccessDeniedHandler.class);

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException authException)
    {
        logger.info("权限不足，请联系管理员 {}", request.getRequestURI());

        String msg = authException.getMessage();
        ServletUtils.renderString(response, JSON.toJSONString(R.fail(HttpStatus.FORBIDDEN, msg)));
    }
}
