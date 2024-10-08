package com.chbb.theaketing.core.config.security;

import java.io.IOException;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AccessHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
            AccessDeniedException accessDeniedException) throws IOException, ServletException {

        String url = request.getRequestURI().toString();
        System.err.println(url);
        if (url.contains("api/")) {
            response.sendError(403, "권한이 없습니다");
            return;
        } else {
            response.sendRedirect("/login");
        }
    }

}
