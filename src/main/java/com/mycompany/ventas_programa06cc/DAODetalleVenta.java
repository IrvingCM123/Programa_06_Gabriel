/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */ 
package com.mycompany.ventas_programa06cc;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author irving
 */
public class DAODetalleVenta implements IDAOGeneral<DetalleVenta, Long> {

    DAOVenta daoventa = new DAOVenta();
    Venta venta = new Venta();

    @Override
    public DetalleVenta create(DetalleVenta p) {

        try ( Session session = HibernateUtil.getSession()) {

            Transaction t = session.beginTransaction();
            Venta obj = session.get(Venta.class, p.getVentaID());

            if (obj == null) {
                session.save(p);
            } else {
                venta.setFecha("04-12-2022");
                venta.setClave(p.getVentaID());
                venta.setMonto(((long) daoventa.findByID(p.getVentaID()).getMonto()) + p.getSubtotal());
                daoventa.update(venta.getClave(), venta);

                session.save(p);
            }

            Logger.getLogger(DAOVenta.class.getName()).log(Level.INFO, "Se guardó el detalle de venta");
            t.commit();
            session.close();

        } catch (HibernateException ex) {
            Logger.getLogger(DAOVenta.class.getName());

        }
        return p;
    }

    @Override
    public boolean delete(Long id) {
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        DetalleVenta obj = session.get(DetalleVenta.class, id);

        if (obj != null) {
            session.delete(obj);
            t.commit();
            session.close();
            return true;
        } else {
            t.rollback();
            session.close();
            return false;
        }
    }

    @Override
    public DetalleVenta update(Long id, DetalleVenta p) {
        try {
            DetalleVenta obj;
            try ( Session session = HibernateUtil.getSession()) {
                Transaction t = session.beginTransaction();
                obj = session.get(DetalleVenta.class, id);
                obj.setCantidad(p.getCantidad());
                obj.setDescripcion(p.getDescripcion());
                obj.setPrecio(p.getPrecio());
                obj.setSubtotal(p.getSubtotal());
                obj.setVentaID(p.getVentaID());
                session.update(obj);
                t.commit();
            }

            return obj;

        } catch (HibernateException ex) {
            Logger.getLogger(DAODetalleVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public List<DetalleVenta> findAll() {
        List<DetalleVenta> lstRes;
        try ( Session session = HibernateUtil.getSession()) {
            Transaction t = session.beginTransaction();
            lstRes = session.createQuery("from DetalleVenta", DetalleVenta.class).list();
            t.commit();
        }
        return lstRes;
    }

    @Override
    public DetalleVenta findByID(Long id) {
        DetalleVenta obj;
        try ( Session session = HibernateUtil.getSession()) {
            Transaction t = session.beginTransaction();
            obj = session.get(DetalleVenta.class, id);
            //get es para obtener un objeto referenciado, ya sea qu exista o sea null
            //load es para obtener en caché
            t.commit();
            session.close();

        }

        return obj;
    }

}
