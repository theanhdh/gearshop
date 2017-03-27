/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gearshop.ui.model;

import gearshop.domain.UnitHist;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author theanhha
 */
   public class UnitHistoryTableModel extends AbstractTableModel {

        private final List<UnitHist> unitHists;
        
        public UnitHistoryTableModel(List<UnitHist> unitHists) {
            this.unitHists = unitHists;
        }
        
        @Override
        public int getRowCount() {
            return this.unitHists.size();
        }

        @Override
        public int getColumnCount() {
            return 1;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return this.unitHists.get(rowIndex).getEventDesc();
        }
        
        public UnitHist getObjectAt(int rowIndex) {
            return this.unitHists.get(rowIndex);
        }
        
    }