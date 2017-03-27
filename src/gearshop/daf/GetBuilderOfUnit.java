/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gearshop.daf;

import gearshop.HibernateUtil;
import gearshop.domain.Builder;
import gearshop.domain.Unit;
import java.util.List;
import java.util.function.Function;
import org.hibernate.StatelessSession;

/**
 *
 * @author theanhha
 */
public class GetBuilderOfUnit implements Function<Unit, Builder> {

    @Override
    public Builder apply(Unit unit) {
        StatelessSession session = HibernateUtil.getSessionFactory().openStatelessSession();
        List<Builder> builders = (List<Builder>) session.createQuery("from Builder where id = " + unit.getBuilderId()).list();
        session.close();
        if (builders.size() > 0) {
            return builders.get(0);
        }
        
        return null;
    }
    
}
