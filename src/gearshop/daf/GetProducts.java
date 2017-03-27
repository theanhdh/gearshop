/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gearshop.daf;

import gearshop.HibernateUtil;
import gearshop.domain.Product;
import java.util.List;
import java.util.function.Supplier;
import org.hibernate.StatelessSession;

/**
 *
 * @author theanhha
 */
public class GetProducts implements Supplier<List<Product>> {

    @Override
    public List<Product> get() {
        StatelessSession session = HibernateUtil.getSessionFactory().openStatelessSession();
        List<Product> products = (List<Product>) session.createQuery("from Product").list();
        session.close();
        return products;
    }
    
}
