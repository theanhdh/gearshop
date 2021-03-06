/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gearshop.daf;

import gearshop.HibernateUtil;
import gearshop.domain.Unit;
import java.util.List;
import java.util.function.Supplier;
import org.hibernate.StatelessSession;

/**
 *
 * @author theanhha
 */
public class GetUnits implements Supplier<List<Unit>> {

    @Override
    public List<Unit> get() {
        StatelessSession session = HibernateUtil.getSessionFactory().openStatelessSession();
        List<Unit> units = (List<Unit>) session.createQuery("from Unit").list();
        session.close();
        return units;
    }
    
}
