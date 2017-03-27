/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gearshop.ui.model;

import gearshop.domain.Product;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author theanhha
 */
public class PartNumberDropdownModel<String> extends DefaultComboBoxModel<String> {

        private final List<Product> products;

        public PartNumberDropdownModel(List<Product> products) {
            super((String[]) products.stream().map(p -> p.getPartNbr()).collect(Collectors.toList()).toArray());
            this.products = products;
        }

        @Override
        public String getElementAt(int index) {
            return super.getElementAt(index);
        }
        
        @Override
        public Object getSelectedItem() {
            return super.getSelectedItem();
        }

        public Product getSelectedProduct() {
            String value = (String) super.getSelectedItem();
            return this.products.stream().filter(p -> p.getPartNbr().equals(value)).findFirst().get();
        }

    }