/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gearshop.ui;

import gearshop.Callbacks;
import java.awt.Insets;
import javax.swing.UIManager;
import org.pushingpixels.substance.api.skin.SubstanceBusinessLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceGeminiLookAndFeel;

/**
 *
 * @author theanhha
 */
public class MainWindow extends javax.swing.JFrame {

    private int currentTabIndex = -1;
    
    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        tabPanel = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        invoicesPanel1 = new gearshop.ui.InvoicesPanel();
        jPanel2 = new javax.swing.JPanel();
        customersPanel1 = new gearshop.ui.CustomersPanel();
        jPanel3 = new javax.swing.JPanel();
        products1 = new gearshop.ui.Products();
        jPanel4 = new javax.swing.JPanel();
        unitsPanel1 = new gearshop.ui.UnitsPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        builderPanel1 = new gearshop.ui.BuilderPanel();
        jPanel8 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        tabPanel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        tabPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabPanelMousePressed(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));
        jPanel1.add(invoicesPanel1);

        tabPanel.addTab("Invoices", jPanel1);

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));
        jPanel2.add(customersPanel1);

        tabPanel.addTab("Customers", jPanel2);

        jPanel3.setLayout(new java.awt.GridLayout(1, 0));
        jPanel3.add(products1);

        tabPanel.addTab("Products", jPanel3);

        jPanel4.setLayout(new java.awt.GridLayout());
        jPanel4.add(unitsPanel1);

        tabPanel.addTab("Units", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1079, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1060, Short.MAX_VALUE)
        );

        tabPanel.addTab("ID", jPanel5);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1079, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1060, Short.MAX_VALUE)
        );

        tabPanel.addTab("CB", jPanel6);

        jPanel7.setLayout(new java.awt.GridLayout(1, 0));
        jPanel7.add(builderPanel1);

        tabPanel.addTab("Builder", jPanel7);

        jPanel8.setLayout(new java.awt.GridBagLayout());
        tabPanel.addTab("Register", jPanel8);

        getContentPane().add(tabPanel, "card2");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabPanelMousePressed
        if (tabPanel.getSelectedIndex() != this.currentTabIndex) { 
            this.currentTabIndex = tabPanel.getSelectedIndex();
            switch(tabPanel.getSelectedIndex()) {
                case 2: Callbacks.PRODUCT_PRELOAD_CALLBACK.get();
                case 3: Callbacks.UNITS_PREDLOAD_CALLBACK.get();
                case 6: Callbacks.BUILDERS_PRELOAD_CALLBACK.get();
            }
        }
        

        
        System.out.println(tabPanel.getSelectedIndex());
    }//GEN-LAST:event_tabPanelMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
//                    UIManager.setLookAndFeel(new SubstanceGeminiLookAndFeel());

                    UIManager.getLookAndFeelDefaults().put("TabbedPane:TabbedPaneTab.contentMargins", new Insets(30, 50, 0, 0));
                } catch (Exception e) {}
                MainWindow win = new MainWindow();
                win.setBounds(0, 0, 1024, 768);
//                win.setExtendedState(win.getExtendedState() | JFrame.MAXIMIZED_BOTH);
                win.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gearshop.ui.BuilderPanel builderPanel1;
    private gearshop.ui.CustomersPanel customersPanel1;
    private gearshop.ui.InvoicesPanel invoicesPanel1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private gearshop.ui.Products products1;
    private javax.swing.JTabbedPane tabPanel;
    private gearshop.ui.UnitsPanel unitsPanel1;
    // End of variables declaration//GEN-END:variables
}
