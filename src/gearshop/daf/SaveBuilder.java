/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gearshop.daf;

import gearshop.HibernateUtil;
import gearshop.domain.Builder;
import java.util.Calendar;
import java.util.function.Consumer;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

/**
 *
 * @author theanhha
 */
public class SaveBuilder implements Consumer<Builder>{

    @Override
    public void accept(Builder builder) {
        StatelessSession session = HibernateUtil.getSessionFactory().openStatelessSession();
        Transaction tx = session.beginTransaction();
        if (builder.getId() == null) {
            builder.setCreatedDtm(Calendar.getInstance().getTime());
            builder.setLastModifiedDtm(Calendar.getInstance().getTime());
            session.insert(builder);
        } else {
            builder.setLastModifiedDtm(Calendar.getInstance().getTime());
            session.update(builder);
        }
        tx.commit();
        session.close();
    }
    
}
