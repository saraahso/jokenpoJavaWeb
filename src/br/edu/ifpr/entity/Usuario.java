package br.edu.ifpr.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Entity
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll",
            query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByLoginSenha",
    query = "SELECT u from Usuario u where u.login = :login and u.senha = :senha")
})
public class Usuario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2405188002888387658L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, updatable = false, nullable = false)
	@Getter
	@Setter
    private long id;
    
	@Getter
	@Setter
	@Column(length = 100, nullable = false)
    private String nome;
    
	@Getter
	@Setter
	@Column(length = 100, nullable = false)
	private String login;
	
	@Getter
	@Setter
	@Column(length = 100, nullable = false)
	private String senha;
		
}
