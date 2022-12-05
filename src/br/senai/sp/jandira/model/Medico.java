package br.senai.sp.jandira.model;


import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import br.senai.sp.jandira.model.Especialidade;
import br.senai.sp.jandira.dao.MedicoDAO;
import javax.swing.DefaultListModel;

public class Medico extends Pessoa {
    // atributos
    //codigo crm nome
    private static Integer contador = 100;
    private Integer codigo;

    
    private ArrayList<Especialidade> especialidades;
    private String crm;
    
    public Medico(){
        contador++;
        this.codigo = contador;
    }
    
    public Medico(String crm, String nome, String telefone, String email, LocalDate dataNascimento, ArrayList<Especialidade> especialidades){
        this.crm = crm;
        setNome(nome);
        setTelefone(telefone);
        setEmail(email);
        setDataNascimento(dataNascimento);
        this.especialidades = especialidades;
         
        contador++;
        this.codigo = contador;
        
    }
    
    public Medico(Integer codigo,String crm, String nome, String telefone, String email, LocalDate dataDeNascimento, ArrayList<Especialidade> especialidades){
        this.crm = crm;
        setNome(nome);
        setTelefone(telefone);
        setEmail(email);
        setDataNascimento(dataDeNascimento);
        this.especialidades = especialidades;
        
        this.codigo = codigo;
        this.contador = codigo++;
    }
    // métodos de acesso
    // especialidades
    public void setEspecialidades(ArrayList<Especialidade> especialidades) {
        this.especialidades = especialidades;
    }
    
    public ArrayList<Especialidade> getEspecialidades() {
        return especialidades;
    }
    
    // CRM
    public void setCrm(String crm) {
        this.crm = crm;
    }
    
    public String getCrm() {
        return crm;
    }
    
    public Integer getCodigo() {
        return codigo;
    }
    
   
    public String getMedicoComPontoVirgula() {
        String codigoEspecialidades = "";
        for(Especialidade e : especialidades){    
        codigoEspecialidades += e.getCodigo() + ";";
        }

        return this.codigo + ";" + this.crm + ";" + getNome()  + ";" + getTelefone()  + ";" + getEmail()  + ";" + getDataNascimentoComBarra() + ";" + codigoEspecialidades;

    }

    public ArrayList<String> getListaDeEspecialidadesDoMedico() {
        ArrayList<String> dadosGerais = new ArrayList<>();
        for (Especialidade e : especialidades) {
            dadosGerais.add(e.getNome());
        }
        DefaultListModel<String> ListaModel = new DefaultListModel<>();
        
        ListaModel.addAll(dadosGerais);
        
        return dadosGerais;


    
    }
}