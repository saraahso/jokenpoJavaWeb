package br.edu.ifpr.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.edu.ifpr.entity.Jogo;
import br.edu.ifpr.entity.Usuario;
import br.edu.ifpr.util.UsuarioDao;

@ManagedBean
@ApplicationScoped
public class Dados {

	private List<Usuario> usuarios;
	private List<Jogo> partidas;
	private UsuarioDao usuarioDao;

	public Dados() {
		usuarios = new ArrayList<Usuario>();
		partidas = new ArrayList<Jogo>();
		usuarioDao = new UsuarioDao();
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Jogo> getPartidas() {
		return partidas;
	}

	public void setPartidas(List<Jogo> partidas) {
		this.partidas = partidas;
	}

	public void logar(Usuario u) {
		u = usuarioDao.getUsuario(u.getLogin(), u.getSenha());
		usuarios.add(u);
	}

	public void mandarJogada(Jogo rodadaJogada) {
		partidas.add(rodadaJogada);
	}

	public List<Jogo> pegarJogadas(Usuario voce, Usuario outro) {
		List<Jogo> retorno = new ArrayList<Jogo>();

		for (Jogo jg : partidas) {
			if ((jg.getDestino().equals(outro) && jg.getOrigem().equals(voce))
					|| (jg.getDestino().equals(voce) && jg.getOrigem().equals(outro))) {
				retorno.add(jg);

			}
		}
		return retorno;
	}

}
