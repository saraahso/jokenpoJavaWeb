package br.edu.ifpr.controller;

import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.DragDropEvent;

import br.edu.ifpr.entity.Jogada;
import br.edu.ifpr.entity.Jogo;
import br.edu.ifpr.entity.Usuario;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
@SessionScoped
public class ControleJogo {

	@Getter
	@Setter
	private Usuario usuario;

	@Getter
	@Setter
	private Usuario conversando;

	@Getter
	@Setter
	private Jogo partidas;

	@Getter
	@Setter
	private List<Jogo> jogos;

	@Getter
	@Setter
	private String vencedor;

	@Getter
	@Setter
	private boolean cadastro;
	
	@Getter
	@Setter
	private boolean mostrarVencedor;
	

	@Getter
	@Setter
	@ManagedProperty(value = "#{dados}")
	private Dados dados;

	@Getter
	@Setter
	private Integer resultado;

	@Getter
	@Setter
	private List<Jogada> jogadas;

	@Getter
	@Setter
	private Jogada jogadaSelecionada;

	public ControleJogo() {
		usuario = new Usuario();
		conversando = new Usuario();
		partidas = new Jogo();
		vencedor = "";
		jogadas = Arrays.asList(Jogada.values());
		cadastro = false;
		mostrarVencedor = false;
	}

	public void mostrarCadastro() {
		cadastro = true;
	}


	public String envia() {
		dados.logar(usuario);
		return "/jogo";
	}

	public void atualizarPartidas() {
		jogos = dados.getPartidas();

		if (this.jogos.size() == 2) {
			int avaliaJogadas = jogos.get(0).getJogada().comparaJogadas(jogos.get(1).getJogada());

			if (avaliaJogadas == 1) {
				vencedor = jogos.get(0).getOrigem().getLogin();
			} else if (avaliaJogadas == -1) {
				vencedor = jogos.get(1).getOrigem().getLogin();
			} else if (avaliaJogadas == 0) {
				vencedor = "não houve vencedor";
				
			}
			mostrarVencedor = true;
			System.out.println(avaliaJogadas);
			System.out.println("vencedor = " + vencedor);
			// limpa a listagem
			jogos.clear();
		}

	}

	public String vencedorJogo() {
		return this.vencedor;
	}

	public void enviarJogada() {
		Jogo jg = new Jogo();
		jg.origem = this.usuario;
		jg.destino = this.conversando;
		jg.jogada = this.jogadaSelecionada;
		dados.mandarJogada(jg);

		atualizarPartidas();
	}

}
