package br.senai.sp.jandira.model;

import java.time.LocalDate;

public class Pessoa {
    
        String nome;
        private String email;
        private String telefone;
	private LocalDate dataNascimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }    
    
    public String getDataNascimentoComBarra() {
        
        String[] separado =  dataNascimento.toString().split("-");
        String dataCorreta = separado[2] + "/" + separado[1] + "/" + separado[0];
        return dataCorreta;
    }
}
