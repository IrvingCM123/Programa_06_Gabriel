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
public class Programa06CC {

    public static void main(String[] args) {
        DAODetalleVenta daodetalle = new DAODetalleVenta();
        DetalleVenta detalle = new DetalleVenta();
        detalle.setDescripcion("Coquitas de 600 Uwu");
        detalle.setCantidad(6L);
        detalle.setPrecio(22L);
        detalle.setSubtotal((Long) detalle.getPrecio() * detalle.getCantidad());
        detalle.setVentaID(2L);
        detalle.setClave(10L);

        daodetalle.create(detalle);

    }
}
