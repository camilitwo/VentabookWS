/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soap.ventabook.logica;

import com.soap.ventabook.conexion.ConexionMySQL;
import com.soap.ventabook.dao.ProductoDAO;
import com.soap.ventabook.dto.BodegaDTO;
import com.soap.ventabook.dto.ClienteDTO;
import com.soap.ventabook.dto.DespachoDTO;
import com.soap.ventabook.dto.StockDTO;
import com.soap.ventabook.dto.VentasDTO;
import java.sql.Connection;
import java.util.List;
import java.util.Random;

/**
 *
 * @author camil
 */
public class LogicaStock {

    public static List<StockDTO> getStock(String sku) {
        List<StockDTO> lista = null;
        try {
            
            ConexionMySQL SQL = new ConexionMySQL();
            Connection conn = SQL.conectarMySQL();
            
            lista = ProductoDAO.getStock(conn, sku);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public static void eliminarProducto(StockDTO stock) throws Exception {
        try {
            
            ConexionMySQL SQL = new ConexionMySQL();
            Connection conn = SQL.conectarMySQL();
            conn.setAutoCommit(false);
            ProductoDAO.eliminarProducto(conn, stock);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("100");
        }
    }

    public static void actualizarProducto(StockDTO stock) throws Exception {
         try {
            
            ConexionMySQL SQL = new ConexionMySQL();
            Connection conn = SQL.conectarMySQL();
            conn.setAutoCommit(false);
            ProductoDAO.actualizarProducto(conn, stock);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("300");
        }
    }

    public static void insertarProducto(StockDTO stock) throws Exception {
        try {
            
            ConexionMySQL SQL = new ConexionMySQL();
            Connection conn = SQL.conectarMySQL();
            Random random = new Random();
            conn.setAutoCommit(false);
            String idProducto;
            idProducto = String.valueOf(random.nextInt(20010));
            stock.setIdProducto(idProducto);
            ProductoDAO.insertarProducto(conn, stock, idProducto);
            conn.commit();
            ProductoDAO.insertarProductoBodega(conn, stock, idProducto);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("300");
        }
    }

    public static List<ClienteDTO> getClientes() {
        List<ClienteDTO> lista = null;
        try {
            
            ConexionMySQL SQL = new ConexionMySQL();
            Connection conn = SQL.conectarMySQL();
            
            lista = ProductoDAO.getClientes(conn);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public static void eliminarCliente(ClienteDTO cliente) throws Exception {
        try {
            
            ConexionMySQL SQL = new ConexionMySQL();
            Connection conn = SQL.conectarMySQL();
            conn.setAutoCommit(false);
            ProductoDAO.eliminarCliente(conn, cliente);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("100");
        }
    }

    public static void actualizarCliente(ClienteDTO cliente) throws Exception {
        try {
            
            ConexionMySQL SQL = new ConexionMySQL();
            Connection conn = SQL.conectarMySQL();
            conn.setAutoCommit(false);
            ProductoDAO.actualizarCliente(conn, cliente);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("100");
        }
    }

    public static void insertarCliente(ClienteDTO cliente) throws Exception {
         try {
            
            ConexionMySQL SQL = new ConexionMySQL();
            Connection conn = SQL.conectarMySQL();
            conn.setAutoCommit(false);
            ProductoDAO.insertarCliente(conn, cliente);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("100");
        }
    }

    public static List<VentasDTO> getVentas() {
        List<VentasDTO> lista = null;
        try {
            
            ConexionMySQL SQL = new ConexionMySQL();
            Connection conn = SQL.conectarMySQL();
            
            lista = ProductoDAO.getVentas(conn);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public static List<DespachoDTO> getDespacho() {
        List<DespachoDTO> lista = null;
        try {
            
            ConexionMySQL SQL = new ConexionMySQL();
            Connection conn = SQL.conectarMySQL();
            
            lista = ProductoDAO.getDespacho(conn);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public static List<BodegaDTO> getBodega() {
        List<BodegaDTO> lista = null;
        try {
            
            ConexionMySQL SQL = new ConexionMySQL();
            Connection conn = SQL.conectarMySQL();
            
            lista = ProductoDAO.getBodega(conn);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public static void eliminarBodega(BodegaDTO bodega) throws Exception {
        try {
            
            ConexionMySQL SQL = new ConexionMySQL();
            Connection conn = SQL.conectarMySQL();
            conn.setAutoCommit(false);
            ProductoDAO.eliminarBodega(conn, bodega);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("100");
        }
    }

    public static void actualizarBodega(BodegaDTO bodega) throws Exception {
        try{
        ConexionMySQL SQL = new ConexionMySQL();
            Connection conn = SQL.conectarMySQL();
            conn.setAutoCommit(false);
            ProductoDAO.actualizarBodega(conn, bodega);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("100");
        }
    }

    public static void insertarBodega(BodegaDTO bodega) throws Exception {
        try{
         ConexionMySQL SQL = new ConexionMySQL();
            Connection conn = SQL.conectarMySQL();
            conn.setAutoCommit(false);
            ProductoDAO.insertarBodega(conn, bodega);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("100");
        }
    }

    public static void ingresarVenta(VentasDTO venta) throws Exception {
        try{
         ConexionMySQL SQL = new ConexionMySQL();
            Connection conn = SQL.conectarMySQL();
            conn.setAutoCommit(false);
            ProductoDAO.ingresarVenta(conn, venta);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("100");
        }
    }
    
}
