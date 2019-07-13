package br.com.diego.resources;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

@ManagedBean(name = "validadorMB")
@RequestScoped
public class ValidadorMB  {

private static final long serialVersionUID = 1L;

private String cpf = "555";

public void validar() {
  if (cpf == null || "".equals(cpf)) {
      FacesContext.getCurrentInstance().addMessage("msgValidador", 
      new FacesMessage("CPF Vazio"));
  } else if (cpf.length() != 11) {
      FacesContext.getCurrentInstance().addMessage("msgValidador", 
      new FacesMessage("CPF deve ter 11 dígitos"));

  }else{
      FacesContext.getCurrentInstance().addMessage("msgValidador", 
      new FacesMessage("CPF Validado com sucesso !!"));
  }
}

public String getCpf() {
  return cpf;
}

public void setCpf(String cpf) {
  this.cpf = cpf;
}

}