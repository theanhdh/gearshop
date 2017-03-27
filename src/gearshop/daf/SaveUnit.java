/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gearshop.daf;

import gearshop.HibernateUtil;
import gearshop.domain.Unit;
import gearshop.domain.UnitHist;
import java.util.Calendar;
import java.util.function.Consumer;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

/**
 *
 * @author theanhha
 */
public class SaveUnit implements Consumer<Unit>{

    @Override
    public void accept(Unit unit) {
        StatelessSession session = HibernateUtil.getSessionFactory().openStatelessSession();
        Transaction tx = session.beginTransaction();
        if (unit.getId() == null) {
            unit.setCreatedDtm(Calendar.getInstance().getTime());
            unit.setLastUpdtDtm(Calendar.getInstance().getTime());
            session.insert(unit);
            
            // Add creation event
            UnitHist hist = new UnitHist();
            hist.setUnitId(unit.getId());
            hist.setEvent("CREATED");
            hist.setEventDesc("Unit " + unit.getSerialNbr() + " added to inventory");
            hist.setCreatedDtm(Calendar.getInstance().getTime());
            hist.setLastUpdtDtm(Calendar.getInstance().getTime());
            session.insert(hist);
            
        } else {
            unit.setLastUpdtDtm(Calendar.getInstance().getTime());
            session.update(unit);
        }
        tx.commit();
        session.close();
    }
}
