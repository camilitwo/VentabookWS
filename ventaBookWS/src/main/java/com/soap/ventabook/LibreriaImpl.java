/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soap.ventabook;

import com.google.gson.Gson;
import com.soap.ventabook.dto.BodegaDTO;
import com.soap.ventabook.dto.ClienteDTO;
import com.soap.ventabook.dto.DespachoDTO;
import com.soap.ventabook.dto.ResponseDTO;
import com.soap.ventabook.dto.StockDTO;
import com.soap.ventabook.dto.UbicacionDTO;
import com.soap.ventabook.dto.VentasDTO;
import com.soap.ventabook.logica.LogicaStock;
import java.util.List;
import java.util.Random;
import javax.jws.WebService;

/**
 *
 * @author camil
 */
@WebService(serviceName = "libros")
public class LibreriaImpl implements Libreria{

    @Override
    public String obtenerStock(String sku) {
        System.out.println("com.soap.calculadorawssoap.CalculadoraImpl.consultarStock()");
        Gson gson = new Gson();
        String response = null;
        try {
            ResponseDTO stock = new ResponseDTO();
            stock.setCodigo("200 OK");
            stock.setDescripcion("No hay Stock para el SKU consultado");
            response = gson.toJson(stock);
            List<StockDTO> listaStock = LogicaStock.getStock(sku);   
            
            if(!listaStock.isEmpty())
                response = gson.toJson(listaStock);
        } catch (Exception e) {
        }
        
        return response;
    }

    @Override
    public String obtenerClientes() {
         System.out.println("com.soap.calculadorawssoap.CalculadoraImpl.obtenerClientes()");
        Gson gson = new Gson();
        String response = null;
        try {
            ResponseDTO stock = new ResponseDTO();
            stock.setCodigo("200 OK");
            stock.setDescripcion("No hay Stock para el SKU consultado");
            response = gson.toJson(stock);
            List<ClienteDTO> listaStock = LogicaStock.getClientes();   
            
            if(!listaStock.isEmpty())
                response = gson.toJson(listaStock);
        } catch (Exception e) {
        }
        
        return response;
    }

    @Override
    public String actualizarCliente(String json) {
       System.out.println("com.soap.calculadorawssoap.CalculadoraImpl.actualizarStock()");
        Gson gson = new Gson();
        ResponseDTO respuesta = new ResponseDTO();
        try {
            
            ClienteDTO cliente = gson.fromJson(json, ClienteDTO.class);
            System.out.println("--------------->"+cliente.getAccion());
            
            
            
            if("ELIMINAR".equalsIgnoreCase(cliente.getAccion())){
                System.out.println("Eliminando");
                LogicaStock.eliminarCliente(cliente);  
                respuesta.setCodigo("200");
                respuesta.setDescripcion("Eliminado");
            }else if("MODIFICAR".equalsIgnoreCase(cliente.getAccion())){
                System.out.println("Actualizando");
                LogicaStock.actualizarCliente(cliente);  
                respuesta.setCodigo("200");
                respuesta.setDescripcion("Actualilzado");
            }else if("AGREGAR".equalsIgnoreCase(cliente.getAccion())){
                LogicaStock.insertarCliente(cliente);  
                System.out.println("Agregando");
                respuesta.setCodigo("200");
                respuesta.setDescripcion("Agregado");
            }
            
             
        } catch (Exception e) {
            respuesta.setCodigo(e.getMessage());
            respuesta.setDescripcion("Error en la transaccion");
        }
        
        return gson.toJson(respuesta);
    }

    @Override
    public String actualizarStock(String json) {
         System.out.println("com.soap.calculadorawssoap.CalculadoraImpl.actualizarStock()");
        Gson gson = new Gson();
        ResponseDTO respuesta = new ResponseDTO();
        try {
            
            StockDTO stock = gson.fromJson(json, StockDTO.class);
            System.out.println("--------------->"+stock.getAccion());
            
            
            
            if("ELIMINAR".equalsIgnoreCase(stock.getAccion())){
                System.out.println("Eliminando");
                LogicaStock.eliminarProducto(stock);  
                respuesta.setCodigo("200");
                respuesta.setDescripcion("Eliminado");
            }else if("MODIFICAR".equalsIgnoreCase(stock.getAccion())){
                System.out.println("Actualizando");
                LogicaStock.actualizarProducto(stock);  
                respuesta.setCodigo("200");
                respuesta.setDescripcion("Actualilzado");
            }else if("AGREGAR".equalsIgnoreCase(stock.getAccion())){
                LogicaStock.insertarProducto(stock);  
                System.out.println("Agregando");
                respuesta.setCodigo("200");
                respuesta.setDescripcion("Agregado");
            }
            
             
        } catch (Exception e) {
            respuesta.setCodigo(e.getMessage());
            respuesta.setDescripcion("Error en la transaccion");
        }
        
        return gson.toJson(respuesta);
    }

