/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.ventas_programa06cc;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author irvin
 */
public class Ventas_Programa05CC {

    public static void main(String[] args) {
        DAOVenta daoventa = new DAOVenta();
        DAODetalleVenta daodetalle = new DAODetalleVenta();
        DetalleVenta detalle = new DetalleVenta();
        Venta venta = null;

        detalle.setDescripcion("Coquitas de 600 Uwu");
        detalle.setCantidad(6L);
        detalle.setPrecio(22L);
        detalle.setSubtotal((Long) detalle.getPrecio() * detalle.getCantidad());
        detalle.setVentaID(2L);
        detalle.setClave(9L);

        daodetalle.create(detalle);

   

//        List<Venta> lstemp = daoventa.findAll();
//
//        for (Venta venta1 : lstemp) {
//            Logger.getLogger(Ventas_Programa05CC.class.getName()).log(Level.INFO, "Clave: {0}", String.valueOf(venta1.getClave()));
//            Logger.getLogger(Ventas_Programa05CC.class.getName()).log(Level.INFO, "Descripcion: {0}", venta1.getFecha());
//            Logger.getLogger(Ventas_Programa05CC.class.getName()).log(Level.INFO, "Precio: {0}", venta1.getMonto());
//        }
//        List<DetalleVenta> lstemp= daodetalle.findAll();
//        
//        for (DetalleVenta detalle1 : lstemp) {
//            Logger.getLogger(Ventas_Programa05CC.class.getName()).log(Level.INFO, "Clave: {0}", String.valueOf(detalle1.getClave()));
//            Logger.getLogger(Ventas_Programa05CC.class.getName()).log(Level.INFO, "Descripcion: {0}", detalle1.getDescripcion());
//            Logger.getLogger(Ventas_Programa05CC.class.getName()).log(Level.INFO, "Precio: {0}", detalle1.getPrecio());
//            Logger.getLogger(Ventas_Programa05CC.class.getName()).log(Level.INFO, "Cantidad: {0}" , detalle1.getCantidad());
//            Logger.getLogger(Ventas_Programa05CC.class.getName()).log(Level.INFO, "Subtotal: {0}", detalle1.getSubtotal());
//            Logger.getLogger(Ventas_Programa05CC.class.getName()).log(Level.INFO, "Venta ID: {0}", detalle1.getVentaID());
//        }
    }
}
