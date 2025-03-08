package br.com.DarthVader.servlet.Usuario;

import br.com.DarthVader.dao.UsuarioDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletar-usuario")
public class DeletarUsuariosServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userID=req.getParameter("id");

        new UsuarioDAO().DeletarUserID(userID);

        resp.sendRedirect("/achar-todos-usuarios");
    }
}
