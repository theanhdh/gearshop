/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gearshop.daf;

import gearshop.HibernateUtil;
import java.util.List;
import java.util.function.Function;
import org.hibernate.StatelessSession;

/**
 *
 * @author theanhduongha
 */
public class SelectFromDb<T> implements Function<String, List<T>> {

    @Override
    public List<T> apply(String query) {
        StatelessSession session = HibernateUtil.getSessionFactory().openStatelessSession();
        List<T> results = (List<T>) session.createQuery(query).list();
        session.close();
        return results;
    }
    
}
