package br.edu.ifpr.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.edu.ifpr.application.EntityManagerProducer;
import br.edu.ifpr.entity.Usuario;

public class UsuarioDao {

	protected EntityManager entidade;

	public UsuarioDao() {
		entidade = EntityManagerProducer.getConexao();
	}

	public void salvar(Usuario usuario) {
		EntityTransaction et = entidade.getTransaction();
		et.begin();
		entidade.persist(usuario);
		et.commit();
	}

	public Usuario getUsuario(String login, String senha) {
		Query consulta = entidade.createNamedQuery("Usuario.findByLoginSenha", Usuario.class);
		Usuario usuario = (Usuario) consulta.setParameter("login", login).setParameter("senha", senha)
				.getSingleResult();
		return usuario;
	}

}
