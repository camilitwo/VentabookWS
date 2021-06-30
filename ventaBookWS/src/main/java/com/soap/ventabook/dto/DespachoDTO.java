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
public class DespachoDTO  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idDespacho;
	private String nombreProducto;
	private String nombreCliente;
	private String valorDespacho;
	private String descripcionDespacho;
	private String fecha;
	private String total;

    public String getIdDespacho() {
        return idDespacho;
    }

    public void setIdDespacho(String idDespacho) {
        this.idDespacho = idDespacho;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getValorDespacho() {
        return valorDespacho;
    }

    public void setValorDespacho(String valorDespacho) {
        this.valorDespacho = valorDespacho;
    }

    public String getDescripcionDespacho() {
        return descripcionDespacho;
    }

    public void setDescripcionDespacho(String descripcionDespacho) {
        this.descripcionDespacho = descripcionDespacho;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
        
        
        
        
    
}
