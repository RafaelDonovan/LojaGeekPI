package br.com.DarthVader.servlet.Usuario;

import br.com.DarthVader.config.Criptografia;
import br.com.DarthVader.dao.UsuarioDAO;
import br.com.DarthVader.modal.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/criar-usuario")
public class CriarUsuarioServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Criptografia criptografia = new Criptografia();

        String userEmail=req.getParameter("User-Email");
        String userNome=req.getParameter("User-Nome");
        String userSenha=req.getParameter("User-Senha");
        String userCPF=req.getParameter("User-CPF");
        String userGrupo=req.getParameter("User-Grupo");
        String userEstatus=req.getParameter("User-Estatus");
        String userID=req.getParameter("id");

        String senhaCriptografada = criptografia.Criptografar(userSenha);


        Usuario usuario=new Usuario(userID, userEmail, userNome, userCPF, senhaCriptografada, userGrupo, "Ativo");
        System.out.println(usuario.getID());

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        if (userID.isEmpty()){
            usuarioDAO.criarUsuario(usuario);
        }else{
            usuarioDAO.AlterarUsuario(usuario);
        }

        resp.sendRedirect("/achar-todos-usuarios");
    }
}