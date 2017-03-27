/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gearshop.ui.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author theanhha
 */
   public class UnitTableModel extends AbstractTableModel {

        private final List<gearshop.domain.Unit> units;
        
        public UnitTableModel(List<gearshop.domain.Unit> units) {
            this.units = units;
        }
        
        @Override
        public int getRowCount() {
            return this.units.size();
        }

        @Override
        public int getColumnCount() {
            return 1;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return this.units.get(rowIndex).getSerialNbr();
        }
        
        public gearshop.domain.Unit getObjectAt(int rowIndex) {
            return this.units.get(rowIndex);
        }
        
    }