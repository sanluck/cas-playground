/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 *
 * @author Merzlikin V.S.
 */
public class WicketAjaxCasFilter implements Filter {

    private String wicketAjaxHeader;
    private String ajaxResponse = "<ajax-response><redirect><![CDATA[./]]></redirect></ajax-response>";

    class NoRedirectResponseWrapper extends HttpServletResponseWrapper {

        public NoRedirectResponseWrapper(HttpServletResponse response) {
            super(response);
        }

        @Override
        public void sendRedirect(String location) throws IOException {
            super.getWriter().print(ajaxResponse);
            super.setContentLength(ajaxResponse.length());
            super.setContentType("text/xml");
            super.setCharacterEncoding("UTF-8");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        wicketAjaxHeader = filterConfig.getInitParameter("wicketAjaxHeader") != null ? filterConfig.getInitParameter("wicketAjaxHeader") : "Wicket-Ajax";
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String wicketHeader = httpRequest.getHeader(wicketAjaxHeader);
        if ("true".equals(wicketHeader)) {
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            chain.doFilter(httpRequest, new NoRedirectResponseWrapper(httpServletResponse));
        } else {
            chain.doFilter(httpRequest, response);
        }
    }

    @Override
    public void destroy() {
    }
}
