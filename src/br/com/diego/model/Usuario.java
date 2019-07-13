package br.com.diego.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**Classo do objeto Usuario
* @author Diego Rangel
* @return -
*/


public class Usuario {


	public long id;
	public String nome;
	public String email;
	public String perfil;
	
	public Usuario () {
		
	}
	
	public Usuario( String nome, String email, String perfil) {
		super();
		this.nome = nome;
		this.email = email;
		this.perfil = perfil;
	}
	
	public Usuario(long id, String nome, String email, String perfil) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.perfil = perfil;
	}



	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


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


	public String getPerfil() {
		return perfil;
	}


	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	
}
