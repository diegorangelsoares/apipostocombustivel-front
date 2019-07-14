package br.com.diego.resources;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.diego.model.Combustivel;
import br.com.diego.repository.HttpExemplo;

@ManagedBean(name = "combustivelResource")
@RequestScoped
public class CombustivelResource {
	
	private static final long serialVersionUID = 1L;
	
	private String media = Muda();
	
	private String mediaPorBandeira = RetornaMediaPorBandeira();
	
	
	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}
	
	public String Muda() {
		//return getMediaCompraVenda("JOÃO PESSOA");
		return "4,23";
	}
	
	public String RetornaMediaPorBandeira() {
		//return getMediaCompraVenda("JOÃO PESSOA");
		return "4,35";
	}
	
	public String getMediaPorBandeira() {
		return mediaPorBandeira;
	}

	public void setMediaPorBandeira(String mediaPorBandeira) {
		this.mediaPorBandeira = mediaPorBandeira;
	}

	public List<Combustivel> getCombustiveis() {
		return combustiveis;
	}

	public void setCombustiveis(List<Combustivel> combustiveis) {
		this.combustiveis = combustiveis;
	}

	public String getMediaCompraVenda(String municipio){
		List <Combustivel> combustiveis = listCombustiveis();
		List <Combustivel> combustiveisMunicipio = new ArrayList<>();
		for (int i = 0; i < combustiveis.size(); i++) {
			if (combustiveis.get(i).getMunicipio().equals(municipio.toUpperCase())) {
				combustiveisMunicipio.add(combustiveis.get(i));
			}
		}
		//fazer código para calcular media
		String med = retornMedia(combustiveisMunicipio);
		String medCompra = retornMediaCompra(combustiveisMunicipio);
		String retorno = "Média de Compra: "+medCompra + "  Média de Venda: "+med;
		return retorno;
	}
	
	private List <Combustivel> historicoCombustiveis = requisicaoAPIREstListAll();
	public List<Combustivel> requisicaoAPIREstListAll() {
		HttpExemplo http = new HttpExemplo();
    	String chamadaWS;
    	
    	chamadaWS = "http://localhost:8080/api/combustiveis" ;
    	
    	String json = null;
		try {
			json = http.sendGet(chamadaWS, "GET");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	Gson g = new Gson();
    	
    	List<Combustivel> c = new ArrayList<Combustivel>();
    	
    	Type combustivelType = new TypeToken<List<Combustivel>>() {}.getType();
    	
    	c = g.fromJson(json, combustivelType);
    	
    	//System.out.println(c);
    	return c;
	}
	
	public List <Combustivel> combustiveis = null;
	public List<Combustivel> listCombustiveis() {
		//fazer o código para buscar combustiveis
		Combustivel c1 = new Combustivel(0, "CO", "PB", "JOAO PESSOA", "PETROBRAS", "PROPRIA 1", "GASOLINA COMUM", "10/07/2019", "3,50", "4,20", "LT", "BR", "12/07/2019");
		Combustivel c2 = new Combustivel(1, "CO", "PB", "JOAO PESSOA", "ESSO", "PROPRIA 2", "GASOLINA COMUM", "10/07/2019", "3,50", "4,25", "LT", "BR", "12/07/2019");
		Combustivel c3 = new Combustivel(2, "CO", "PB", "JOAO PESSOA", "TEXACO", "PROPRIA 3", "GASOLINA COMUM", "10/07/2019", "3,50", "4,30", "LT", "BR", "12/07/2019");
		Combustivel c4 = new Combustivel(3, "CO", "PB", "JOAO PESSOA", "TEXACO", "PROPRIA 4", "GASOLINA COMUM", "10/07/2019", "3,50", "4,50", "LT", "BR", "12/07/2019");
		combustiveis.add(c1);
		combustiveis.add(c2);
		combustiveis.add(c3);
		combustiveis.add(c4);
		
		return combustiveis;
	}
	
	
	
	public String retornMedia (List <Combustivel> combustiveis){
		DecimalFormat df = new DecimalFormat ("#0.000", new DecimalFormatSymbols (new Locale ("pt", "BR")));  
		int quantReg = 0;
		double totalPrecos = 0;
		for (int i = 0; i < combustiveis.size(); i++) {
			double preco1 = 0;
			String valorVenda = combustiveis.get(i).getValorDaVenda();
			//Tratar se tem preço de venda preenchido
			if (!valorVenda.equals("")){
		        try {
		        	preco1 = df.parse (valorVenda).doubleValue(); // isto deve dar o número "1234.56"	 
		        	//preco1 = Double.parseDouble(valorVenda);    
		            totalPrecos = totalPrecos + preco1;
		            quantReg++;
		        } catch (ParseException ex) {
		            ex.printStackTrace();
		        }
				//System.out.println("Municipio: "+combustiveis.get(i).getMunicipio()+"\nPreço: "+combustiveis.get(i).getValorDaVenda()+"\n");
			}
		}
		totalPrecos = totalPrecos / quantReg;
        String TotalString = df.format (totalPrecos); // deve retornar a string "1.234,56"     
        return TotalString;
    }
	
	public String retornMediaCompra (List <Combustivel> combustiveis){
		DecimalFormat df = new DecimalFormat ("#0.000", new DecimalFormatSymbols (new Locale ("pt", "BR")));  
		int quantReg = 0;
		double totalPrecos = 0;
		for (int i = 0; i < combustiveis.size(); i++) {
			double preco1 = 0;
			String valorCompra = combustiveis.get(i).getValoDaCompra();
			//Tratar se tem preço de venda preenchido
			if (!valorCompra.equals("")){
		        try {
		        	preco1 = df.parse (valorCompra).doubleValue(); // isto deve dar o número "1234.56"	 
		        	//preco1 = Double.parseDouble(valorVenda);    
		            totalPrecos = totalPrecos + preco1;
		            quantReg++;
		        } catch (ParseException ex) {
		            ex.printStackTrace();
		        }
			}
		}
		totalPrecos = totalPrecos / quantReg;
        String TotalString = df.format (totalPrecos); // deve retornar a string "1.234,56"     
        return TotalString;
    }
	
	private List <Combustivel> combustiveisPorDataDeColeta = requisicaoAPIREstPorDataDeColeta();
	public List<Combustivel> requisicaoAPIREstPorDataDeColeta() {
		HttpExemplo http = new HttpExemplo();
    	String chamadaWS;
    	
    	chamadaWS = "http://localhost:8080/api/combustiveis/AgrupadoPorDataDaColeta" ;
    	
    	String json = null;
		try {
			json = http.sendGet(chamadaWS, "GET");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	Gson g = new Gson();
    	
    	List<Combustivel> c = new ArrayList<Combustivel>();
    	
    	Type combustivelType = new TypeToken<List<Combustivel>>() {}.getType();
    	
    	c = g.fromJson(json, combustivelType);
    	
    	//System.out.println(c);
    	return c;
	}
	
	private List <Combustivel> combustiveisPorSigla = requisicaoAPIREstPorSigla("BR");
	public List<Combustivel> requisicaoAPIREstPorSigla(String sigla) {
		HttpExemplo http = new HttpExemplo();
    	String chamadaWS;
    	
    	chamadaWS = "http://localhost:8080/api/combustiveis/importadoPorRegiao/"+sigla ;
    	
    	String json = null;
		try {
			json = http.sendGet(chamadaWS, "GET");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	Gson g = new Gson();
    	
    	List<Combustivel> c = new ArrayList<Combustivel>();
    	
    	Type combustivelType = new TypeToken<List<Combustivel>>() {}.getType();
    	
    	c = g.fromJson(json, combustivelType);
    	
    	//System.out.println(c);
    	return c;
	}
	
	private List <Combustivel> combustiveisPorDistribuidora = requisicaoAPIREstPorDistribuidora();
	public List<Combustivel> requisicaoAPIREstPorDistribuidora() {
		HttpExemplo http = new HttpExemplo();
    	String chamadaWS;
    	
    	chamadaWS = "http://localhost:8080/api/combustiveis/AgrupadoPorDistribuidora" ;
    	
    	String json = null;
		try {
			json = http.sendGet(chamadaWS, "GET");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	Gson g = new Gson();
    	
    	List<Combustivel> c = new ArrayList<Combustivel>();
    	
    	Type combustivelType = new TypeToken<List<Combustivel>>() {}.getType();
    	
    	c = g.fromJson(json, combustivelType);
    	
    	//System.out.println(c);
    	return c;
	}
	
	

}
