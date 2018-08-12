package br.edu.ifpr.entity;

public class Jogo {

	public Usuario origem;
	public Usuario destino;
	public Jogada jogada;
	public Integer resultado; 
	
	public Usuario getOrigem() {
		return origem;
	}
	public void setOrigem(Usuario origem) {
		this.origem = origem;
	}
	public Usuario getDestino() {
		return destino;
	}
	public void setDestino(Usuario destino) {
		this.destino = destino;
	}
	public Jogada getJogada() {
		return jogada;
	}
	public void setJogada(Jogada jogada) {
		this.jogada = jogada;
	}

	

}
