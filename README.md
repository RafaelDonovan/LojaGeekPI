P.I - 4 semestre 

# Protótipo do Site

  ![Login](Login.png)
  ![Cadastro](Cadastro.png)
  ![Cadastro](Cadastro2.png)
  ![Editar Cliente](EditaCliente.png)
  ![Editar Cliente](EditarCiente2.png)

Script Banco de dados

CREATE CACHED TABLE "PUBLIC"."USUARIO"(

    "ID" INT PRIMARY KEY AUTO_INCREMENT,

    "NOME" CHARACTER VARYING(50),

    "CPF" CHARACTER VARYING(14),

    "EMAIL" CHARACTER VARYING(50),

    "SENHA" CHARACTER VARYING(255),

    "ESTATUS" CHARACTER VARYING(20),

    "GRUPO" CHARACTER VARYING(50),

    "BACKOFFICE" CHARACTER VARYING(50)

);

insert into usuario (nome, cpf, email, senha, estatus, grupo, backoffice) values ('Felipe','522.692.428-31','Felipe@gmail.com','0Ox9XCBVsKJdpA9B3HO7hQ==','Ativo','ADM,'null')
