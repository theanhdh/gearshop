/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gearshop;

import gearshop.domain.Customer;
import java.util.Calendar;
import org.hibernate.Session;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

/**
 *
 * @author theanhha
 */
public class Gearshop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hello world");
        
        StatelessSession session = HibernateUtil.getSessionFactory().openStatelessSession();
        Customer c = new Customer();
        c.setFirstName("theanh");
        c.setLastName("ha");
        c.setLastUpdtDtm(Calendar.getInstance().getTime());
        c.setCreatedDtm(Calendar.getInstance().getTime());
        Transaction tx = session.beginTransaction();
        session.insert(c);
        tx.commit();
        session.close();
        
        System.out.println("Done!");
    }
    
}
