/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soap.ventabook.dao;

import com.soap.ventabook.dto.BodegaDTO;
import com.soap.ventabook.dto.ClienteDTO;
import com.soap.ventabook.dto.DespachoDTO;
import com.soap.ventabook.dto.StockDTO;
import com.soap.ventabook.dto.VentasDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author camil
 */
public class ProductoDAO {

    public static List<StockDTO> getStock(Connection conn, String sku) {
        List<StockDTO> listaStock = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        StockDTO stock = null;
        try {
            
            String sql = "SELECT\n" +
                        " P.CODIGO_SKU,\n" +
                        " P.NOMBRE_PRODUCTO,\n" +
                        " PB.STOCK,\n" +
                        " B.ID_BODEGA,\n" +
                        " B.NOMBRE_BODEGA, P.ID_PRODUCTO\n" +
                        " FROM\n" +
                        " BODEGA B,\n" +
                        " PRODUCTO P,\n" +
                        " PRODUCTO_BODEGA PB\n" +
                        " WHERE\n" +
                        " PB.ID_BODEGA = B.ID_BODEGA\n" +
                        " AND PB.ID_PRODUCTO = P.ID_PRODUCTO \n";
            if(sku!=null){
                sql+=" AND P.CODIGO_SKU = ? ";
            }
            
            ps = conn.prepareStatement(sql);
            System.out.println("SQL: "+sql);
            if(sku!=null){
               ps.setString(1, sku);
               System.out.println("PARAMETRO 1: "+sku);
             }
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                stock = new StockDTO();
                stock.setCodigoSku(rs.getString("codigo_sku"));
                stock.setNombreProducto(rs.getString("nombre_producto"));
                stock.setStock(rs.getString("STOCK"));
                stock.setNombreLocal(rs.getString("nombre_bodega"));
                stock.setIdBodega(rs.getString("ID_BODEGA"));
                stock.setIdProducto(rs.getString("ID_PRODUCTO"));
                listaStock.add(stock);
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listaStock;
    }

    public static void eliminarProducto(Connection conn, StockDTO stock) {
        PreparedStatement ps = null;
        try {
            
            String sql = "delete from producto_bodega where id_producto = ? and id_bodega = ? ";
            
            ps = conn.prepareStatement(sql);
            System.out.println("SQL: "+sql);
            ps.setString(1, stock.getIdProducto());
            System.out.println("PARAMETRO 1: "+stock.getIdProducto());
            
            ps.setString(2, stock.getIdBodega());
            System.out.println("PARAMETRO 2: "+stock.getIdBodega());
            
            ps.executeUpdate();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void actualizarProducto(Connection conn, StockDTO stock) {
         PreparedStatement ps = null;
        try {
            
            String sql = "update producto_bodega set stock = ? where id_producto = ? and id_bodega = ? ";
            
            ps = conn.prepareStatement(sql);
            System.out.println("SQL: "+sql);
            
            ps.setString(1, stock.getStock());
            System.out.println("PARAMETRO 1: "+stock.getStock());
            
            ps.setString(2, stock.getIdProducto());
            System.out.println("PARAMETRO 2: "+stock.getIdProducto());
            
            ps.setString(3, stock.getIdBodega());
            System.out.println("PARAMETRO 3: "+stock.getIdBodega());
            
            ps.executeUpdate();
            
            ps.close();
            
            sql = "update producto set nombre_producto = ?, codigo_sku = ? where id_producto = ? ";
            
            ps = conn.prepareStatement(sql);
            System.out.println("SQL: "+sql);
            
            ps.setString(1, stock.getNombreProducto());
            System.out.println("PARAMETRO 1: "+stock.getNombreProducto());
            
            ps.setString(2, stock.getCodigoSku());
            System.out.println("PARAMETRO 2: "+stock.getCodigoSku());
            
            ps.setString(3, stock.getIdProducto());
            System.out.println("PARAMETRO 3: "+stock.getIdProducto());
            
            ps.executeUpdate();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertarProducto(Connection conn, StockDTO stock, String idProducto) {
        PreparedStatement ps = null;
        try {
            
            String sql = " INSERT INTO PRODUCTO (ID_PRODUCTO, CODIGO_SKU, NOMBRE_PRODUCTO) "
                    + " VALUES("
                    + " ?, "
                    + " ?, "
                    + " ?) ";
            
            ps = conn.prepareStatement(sql);
            System.out.println("SQL: "+sql);
            
             ps.setString(1, idProducto);
            System.out.println("PARAMETRO 1: "+idProducto);
            
            ps.setString(2, stock.getCodigoSku());
            System.out.println("PARAMETRO 2: "+stock.getCodigoSku());
            
            ps.setString(3, stock.getNombreProducto());
            System.out.println("PARAMETRO 3: "+stock.getNombreProducto());
            
            ps.executeUpdate();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertarProductoBodega(Connection conn, StockDTO stock,  String idProducto) {
         PreparedStatement ps = null;
         Random random = new Random();
        try {
            
            String sql = "INSERT INTO PRODUCTO_bodega (ID_BODEGA_PRODUCTO, ID_PRODUCTO, ID_BODEGA, STOCK) VALUES(?, ?,?,?) ";
            
            ps = conn.prepareStatement(sql);
            System.out.println("SQL: "+sql);
            
             ps.setString(1, String.valueOf(random.nextInt(30010)));
            System.out.println("PARAMETRO 1: "+random.nextInt(30010));
            
            ps.setString(2, idProducto);
            System.out.println("PARAMETRO 1: "+idProducto);
            
            ps.setString(3, stock.getIdBodega());
            System.out.println("PARAMETRO 2: "+stock.getIdBodega());
            
            ps.setString(4, stock.getStock());
            System.out.println("PARAMETRO 3: "+stock.getStock());
            
            ps.executeUpdate();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<ClienteDTO> getClientes(Connection conn) {
        List<ClienteDTO> listaCliente = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ClienteDTO cliente = null;
        try {
            
            String sql = " select id_cliente, nombre_cli, telefono_cli, email_cli, direccion_cli from cliente ";
            
            ps = conn.prepareStatement(sql);
            System.out.println("SQL: "+sql);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                cliente = new ClienteDTO();
                cliente.setNombreCliente(rs.getString("nombre_cli"));
                cliente.setTelefono(rs.getString("telefono_cli"));
                cliente.setEmail(rs.getString("email_cli"));
                cliente.setDireccion(rs.getString("direccion_cli"));
                cliente.setIdCliente(rs.getString("id_cliente"));
                listaCliente.add(cliente);
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listaCliente;
    }

    public static void eliminarCliente(Connection conn, ClienteDTO cliente) {
        PreparedStatement ps = null;
        try {
            
            String sql = " DELETE FROM  cliente WHERE EMAIL_CLI = ? ";
            
            ps = conn.prepareStatement(sql);
            System.out.println("SQL: "+sql);
            
             ps.setString(1, cliente.getEmail());
            System.out.println("PARAMETRO 1: "+cliente.getEmail());
            
            ps.executeUpdate();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void actualizarCliente(Connection conn, ClienteDTO cliente) {
         PreparedStatement ps = null;
        try {
            
            String sql = " UPDATE cliente SET NOMBRE_CLI = ?, TELEFONO_CLI = ?, direccion_cli = ? WHERE EMAIL_CLI = ? ";
            
            ps = conn.prepareStatement(sql);
            System.out.println("SQL: "+sql);
            
             ps.setString(1, cliente.getNombreCliente());
            System.out.println("PARAMETRO 1: "+cliente.getNombreCliente());
            
            ps.setString(2, cliente.getTelefono());
            System.out.println("PARAMETRO 1: "+cliente.getTelefono());
            
            ps.setString(3, cliente.getDireccion());
            System.out.println("PARAMETRO 1: "+cliente.getDireccion());
            
            ps.setString(4, cliente.getEmail());
            System.out.println("PARAMETRO 1: "+cliente.getEmail());
            
            ps.executeUpdate();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertarCliente(Connection conn, ClienteDTO cliente) {
        PreparedStatement ps = null;
        Random random = new Random();
        try {
            
            String sql = " insert into cliente (NOMBRE_CLI, TELEFONO_CLI, direccion_cli, EMAIL_CLI, id_cliente ) values (?,?,?,?,?)";
            
            ps = conn.prepareStatement(sql);
            System.out.println("SQL: "+sql);
            
             ps.setString(1, cliente.getNombreCliente());
            System.out.println("PARAMETRO 1: "+cliente.getNombreCliente());
            
            ps.setString(2, cliente.getTelefono());
            System.out.println("PARAMETRO 2: "+cliente.getTelefono());
            
            ps.setString(3, cliente.getDireccion());
            System.out.println("PARAMETRO 3: "+cliente.getDireccion());
            
            ps.setString(4, cliente.getEmail());
            System.out.println("PARAMETRO 4: "+cliente.getEmail());
            
            ps.setString(5, String.valueOf(random.nextInt(1000)));
            
            ps.executeUpdate();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<VentasDTO> getVentas(Connection conn) {
         List<VentasDTO> listaVentas = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        VentasDTO venta = null;
        try {
            
            String sql = "SELECT v.id_ventas,\n" +
                        "       v.fecha,\n" +
                        "       c.nombre_cli,\n" +
                        "       p.nombre_producto,\n" +
                        "       COALESCE((select 'ENVIO DOMICILIO' from despacho d where d.id_despacho = v.id_despacho), 'RETIRO LOCAL') desc_retiro,"
                    + " c.direccion_cli direccion_despacho,  v.total \n" +
                        "FROM ventas V,\n" +
                        "     cliente C,\n" +
                        "     producto P\n" +
                        "WHERE V.id_cliente = C.id_cliente\n" +
                        "  AND P.id_producto = V.id_producto";
            
            ps = conn.prepareStatement(sql);
            System.out.println("SQL: "+sql);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                venta = new VentasDTO();
                venta.setDireccionDespacho(rs.getString("desc_retiro"));
                venta.setIdVenta(rs.getString("id_ventas"));
                venta.setNombreProducto(rs.getString("nombre_producto"));
                venta.setNombreCliente(rs.getString("nombre_cli"));
                venta.setFecha(rs.getString("fecha"));
                venta.setTotal(rs.getString("total"));
                listaVentas.add(venta);
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listaVentas;
    }

    public static List<DespachoDTO> getDespacho(Connection conn) {
         List<DespachoDTO> listaDespachos = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        DespachoDTO despacho = null;
        try {
            
            String sql = "select d.id_despacho, v.fecha, p.nombre_producto, c.nombre_cli, d.valor_desp, v.total\n" +
                    "from despacho d,\n" +
                    "     cliente c,\n" +
                    "     producto p,\n" +
                    "     ventas v\n" +
                    "where d.id_cliente = c.id_cliente\n" +
                    "  and d.id_producto = p.id_producto\n" +
                    "  and c.id_cliente = v.id_cliente and d.id_despacho = v.id_despacho";
            
            ps = conn.prepareStatement(sql);
            System.out.println("SQL: "+sql);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                despacho = new DespachoDTO();
                despacho.setIdDespacho(rs.getString("id_despacho"));
                despacho.setNombreProducto(rs.getString("nombre_producto"));
                despacho.setNombreCliente(rs.getString("nombre_cli"));
                despacho.setFecha(rs.getString("fecha"));
                despacho.setTotal(rs.getString("total"));
                despacho.setValorDespacho(rs.getString("valor_desp"));
                listaDespachos.add(despacho);
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listaDespachos;
    }

    public static List<BodegaDTO> getBodega(Connection conn) {
        List<BodegaDTO> listaDespachos = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        BodegaDTO despacho = null;
        try {
            
            String sql = "select id_bodega, nombre_bodega, estado_bodega from bodega";
            
            ps = conn.prepareStatement(sql);
            System.out.println("SQL: "+sql);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                despacho = new BodegaDTO();
                despacho.setEstado(rs.getString("estado_bodega"));
                despacho.setIdBodega(rs.getString("id_bodega"));
                despacho.setNombre(rs.getString("nombre_bodega"));
                listaDespachos.add(despacho);
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listaDespachos;
    }

    public static void eliminarBodega(Connection conn, BodegaDTO bodega) {
        PreparedStatement ps = null;
        try {
            
            String sql = "delete from bodega where id_bodega = ?";
            
            ps = conn.prepareStatement(sql);
            System.out.println("SQL: "+sql);
            ps.setString(1, bodega.getIdBodega());
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void actualizarBodega(Connection conn, BodegaDTO bodega) {
        PreparedStatement ps = null;
        try {
            
            String sql = "UPDATE bodega SET NOMBRE_BODEGA = ?, ESTADO_BODEGA = ? where id_bodega = ?";
            
            ps = conn.prepareStatement(sql);
            System.out.println("SQL: "+sql);
            ps.setString(1, bodega.getNombre());
            ps.setString(2, bodega.getEstado());
            ps.setString(3, bodega.getIdBodega());
            int executeUpdate = ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertarBodega(Connection conn, BodegaDTO bodega) {
        PreparedStatement ps = null;
        Random random = new Random();
        try {
            
            String sql = "insert into bodega (NOMBRE_BODEGA, ESTADO_BODEGA, id_bodega) values(?,?,?)";
            
            ps = conn.prepareStatement(sql);
            System.out.println("SQL: "+sql);
            ps.setString(1, bodega.getNombre());
            ps.setString(2, "ACTIVO");
            ps.setString(3, String.valueOf(random.nextInt(100)));
            int respuesta;
            respuesta = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void ingresarVenta(Connection conn, VentasDTO venta) {
        PreparedStatement ps = null;
        Random random = new Random();
        try {
            
            String sql = "insert into ventas (id_ventas, id_producto, id_cliente, id_despacho, tipo_comprobante, fecha, total) "
                    + " values(?,?,?, ?, ?, sysdate(), ?)";
            
            ps = conn.prepareStatement(sql);
            System.out.println("SQL: "+sql);
            venta.setIdVenta(String.valueOf(random.nextInt(100)));
            ps.setString(1, venta.getIdVenta());
            ps.setString(2, venta.getIdProducto());
            ps.setString(3, venta.getIdCliente());
            venta.setIdDespacho(null);
            if(venta.getTipoRetiro().equals("DOMICILIO")){
                venta.setIdDespacho(String.valueOf(random.nextInt(100)));
            }
            ps.setString(4, venta.getIdDespacho());
            ps.setString(5, venta.getTipoComprobante());
            ps.setString(6, venta.getTotal());
            
            int respuesta;
            respuesta = ps.executeUpdate();
            
            
            sql = "insert into despacho (id_despacho, id_producto, id_cliente, valor_desp, descripcion_desp) "
                    + " values(?,?,?, '2600', 'No hay descripcion para el despacho')";
            
            ps = conn.prepareStatement(sql);
            System.out.println("SQL: "+sql);
            venta.setIdVenta(String.valueOf(random.nextInt(100)));
            ps.setString(1, venta.getIdDespacho());
            ps.setString(2, venta.getIdProducto());
            ps.setString(3, venta.getIdCliente());
            
            respuesta = ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
