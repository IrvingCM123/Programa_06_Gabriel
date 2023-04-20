/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ventas_programa06cc;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author irvin
 */
public class DAOVenta implements IDAOGeneral<Venta, Long> {

    @Override
    public Venta create(Venta p) {

        try ( Session session = HibernateUtil.getSession()) {

            Transaction t = session.beginTransaction();

            session.save(p);

            Logger.getLogger(DAOVenta.class.getName()).log(Level.INFO, "Se guardó Empleado");

            t.commit();
            session.close();

        } catch (HibernateException ex) {
            Logger.getLogger(DAOVenta.class.getName());

        }
        return p;
    }

    @Override
    public boolean delete(Long id) {

        boolean b = false;

        Venta empleadoo = findByID(id);

        try ( Session session = HibernateUtil.getSession()) {

            Transaction t = session.beginTransaction();

            if (empleadoo != null) {
                session.delete(empleadoo);
                Logger.getLogger(DAOVenta.class.getName()).log(Level.INFO, "Se elimino Empleado");
                b = true;
            }

        } catch (HibernateException ex) {
            Logger.getLogger(DAOVenta.class.getName());
        }

        return b;
    }

    @Override
    public Venta update(Long id, Venta p) {

        Venta venta = null;

        try ( Session session = HibernateUtil.getSession()) {

            Transaction t = session.beginTransaction();
            venta = findByID(id);
            if (venta != null && p.getClave() == id) {
                session.update(p);
            }
            t.commit();
            session.close();

        } catch (HibernateException ex) {
            Logger.getLogger(DAOVenta.class.getName());
        }

        return p;

    }

    @Override
    public List<Venta> findAll() {
        List<Venta> ventas = null;
        try ( Session session = HibernateUtil.getSession()) {
            Transaction t = session.beginTransaction();

            ventas = session.createQuery("from Venta", Venta.class).list();
            t.commit();

            session.close();

        } catch (HibernateException ex) {
            Logger.getLogger(DAOVenta.class.getName());
        }
        return ventas;
    }

    @Override
    public Venta findByID(Long id) {
        Venta venta = null;
        List obj;

        try ( Session session = HibernateUtil.getSession()) {
            Transaction t = session.beginTransaction();

            venta = session.get(Venta.class, id);
            //obj = session.createQuery("from Venta v inner join DetalleVenta vd on v.clave = vd.ventaID").list();

            t.commit();
            session.close();

        } catch (HibernateException ex) {
            Logger.getLogger(DAOVenta.class.getName());
        }

        return venta;

    }
}
