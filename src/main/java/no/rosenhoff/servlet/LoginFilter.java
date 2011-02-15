package no.rosenhoff.servlet;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class LoginFilter implements Filter {

    private Logger log = Logger.getLogger(getClass());

    private final String SECUREAREA = "/admin/";
    private final String LOGINPAGE = "/admin/login";

    public void init(FilterConfig config) throws ServletException {
        // TODO Auto-generated method stub

    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        Map map = request.getParameterMap();
        String characterEncoding = request.getCharacterEncoding();
        HttpServletResponse response = (HttpServletResponse) res;
        String relPath = request.getServletPath();
        HttpSession session = request.getSession();

        Object lagValgt = session.getAttribute(LoginConstants.LAG_VALGT.name());
        if (lagValgt == null && relPath.indexOf("startpage") == -1) {
            log.debug("redirigerer for aa sette lag");
            response.sendRedirect(request.getContextPath() + "/startpage.jsf");
            return;
        }
        Object innlogget = session.getAttribute(LoginConstants.INNLOGGET.name());
        if (relPath.indexOf(SECUREAREA) != -1 && relPath.indexOf(LOGINPAGE) == -1 && innlogget == null) {
            log.debug("redirigerer til login");
            response.sendRedirect("login.jsf");
            return;
        }
        chain.doFilter(req, res);

    }

    public void destroy() {
        // TODO Auto-generated method stub

    }

}
