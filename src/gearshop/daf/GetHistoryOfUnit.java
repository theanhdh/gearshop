/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gearshop.daf;

import gearshop.HibernateUtil;
import gearshop.domain.Unit;
import gearshop.domain.UnitHist;
import java.util.List;
import java.util.function.Function;
import org.hibernate.StatelessSession;

/**
 *
 * @author theanhha
 */
public class GetHistoryOfUnit implements Function<Unit, List<UnitHist>> {

    @Override
    public List<UnitHist> apply(Unit unit) {
        StatelessSession session = HibernateUtil.getSessionFactory().openStatelessSession();
        List<UnitHist> unitHists = (List<UnitHist>) session.createQuery("from UnitHist where unitId = " + unit.getId()).list();
        session.close();
        return unitHists;
    }
    
}
