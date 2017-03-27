/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gearshop.daf;

import gearshop.HibernateUtil;
import gearshop.domain.Product;
import gearshop.domain.Unit;
import java.util.List;
import java.util.function.Function;
import org.hibernate.StatelessSession;

/**
 *
 * @author theanhha
 */
public class GetProductOfUnit implements Function<Unit, Product> {

    @Override
    public Product apply(Unit unit) {
        StatelessSession session = HibernateUtil.getSessionFactory().openStatelessSession();
        List<Product> products = (List<Product>) session.createQuery("from Product where id = " + unit.getProductId()).list();
        session.close();
        if (products.size() > 0) {
            return products.get(0);
        }
        
        return null;
    }
    
}
