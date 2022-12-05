package br.senai.sp.jandira.model;

public class PlanosDeSaude {
	//atributos
	private static Integer contador = 100;
	private Integer codigo;
	private String operadora;
	private String tipoDoPlano;
	
	//construtor da classe
	public PlanosDeSaude(String operadora) {
		this.operadora = operadora;
		this.codigo = contador;
		contador++;
	}
	
	public PlanosDeSaude(String operadora, String tipoDoPlano) {
		this.operadora = operadora;
		this.tipoDoPlano = tipoDoPlano;
		this.codigo = contador;
		contador++;
	}
        
        // construtor da classe
        public PlanosDeSaude(Integer codigo, String operadora, String tipoDoPlano){
            this.codigo = codigo;
            this.operadora = operadora;
            this.tipoDoPlano = tipoDoPlano;
            this.contador = this.codigo;
        }
        
	public PlanosDeSaude() {
            contador++;	
            this.codigo = contador;
		
	}
	
	//Métodos de acesso
	//  ***Pegar Operadora***
							//parametro
	public void setOperadora(String operadora) {
		
		this.operadora = operadora;
		
	}
	// ***Retornar Operadora***
	public String getOperadora() {
		
		return this.operadora;
		
	}
	// ***Pegar Tipo do Plano***
								//parametro
	public void setTipoDoPlano(String tipoDoPlano) {
		
		this.tipoDoPlano = tipoDoPlano;
		
	}
	// ***Retornar Tipo do Plano***
	public String getTipoDoPlano() {
		
		return this.tipoDoPlano;
		
	}
	// ***Retorna Dados do Plano***
	public String getDadosDoPlano () {
		
		return this.operadora + ", " + this.tipoDoPlano + ".";
		
	}

        public Integer getCodigo() {
            return codigo;
        }
	
        public String getPlanoDeSaudeComPontoVirgula(){
        return this.getCodigo() + ";" + this.getOperadora()+ ";" + this.getTipoDoPlano();
    }

}
