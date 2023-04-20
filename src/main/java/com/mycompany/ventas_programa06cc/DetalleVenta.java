/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ventas_programa06cc;

/**
 *
 * @author irvin
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ventadetalle")

public class DetalleVenta {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clave_producto")
    private long clave;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio")
    private long precio;

    @Column(name = "cantidad")
    private long cantidad;

    @Column(name = "subtotal")
    private long subtotal;

    @Column(name = "idventa")
    private long ventaID;

    public long getVentaID() {
        return ventaID;
    }

    public void setVentaID(long ventaID) {
        this.ventaID = ventaID;
    }

    public long getClave() {
        return clave;
    }

    public void setClave(long clave) {
        this.clave = clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public long getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(long subtotal) {
        this.subtotal = subtotal;
    }

}
