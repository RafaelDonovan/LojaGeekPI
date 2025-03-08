package br.com.DarthVader.dao;

import br.com.DarthVader.config.ConnectionPoolConfig;
import br.com.DarthVader.config.Criptografia;
import br.com.DarthVader.modal.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UsuarioDAO {
    public void criarUsuario(Usuario user){
        String SQL="insert into usuario (Nome, cpf, email, senha, grupo, estatus) values (?,?,?,?,?,?)";
        try{
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, user.getNome());
            preparedStatement.setString(2, user.getCPF());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getSenha());
            preparedStatement.setString(5, user.getGrupo());
            preparedStatement.setString(6, user.getEstatus());

            preparedStatement.execute();

            System.out.println("sucesso em inserir no banco de dados");
            connection.close();

        }catch (Exception e){
            System.out.println("Erro na conexão");
        }
    }

    public List<Usuario> ListarUsuarios(){

        String SQL="Select * from usuario";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Usuario> usuarios= new ArrayList<>();

            while (resultSet.next()){
                String UserID= resultSet.getString("id");
                String UserEmail= resultSet.getString("email");
                String UserNome= resultSet.getString("nome");
                String UserCPF= resultSet.getString("cpf");
                String UserSenha= resultSet.getString("senha");
                String UserGrupo= resultSet.getString("grupo");
                String UserStatus= resultSet.getString("ESTATUS");
                //String UserBackoffice= resultSet.getString("backoffice");

                Usuario usuario = new Usuario(UserID,UserEmail, UserNome, UserCPF, UserSenha, UserGrupo, UserStatus);
                usuarios.add(usuario);
            }

            System.out.println("Sucesso na seleção");

            connection.close();

            return usuarios;

        }catch (Exception e){
            System.out.println("Erro na conexão");
            return Collections.emptyList();
        }
    }

    public void DeletarUserID(String userID){

        String SQL= "Delete usuario where id = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, userID);

            preparedStatement.execute();

            System.out.println("sucesso em apagar o usuario com ID=" + userID);
            connection.close();

        }catch (Exception e){
            System.out.println("Erro na conexão");
        }

    }

    public void AlterarUsuario(Usuario user){
        String SQL="update usuario set Nome = ?, cpf = ?, senha = ?, grupo = ? where id = ?";
        try{
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, user.getNome());
            preparedStatement.setString(2, user.getCPF());
            preparedStatement.setString(3, user.getSenha());
            preparedStatement.setString(4, user.getGrupo());
            preparedStatement.setString(5, user.getID());

            preparedStatement.execute();

            System.out.println("sucesso em alterar o usuario de id: "+user.getID()+" no banco de dados");
            connection.close();

        }catch (Exception e){
            System.out.println("Erro na alteração de usuario");
        }
    }

    public boolean VerificarLogin(Usuario user){
        Criptografia criptografia = new Criptografia();
        String SQL ="select * from usuario where email = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, user.getEmail());

            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("sucesso em selecionar email");

            while (resultSet.next()){
                String senha = criptografia.DesCriptografar(resultSet.getString("SENHA"));

                if (senha.equals(user.getSenha())){

                    return true;
                }
            }

            connection.close();
            return false;
        }catch (Exception e){

            System.out.println("ERRO: "+e.getMessage());

            return false;
        }

    }

    public boolean VerificarHabilitado(Usuario user){
        String SQL ="select * from usuario where email = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, user.getEmail());

            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("sucesso em selecionar email");

            while (resultSet.next()){
                String habilitado =resultSet.getString("ESTATUS");

                if (habilitado.equals("Ativo")){

                    return true;
                }
            }

            connection.close();
            return false;
        }catch (Exception e){

            System.out.println("ERRO: "+e.getMessage());

            return false;
        }

    }

    public boolean VerificarGrupo(Usuario user){
        String SQL ="select * from usuario where email = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, user.getEmail());

            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("sucesso em selecionar email");

            while (resultSet.next()){
                String grupo =resultSet.getString("Grupo");

                if (grupo.equals("ADM")){

                    return true;
                }
            }

            connection.close();
            return false;
        }catch (Exception e){

            System.out.println("ERRO: "+e.getMessage());

            return false;
        }

    }

    public void HabilitaDesabilitaUser(String userid){
        String SQL ="select * from usuario where id = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, userid);

            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("sucesso em selecionar usuario");

            while (resultSet.next()){
                String Habilitado = resultSet.getString("ESTATUS");
                String SQL2;

                if (Habilitado.equalsIgnoreCase("Ativo")){
                    SQL2="update usuario set ESTATUS = 'Inativo' where id =?";
                    PreparedStatement preparedStatement2 = connection.prepareStatement(SQL2);

                    preparedStatement2.setString(1, userid);
                    preparedStatement2.execute();
                }else {
                    SQL2="update usuario set ESTATUS = 'Ativo' where id =?";
                    PreparedStatement preparedStatement2 = connection.prepareStatement(SQL2);

                    preparedStatement2.setString(1, userid);
                    preparedStatement2.execute();
                }
                System.out.println("Estatus de usuario alterado com sucesso");
            }

            connection.close();
        }catch (Exception e){

            System.out.println("Erro ao alterar estatus de usuario");

        }
    }
}
