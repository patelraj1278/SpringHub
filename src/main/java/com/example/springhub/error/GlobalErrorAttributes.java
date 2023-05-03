/*
package com.example.springhub.error;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@Component
public class GlobalErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String,Object> errorMap = new HashMap<>();
        Throwable error = getError(webRequest);
        errorMap.put("Localized Message:",error.getLocalizedMessage());
        errorMap.put("Endpoint URL :",webRequest.getDescription(true));
        return errorMap;
    }
}
*/
