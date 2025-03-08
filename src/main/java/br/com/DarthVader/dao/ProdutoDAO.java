package br.com.DarthVader.dao;

import br.com.DarthVader.config.ConnectionPoolConfig;
import br.com.DarthVader.modal.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProdutoDAO {

    public void cadastroProduto(Produto produto) {

        String SQL = "insert into produto(nome, avaliacao, descricao, preco, Estoque, imagem, ESTATUS) values(?,?,?,?,?,?,?)";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setInt(2, produto.getAvaliacao());
            preparedStatement.setString(3, produto.getDescricao());
            preparedStatement.setDouble(4, produto.getPreco());
            preparedStatement.setInt(5, produto.getQtdEstoque());
            preparedStatement.setString(6, produto.getImagem());
            preparedStatement.setString(7, produto.getEstatus());

            preparedStatement.execute();

            System.out.println("sucesso em inserir no banco de dados");
            connection.close();
        } catch (Exception e) {
            System.out.println("Erro na criação");
        }
    }

    public void alterarProduto(Produto produto) {
        String SQL = "UPDATE produto SET nome = ?, avaliacao = ?, descricao = ?, preco = ?, estoque = ?, imagem = ? WHERE id = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setInt(2, produto.getAvaliacao());
            preparedStatement.setString(3, produto.getDescricao());
            preparedStatement.setDouble(4, produto.getPreco());
            preparedStatement.setInt(5, produto.getQtdEstoque());
            preparedStatement.setString(6, produto.getImagem());
            preparedStatement.setString(7, produto.getId());

            preparedStatement.execute();

            System.out.println("sucesso em alterar no banco de dados");
            connection.close();
        } catch (Exception e) {
            System.out.println("Erro na alteração");
        }

    }

    public List<Produto> ListarProdutos() {

        String SQL = "select * from produto order by estatus asc, id desc";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Produto> produtos = new ArrayList<>();

            while (resultSet.next()) {
                String prodID = resultSet.getString("id");
                String prodNome = resultSet.getString("nome");
                String avaliacao = resultSet.getString("avaliacao");
                    int prodAvaliacao= Integer.parseInt(avaliacao);
                String prodDescricao = resultSet.getString("descricao");
                String preco = resultSet.getString("preco");
                    double prodPreco = Double.parseDouble(preco);
                String estoque = resultSet.getString("estoque");
                    int prodEstoque = Integer.parseInt(estoque);
                String prodImagem = resultSet.getString("imagem");
                String prodStatus = resultSet.getString("ESTATUS");

                Produto produto = new Produto(prodID, prodNome, prodAvaliacao, prodDescricao, prodPreco, prodEstoque, prodImagem ,prodStatus);
                produtos.add(produto);
            }

            System.out.println("Sucesso na seleção");

            connection.close();

            return produtos;

        } catch (Exception e) {
            System.out.println("Erro na conexão");
            return Collections.emptyList();
        }
    }

    public void HabilitaDesabilitaProd(String prodid){
        String SQL ="select * from produto where id = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, prodid);

            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("sucesso em selecionar produto");

            while (resultSet.next()){
                String Habilitado = resultSet.getString("ESTATUS");
                String SQL2;

                if (Habilitado.equalsIgnoreCase("Ativo")){
                    SQL2="update produto set ESTATUS = 'Inativo' where id =?";
                    PreparedStatement preparedStatement2 = connection.prepareStatement(SQL2);

                    preparedStatement2.setString(1, prodid);
                    preparedStatement2.execute();
                }else {
                    SQL2="update produto set ESTATUS = 'Ativo' where id =?";
                    PreparedStatement preparedStatement2 = connection.prepareStatement(SQL2);

                    preparedStatement2.setString(1, prodid);
                    preparedStatement2.execute();
                }
                System.out.println("Estatus de produto alterado com sucesso");
            }

            connection.close();
        }catch (Exception e){

            System.out.println("Erro ao alterar estatus de produto");

        }
    }


}