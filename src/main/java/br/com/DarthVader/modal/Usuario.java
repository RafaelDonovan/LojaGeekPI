package br.com.DarthVader.modal;

public class Usuario {
    private String ID;
    private String email;
    private String Nome;
    private String CPF;
    private String Senha;
    private String Grupo;
    private String estatus;
    private boolean backoffice;

    public Usuario(String ID, String email, String nome, String CPF, String senha, String grupo, String estatus) {
        this.ID = ID;
        this.email = email;
        Nome = nome;
        this.CPF = CPF;
        Senha = senha;
        Grupo = grupo;
        this.estatus=estatus;

    }

    public Usuario(String email, String nome, String CPF, String senha, String grupo) {
        this.email = email;
        Nome = nome;
        this.CPF = CPF;
        Senha = senha;
        Grupo = grupo;
        this.estatus="Ativo";
    }

    public Usuario(String email, String senha) {
        this.email = email;
        Senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return Nome;
    }

    public String getCPF() {
        return CPF;
    }

    public String getSenha() {
        return Senha;
    }

    public String getGrupo() {
        return Grupo;
    }

    public boolean isBackoffice() {
        return backoffice;
    }

    public String getID() {
        return ID;
    }

    public String getEstatus() {
        return estatus;
    }
}
