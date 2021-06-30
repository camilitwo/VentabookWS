/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soap.ventabook;


import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author camil
 */

public interface Libreria {
    
    
@WebMethod(operationName= "obtenerClientes")
	public String obtenerClientes();
	
	@WebMethod(operationName= "actualizarCliente")
	public String actualizarCliente(@WebParam(name = "json") String json);
	
	@WebMethod(operationName= "obtenerStock")
	public String obtenerStock(@WebParam(name = "json") String json);
	
	@WebMethod(operationName= "actualizarStock")
	public String actualizarStock(@WebParam(name = "json") String json);
	
	@WebMethod(operationName= "obtenerVentas")
	public String obtenerVentas(@WebParam(name = "json") String json);
	
	@WebMethod(operationName= "actualizarVentas")
	public String actualizarVentas(@WebParam(name = "json") String json);
	
	@WebMethod(operationName= "obtenerDespacho")
	public String obtenerDespacho(@WebParam(name = "json") String json);
	
	@WebMethod(operationName= "actualizarDespacho")
	public String actualizarDespacho(@WebParam(name = "json") String json);
	
	@WebMethod(operationName= "obtenerBodega")
	public String obtenerBodega(@WebParam(name = "json") String json);
	
	@WebMethod(operationName= "actualizarBodega")
	public String actualizarBodega(@WebParam(name = "json") String json);
    
    
}
