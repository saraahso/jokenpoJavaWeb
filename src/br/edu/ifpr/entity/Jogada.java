package br.edu.ifpr.entity;

public enum Jogada {
	
	PEDRA("Pedra"),
	PAPEL("Papel"),
	TESOURA("Tesoura");
	
	Jogada(String label) {
		this.label = label;
	}
	
	private String label;

	public String getLabel() {
		return label;
	}
	
	/**
     * Comparacao das jogadas para determinar quem ganhou ou se houve um empate.
     *      
     * @param outraJogada             
     * @return 
     * 1 se a escolha atual ganhar da outra, e -1 se ela perder. 
     * O 0 será retornado em caso de empate.         
     */
    public int comparaJogadas(Jogada outraJogada) {
        int resultado = 0;
    	// em caso de jogadas diferentes avalia quem ganhou, em caso de empate retorna 0;
        if (this != outraJogada) {        		        
	        // avaliação de quem ganhou
	        switch (this) {
	        case PEDRA:
	            resultado = (outraJogada == TESOURA ? 1 : -1);
	        case PAPEL:
	        	resultado = (outraJogada == PEDRA ? 1 : -1);
	        case TESOURA:
	        	resultado = (outraJogada == PAPEL ? 1 : -1);
	        }
        } 
        return resultado;
    }

}
