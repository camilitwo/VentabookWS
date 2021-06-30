/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soap.ventabook.dto;

import java.io.Serializable;

/**
 *
 * @author camil
 */
public class UbicacionDTO implements Serializable{
    
    
    private String codigoLibreria;
    private String nombreLibro;
    private String codigoSku;
    private String stock;

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getCodigoLibreria() {
        return codigoLibreria;
    }

    public void setCodigoLibreria(String codigoLibreria) {
        this.codigoLibreria = codigoLibreria;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getCodigoSku() {
        return codigoSku;
    }

    public void setCodigoSku(String codigoSku) {
        this.codigoSku = codigoSku;
    }
    
    
    
    
}
