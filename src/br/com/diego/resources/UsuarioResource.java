package br.com.diego.resources;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.diego.model.Combustivel;
import br.com.diego.model.Usuario;

@ManagedBean(name = "usuarioResource")
@RequestScoped
public class UsuarioResource {
	
	public String nome = "Joao";
	public Usuario usuario = new Usuario(0,"Joao","e@e.com","perfil1");
	
	/**
	public List<Usuario> getTodosUsuarios() {
		List<Usuario> usuarios1 = null;
		//fazer o código para buscar combustiveis
		Usuario c1 = new Usuario(0,"Joao","e@e.com","perfil1");
		Usuario c2 = new Usuario(0,"Maria","r@e.com","perfil1");
		Usuario c3 = new Usuario(0,"Jose","s@e.com","perfil1");
		usuarios.add(c1);
		usuarios.add(c2);
		usuarios.add(c3);
		
		return usuarios1;
	}
	
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	*/
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	/**
	 public long id;
	public String nome;
	public String email;
	public String perfil; 
	 
	 */

}
