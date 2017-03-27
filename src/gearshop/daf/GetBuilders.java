/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gearshop.daf;

import gearshop.HibernateUtil;
import gearshop.domain.Builder;
import java.util.List;
import java.util.function.Supplier;
import org.hibernate.StatelessSession;

/**
 *
 * @author theanhha
 */
public class GetBuilders implements Supplier<List<Builder>> {

    @Override
    public List<Builder> get() {
        StatelessSession session = HibernateUtil.getSessionFactory().openStatelessSession();
        List<Builder> builders = session.createQuery("from Builder").list();
        session.close();
        return builders;
    }
    
}
