package br.com.diego.model;


import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**Classe do objeto Combustivel
* @author Diego Rangel
* @return -
*/

@ManagedBean
@RequestScoped
public class Combustivel implements Serializable {
    
    public int id;
    public String regiao;
    public String estado;
    public String municipio;
    public String revenda;
    public String instalacao;
    public String produto;
    public String dataDaColeta;
    public String valoDaCompra;
    public String ValorDaVenda;
    public String unidadeDeMedida;
    public String bandeira;      
    public String dataImportacao;
    
//    Região - Sigla  Estado - Sigla  Município  Revenda  Instalação - Código  Produto  Data da Coleta  Valor de Compra  Valor de Venda  Unidade de Medida  Bandeira
//    CO  DF  BRASILIA  AUTO POSTO BRAGA LTDA  7890  DIESEL  03/01/2018    3,699  R$ / litro  IPIRANGA
//    CO  DF  BRASILIA  AUTO POSTO CHAVES LTDA  7970  DIESEL  03/01/2018  3,218  3,559  R$ / litro  PETROBRAS DISTRIBUIDORA S.A.
//    CO  DF  BRASILIA  AUTO POSTO JB LIMITADA  7990  DIESEL  03/01/2018  3,1505  3,489  R$ / litro  PETROBRAS DISTRIBUIDORA S.A.
//    CO  DF  BRASILIA  AUTO POSTO SAO JUDAS TADEU LTDA  166827  DIESEL  03/01/2018    3,199  R$ / litro  IPIRANGA
//    CO  DF  BRASILIA  BRASAL COMBUSTIVEIS LTDA  8048  DIESEL  03/01/2018    3,599  R$ / litro  RAIZEN
//    CO  DF  BRASILIA  ESTAÇÃO DE COMBUSTÍVEIS WEST LTDA.  7679  DIESEL  03/01/2018    3,429  R$ / litro  PETROBRAS DISTRIBUIDORA S.A.

    public Combustivel(int id, String regiao, String estado, String municipio, String revenda, String instalacao, String produto, String dataDaColeta, String valoDaCompra, String ValorDaVenda, String unidadeDeMedida, String bandeira, String dataImportacao) {
        this.id = id;
        this.regiao = regiao;
        this.estado = estado;
        this.municipio = municipio;
        this.revenda = revenda;
        this.instalacao = instalacao;
        this.produto = produto;
        this.dataDaColeta = dataDaColeta;
        this.valoDaCompra = valoDaCompra;
        this.ValorDaVenda = ValorDaVenda;
        this.unidadeDeMedida = unidadeDeMedida;
        this.bandeira = bandeira;
        this.dataImportacao = dataImportacao;
    }
    
    public Combustivel() {	
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getRevenda() {
        return revenda;
    }

    public void setRevenda(String revenda) {
        this.revenda = revenda;
    }

    public String getInstalacao() {
        return instalacao;
    }

    public void setInstalacao(String instalacao) {
        this.instalacao = instalacao;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getDataDaColeta() {
        return dataDaColeta;
    }

    public void setDataDaColeta(String dataDaColeta) {
        this.dataDaColeta = dataDaColeta;
    }

    public String getValoDaCompra() {
        return valoDaCompra;
    }

    public void setValoDaCompra(String valoDaCompra) {
        this.valoDaCompra = valoDaCompra;
    }

    public String getValorDaVenda() {
        return ValorDaVenda;
    }

    public void setValorDaVenda(String ValorDaVenda) {
        this.ValorDaVenda = ValorDaVenda;
    }

    public String getUnidadeDeMedida() {
        return unidadeDeMedida;
    }

    public void setUnidadeDeMedida(String unidadeDeMedida) {
        this.unidadeDeMedida = unidadeDeMedida;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getDataImportacao() {
        return dataImportacao;
    }

    public void setDataImportacao(String dataImportacao) {
        this.dataImportacao = dataImportacao;
    }

    
    
}

