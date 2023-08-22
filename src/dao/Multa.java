/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Paulo
 */
public class Multa {
    
    private int id_multa;
    private String tipo_multa;
    private String desc_multa;
    private String valor;
    private String data;
    
     //get and set da tabela multa

    public int getId_multa() {
        return id_multa;
    }

    public void setId_multa(int id_multa) {
        this.id_multa = id_multa;
    }
    
    public String getTipo_multa() {
        return tipo_multa;
    }

    public void setTipo_multa(String tipo_multa) {
        this.tipo_multa = tipo_multa;
    }
    
    public String getDesc_multa() {
        return desc_multa;
    }

    public void setDesc_multa(String desc_multa) {
        this.desc_multa = desc_multa;
    }


    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
