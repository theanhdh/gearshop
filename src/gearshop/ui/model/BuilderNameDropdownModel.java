/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gearshop.ui.model;

import gearshop.domain.Builder;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author theanhha
 */
public class BuilderNameDropdownModel<String> extends DefaultComboBoxModel<String> {

        private final List<Builder> builders;

        public BuilderNameDropdownModel(List<Builder> builders) {
            super((String[]) builders.stream().map(p -> p.getName()).collect(Collectors.toList()).toArray());
            this.builders = builders;
        }

        @Override
        public String getElementAt(int index) {
            return super.getElementAt(index);
        }
        
        @Override
        public Object getSelectedItem() {
            return super.getSelectedItem();
        }

        public Builder getSelectedBuilder() {
            String value = (String) super.getSelectedItem();
            return this.builders.stream().filter(p -> p.getName().equals(value)).findFirst().get();
        }

    }