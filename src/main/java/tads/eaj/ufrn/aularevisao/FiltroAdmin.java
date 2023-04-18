package tads.eaj.ufrn.aularevisao;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebFilter("/admin")
public class FiltroAdmin implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession();

        var tipo = (String) session.getAttribute("tipo");

        if (tipo == null){
            ((HttpServletResponse) response).sendRedirect("index.html");
        }else if (tipo.equals("admin")){
            filterChain.doFilter(request, response);
        }else{
            ((HttpServletResponse) response).sendRedirect("index.html");
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
