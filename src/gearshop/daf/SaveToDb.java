/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gearshop.daf;

import gearshop.HibernateUtil;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.function.Consumer;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

/**
 *
 * @author theanhha
 */
public class SaveToDb<T> implements Consumer<T>{

    @Override
    public void accept(T t) {
        StatelessSession session = HibernateUtil.getSessionFactory().openStatelessSession();
        Transaction tx = session.beginTransaction();
        
        try {
            Field idField = t.getClass().getDeclaredField("id");
            Field lastUpdtDtmField = t.getClass().getDeclaredField("lastUpdtDtm");
            Field createdDtmField = t.getClass().getDeclaredField("createdDtm");
                    
            idField.setAccessible(true);
            lastUpdtDtmField.setAccessible(true);
            createdDtmField.setAccessible(true);
            
            Object id = idField.get(t);
            
            if (id == null) {
                createdDtmField.set(t, Calendar.getInstance().getTime());
                lastUpdtDtmField.set(t, Calendar.getInstance().getTime());
                session.insert(t);
            } else {
                lastUpdtDtmField.set(t, Calendar.getInstance().getTime());
                session.update(t);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        tx.commit();
        session.close();
    }
    
}
