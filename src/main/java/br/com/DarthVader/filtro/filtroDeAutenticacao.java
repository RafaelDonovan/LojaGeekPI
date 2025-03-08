package br.com.DarthVader.filtro;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/admin/*")
public class filtroDeAutenticacao implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        if (isUserLogged(httpServletRequest)){
            filterChain.doFilter(servletRequest, servletResponse);
        }else{
            servletRequest.setAttribute("mensagem", "Usuario não autenticado");

            servletRequest.getRequestDispatcher("/index.jsp").forward(httpServletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() { }

    private boolean isUserLogged (HttpServletRequest httpServletRequest){
        return httpServletRequest.getSession().getAttribute("loggedUser")!=null;
    }
}
