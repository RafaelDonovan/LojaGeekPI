package br.com.DarthVader.servlet.Produto;

import br.com.DarthVader.dao.ProdutoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/habilitar-desabilitar-produto")
public class HabilitarDesabilitarProdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String prodID=req.getParameter("id");

        new ProdutoDAO().HabilitaDesabilitaProd(prodID);

        resp.sendRedirect("/achar-todos-produtos");
    }
}
