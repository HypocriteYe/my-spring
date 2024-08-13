package com.example.myspring.config;


import com.alibaba.fastjson.JSON;
import com.example.myspring.annotation.SingleArg;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @description
 * @Author ygl
 * @Create 2024/8/8 15:35
 */
public class SingleArgResolver implements HandlerMethodArgumentResolver {

    private static final String REQUEST_BODY_MAP = "REQUEST_BODY_MAP";

    /**
     * 支持SingleArg注解的参数
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(SingleArg.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Map<String, Object> bodyMap = getRequestBody(webRequest);
        SingleArg annotation = parameter.getParameterAnnotation(SingleArg.class);
        Object o = null;
        if (bodyMap != null) {
            if (StringUtils.isNotEmpty(annotation.value())) {
                o = bodyMap.get(annotation.value());
            } else {
                o = bodyMap.get(parameter.getParameterName());
            }
        }
        if (parameter.getParameterAnnotation(SingleArg.class).required() && o == null) {
            throw new UnsupportedOperationException(
                    "Unknown parameter: " + parameter.getParameterName() + " in method: " + parameter.getMethod());
        }
        return typeTransform(parameter, o);
    }

    private Map<String, Object> getRequestBody(NativeWebRequest request) {
        HttpServletRequest servletRequest = request.getNativeRequest(HttpServletRequest.class);
        Map<String, Object> bodyMap = (Map<String, Object>) servletRequest.getAttribute(REQUEST_BODY_MAP);
        if (bodyMap == null) {
            try {
                String body = IOUtils.toString(servletRequest.getInputStream(), "UTF-8");
                bodyMap = JSON.parseObject(body, Map.class);
                servletRequest.setAttribute(REQUEST_BODY_MAP, bodyMap);
            } catch (Exception e) {
                throw new RuntimeException("解析请求体失败");
            }
        }
        return bodyMap;

    }

    /**
     * 基础类型转换
     */
    private Object typeTransform(MethodParameter parameter, Object o) {
        if (o == null) {
            return null;
        }
        String paramType = parameter.getParameterType().getName();
        if (Double.class.getName().equals(paramType) || double.class.getName().equals(paramType)) {
            return Double.parseDouble(o.toString());
        }
        if (Integer.class.getName().equals(paramType) || int.class.getName().equals(paramType)) {
            return Integer.parseInt(o.toString());
        }
        if (Long.class.getName().equals(paramType) || long.class.getName().equals(paramType)) {
            return Long.parseLong(o.toString());
        }
        if (Boolean.class.getName().equals(paramType) || boolean.class.getName().equals(paramType)) {
            return Boolean.parseBoolean(o.toString());
        }
        if (Float.class.getName().equals(paramType) || float.class.getName().equals(paramType)) {
            return Float.parseFloat(o.toString());
        }
        if (Short.class.getName().equals(paramType) || short.class.getName().equals(paramType)) {
            return Short.parseShort(o.toString());
        }
        if (Byte.class.getName().equals(paramType) || byte.class.getName().equals(paramType)) {
            return Byte.parseByte(o.toString());
        }
        return o;
    }
}
