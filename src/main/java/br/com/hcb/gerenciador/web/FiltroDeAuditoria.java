package br.com.hcb.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.hcb.gerenciador.Usuario;

@WebFilter(urlPatterns = "/*")
public class FiltroDeAuditoria implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        // adapta o servlet
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        // pega a uri
        String uri = req.getRequestURI();
        // usando cookie - fica no cliente (navegador)
        // Cookie logado = new Cookies(req.getCookies()).getUsuarioLogado();
        String usuario = "<deslogado>";

        // usando session - fica no servidor (tomcat)
        HttpSession session = req.getSession();
        Usuario logado = (Usuario) session.getAttribute("usuarioLogado");

        if (logado != null) {
            // usuario = logado.getValue();
            // logado.setMaxAge(5);
            // resp.addCookie(logado);
            usuario = logado.getEmail();
        }
        System.out.println("Usuario " + usuario + " acessando a URI " + uri);

        // continua o caminho para o servlet
        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

}