    @Override
    public String obtenerVentas(String json) {
         System.out.println("com.soap.calculadorawssoap.CalculadoraImpl.obtenerVentas()");
        Gson gson = new Gson();
        String response = null;
        try {
            ResponseDTO stock = new ResponseDTO();
            stock.setCodigo("200 OK");
            stock.setDescripcion("No hay Stock para el SKU consultado");
            response = gson.toJson(stock);
            List<VentasDTO> listaStock = LogicaStock.getVentas();   
            
            if(!listaStock.isEmpty())
                response = gson.toJson(listaStock);
        } catch (Exception e) {
        }
        
        return response;
    }

    @Override
    public String actualizarVentas(String json) {
         System.out.println("com.soap.calculadorawssoap.CalculadoraImpl.actualizarVentas()");
        Gson gson = new Gson();
        ResponseDTO respuesta = new ResponseDTO();
        try {
            
            VentasDTO venta = gson.fromJson(json, VentasDTO.class);
            
            LogicaStock.ingresarVenta(venta);
            
             
        } catch (Exception e) {
            respuesta.setCodigo(e.getMessage());
            respuesta.setDescripcion("Error en la transaccion");
        }
        
        return gson.toJson(respuesta);
    }

    @Override
    public String obtenerDespacho(String json) {
        System.out.println("com.soap.calculadorawssoap.CalculadoraImpl.obtenerDespacho()");
        Gson gson = new Gson();
        String response = null;
        try {
            ResponseDTO stock = new ResponseDTO();
            stock.setCodigo("200 OK");
            stock.setDescripcion("No hay Stock para el SKU consultado");
            response = gson.toJson(stock);
            List<DespachoDTO> listaStock = LogicaStock.getDespacho();  
            
            if(!listaStock.isEmpty())
                response = gson.toJson(listaStock);
        } catch (Exception e) {
        }
        
        return response;
    }

    @Override
    public String actualizarDespacho(String json) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String obtenerBodega(String json) {
        System.out.println("com.soap.calculadorawssoap.CalculadoraImpl.obtenerBodega()");
        Gson gson = new Gson();
        String response = null;
        try {
            ResponseDTO stock = new ResponseDTO();
            stock.setCodigo("200 OK");
            stock.setDescripcion("No hay Stock para el SKU consultado");
            response = gson.toJson(stock);
            List<BodegaDTO> listaStock = LogicaStock.getBodega(); 
            
            if(!listaStock.isEmpty())
                response = gson.toJson(listaStock);
        } catch (Exception e) {
        }
        
        return response;
    }

    @Override
    public String actualizarBodega(String json) {
         System.out.println("com.soap.calculadorawssoap.CalculadoraImpl.actualizarStock()");
        Gson gson = new Gson();
        ResponseDTO respuesta = new ResponseDTO();
        try {
            
            BodegaDTO bodega = gson.fromJson(json, BodegaDTO.class);
            System.out.println("--------------->"+bodega.getAccion());
            
            
            
            if("ELIMINAR".equalsIgnoreCase(bodega.getAccion())){
                System.out.println("Eliminando");
                LogicaStock.eliminarBodega(bodega);  
                respuesta.setCodigo("200");
                respuesta.setDescripcion("Eliminado");
            }else if("MODIFICAR".equalsIgnoreCase(bodega.getAccion())){
                System.out.println("Actualizando");
                LogicaStock.actualizarBodega(bodega);  
                respuesta.setCodigo("200");
                respuesta.setDescripcion("Actualilzado");
            }else if("AGREGAR".equalsIgnoreCase(bodega.getAccion())){
                LogicaStock.insertarBodega(bodega);  
                System.out.println("Agregando");
                respuesta.setCodigo("200");
                respuesta.setDescripcion("Agregado");
            }
            
             
        } catch (Exception e) {
            respuesta.setCodigo(e.getMessage());
            respuesta.setDescripcion("Error en la transaccion");
        }
        
        return gson.toJson(respuesta);
    }
    
}
