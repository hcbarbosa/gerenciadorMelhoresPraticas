package br.com.hcb.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.hcb.gerenciador.Empresa;
import br.com.hcb.gerenciador.dao.EmpresaDAO;

public class NovaEmpresa implements Tarefa {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        Empresa empresa = new Empresa(req.getParameter("nome"));
        new EmpresaDAO().adiciona(empresa);
        req.setAttribute("empresa", empresa);
        return "/WEB-INF/paginas/novaEmpresa.jsp";
    }
}