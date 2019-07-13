package br.com.diego.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.diego.model.Combustivel;

public class CombustivelRepository {
	
	
	public static void main(String[] args) throws Exception {
		
		HttpExemplo http = new HttpExemplo();
    	String chamadaWS;
    	
    	chamadaWS = "http://localhost:8080/api/combustiveis/AgrupadoPorDataDaColeta" ;
    	
    	String json = http.sendGet(chamadaWS, "GET");
    	
    	Gson g = new Gson();
    	
    	Combustivel c = new Combustivel();
    	
    	Type combustivelType = new TypeToken<List<Combustivel>>() {}.getType();
    	
    	c = g.fromJson(json, combustivelType);
    	
    	System.out.println(c);
		
	}
	
	public String sendGet(String url) throws Exception{
		
		//String url = "http://localhost:8080/combustiveis/api/combustiveis/MediaCompraVendaPorMunicipio/";
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		
		con.setRequestMethod("GET");
		
		//con.setRequestProperty("User-Agent", USER_AGENTE);
		
		int responseCode = con.getResponseCode();
		
		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream())
		);
		String inputLine;
		StringBuffer response = new StringBuffer();
		
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		
		in.close();
		
		return response.toString();
		
		
	}
	
	
}
