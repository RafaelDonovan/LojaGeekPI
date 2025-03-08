package br.com.DarthVader.servlet.Usuario;

import br.com.DarthVader.dao.UsuarioDAO;
import br.com.DarthVader.modal.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet({"/achar-todos-usuarios","/admin/achar-todos-usuarios" })
public class ListarUsuariosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Usuario> usuarios = new UsuarioDAO().ListarUsuarios();

        req.setAttribute("usuarios", usuarios);

        req.getRequestDispatcher("./User/listarUsuarios.jsp").forward(req, resp);
    }
}
