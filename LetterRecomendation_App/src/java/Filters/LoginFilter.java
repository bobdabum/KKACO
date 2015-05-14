/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Filters;

import Enums.Params;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;

/**
 *
 * @author My Pc
 */
@WebFilter(filterName = "authFilter",
            urlPatterns = {Params.URLPATTERN_USERPROFILE})
public class LoginFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        HttpSession session = req.getSession(false);

        // if session doesn't exist or if timed out, forward user to welcome page
        if (session == null && req.getMethod().equalsIgnoreCase("GET")) {
            try {
                req.getRequestDispatcher("/index.jsp").forward(request, response);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return;
        }
        else
            chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}  //Have a thing so that when you log out, it will point out.  
}
