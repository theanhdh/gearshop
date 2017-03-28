/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gearshop.ui.model;

import gearshop.domain.Customer;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author theanhduongha
 */
public class CustomerTableModel extends AbstractTableModel {
    
    private List<Customer> customers;
    
    public CustomerTableModel(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public int getRowCount() {
        return this.customers.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Customer customer = this.customers.get(rowIndex);
        if ("WHOLESALE".equals(customer.getCustomerType())) {
            return customer.getCompany();
        } else if ("RETAIL".equals(customer.getCustomerType())) {
            return customer.getFirstName() + " " + customer.getLastName();
        }
        return null;
    }
    
    public Customer getObjectAt(int rowIndex) {
        return this.customers.get(rowIndex);
    }
}
