package br.com.diego.resources;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.diego.model.Combustivel;

@ManagedBean
@RequestScoped
public class CombustivelResource {
	
	private List <Combustivel> combustiveis = listUsuarios();
	private Combustivel combustivel = new Combustivel();
	
	public CombustivelResource() {
		this.combustiveis = new ArrayList<Combustivel>();
	}
	
	public List<Combustivel> listUsuarios() {
		//fazer o código para buscar combustiveis
		Combustivel c1 = new Combustivel(0, "CO", "PB", "JOÃO PESSOA", "PETROBRAS", "PROPRIA 1", "GASOLINA COMUM", "10/07/2019", "3,50", "4,20", "LT", "BR", "12/07/2019");
		Combustivel c2 = new Combustivel(1, "CO", "PB", "JOÃO PESSOA", "ESSO", "PROPRIA 2", "GASOLINA COMUM", "10/07/2019", "3,50", "4,25", "LT", "BR", "12/07/2019");
		Combustivel c3 = new Combustivel(2, "CO", "PB", "JOÃO PESSOA", "TEXACO", "PROPRIA 3", "GASOLINA COMUM", "10/07/2019", "3,50", "4,30", "LT", "BR", "12/07/2019");
		Combustivel c4 = new Combustivel(3, "CO", "PB", "JOÃO PESSOA", "TEXACO", "PROPRIA 4", "GASOLINA COMUM", "10/07/2019", "3,50", "4,50", "LT", "BR", "12/07/2019");
		combustiveis.add(c1);
		combustiveis.add(c2);
		combustiveis.add(c3);
		combustiveis.add(c4);
		
		return combustiveis;
	}

	public List<Combustivel> getCombustiveis() {
		return combustiveis;
	}

	public void setCombustiveis(List<Combustivel> combustiveis) {
		this.combustiveis = combustiveis;
	}

	public Combustivel getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}
	
	

}
