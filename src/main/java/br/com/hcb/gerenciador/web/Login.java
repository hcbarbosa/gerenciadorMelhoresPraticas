package br.com.hcb.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.hcb.gerenciador.Usuario;
import br.com.hcb.gerenciador.dao.UsuarioDAO;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {

    // usamos post pois login muda o status do servidor
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String senha = req.getParameter("senha");
        PrintWriter writer = resp.getWriter();

        Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);

        if (usuario == null) {
            writer.println("<html><body>Usuario ou senha invalida. <a href='http://localhost:8085/gerenciador/'><span>Voltar</span></a></body></html>");
        } else {
            writer.println("<html><body>Usuario logado com o email: " + email);
            writer.println("<a href='http://localhost:8085/gerenciador/'>" + "<span>Voltar</span>"
                    + "</a></body></html>");

            // usando cookie - fica no cliente (navegador)
            // Cookie cookie = new Cookie("usuario.logado", email);
            // cookie.setMaxAge(5);
            // resp.addCookie(cookie);

            // usando session - fica no servidor (tomcat)
            HttpSession session = req.getSession();
            session.setAttribute("usuarioLogado", usuario);
        }

    }
}
