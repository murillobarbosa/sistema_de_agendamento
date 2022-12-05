package br.senai.sp.jandira.model;

import java.time.LocalDate;

public class Paciente extends Pessoa {
    // atributos

    private String tipoSanguineo;
    private PlanosDeSaude planoDeSaude;

    // métodos de acesso
    // ***pegar tipo sanguineo do cliente
    public void setTipoSanguineo(String tipoSanguineo) {

        this.tipoSanguineo = tipoSanguineo;

    }

    // ***reotrnar tipo sanguineo do cliente
    public String getTipoSanguineo() {

        return tipoSanguineo;

    }

    // ***Pegar Plano de Saúde do Paciente***
    public void setPlanoDeSaude(PlanosDeSaude planoDeSaude) {

        this.planoDeSaude = planoDeSaude;

    }

    // ***Retornar Plano de Saúde do Paciente***
    public PlanosDeSaude getPlanoDeSaude() {

        return this.planoDeSaude;

    }

}