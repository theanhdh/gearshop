/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gearshop.ui;

import gearshop.Callbacks;
import gearshop.HibernateUtil;
import gearshop.daf.GetHistoryOfUnit;
import gearshop.daf.GetUnitsForProduct;
import gearshop.domain.Product;
import gearshop.domain.Unit;
import gearshop.domain.UnitHist;
import gearshop.ui.model.UnitHistoryTableModel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;
import org.hibernate.Query;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

/**
 *
 * @author theanhha
 */
public class Products extends javax.swing.JPanel {

    private Product currentProduct;
    private List<Product> existingProducts;
    
    private Function<Product, List<Unit>> getUnitsForProduct = new GetUnitsForProduct();
    private GetHistoryOfUnit getHistoryOfUnit = new GetHistoryOfUnit();
    
    /**
     * Creates new form Products
     */
    public Products() {
        initComponents();
        
        // Register preload callback function
        Callbacks.PRODUCT_PRELOAD_CALLBACK = () -> {
            System.out.println("Loading existing products...");
            loadExistingProducts();
            return null;
        };
        
        // Register actions for nav buttons
        this.navButtons.setFirstAction(() -> {
            this.productListTable.setRowSelectionInterval(0, 0);
            this.currentProduct = ((ProductTableModel) productListTable.getModel()).getObjectAt(0);
            this.showProductDetails();
            return null;
        });
        
        this.navButtons.setPreviousAction(() -> {
            int index = productListTable.getSelectedRow() - 1;
            if (index >= 0) {
                this.productListTable.setRowSelectionInterval(index, index);
                this.currentProduct = ((ProductTableModel) productListTable.getModel()).getObjectAt(index);
                this.showProductDetails();
            }
            return null;
        });
        
        this.navButtons.setNextAction(() -> {
            int index = productListTable.getSelectedRow() + 1;
            if (index < this.productListTable.getRowCount()) {
                this.productListTable.setRowSelectionInterval(index, index);
                this.currentProduct = ((ProductTableModel) productListTable.getModel()).getObjectAt(index);
                this.showProductDetails();
            }
            return null;
        });
        
        this.navButtons.setLastAction(() -> {
            int index = productListTable.getRowCount() - 1;
            this.productListTable.setRowSelectionInterval(index, index);
            this.currentProduct = ((ProductTableModel) productListTable.getModel()).getObjectAt(index);
            this.showProductDetails();
            return null;
        });        
    }
    
    private void save() {
        if (currentProduct == null) {
            currentProduct = new Product();
        }
        
        // Populate values from the screen input fields
        currentProduct.setPartNbr(partNumberTextField.getText());
        currentProduct.setDescription(descriptionTextField.getText());
        currentProduct.setPrice(new BigDecimal(priceTextField.getText()));
        currentProduct.setWeight(new BigDecimal(weightTextField.getText()));
        currentProduct.setUpc(upcTextField.getText());
        
        // TODO: Perform validation
        
        // Insert into the database
        StatelessSession session = HibernateUtil.getSessionFactory().openStatelessSession();
        Transaction tx = session.beginTransaction();
        if (currentProduct.getId() == null) {
            currentProduct.setCreatedDtm(Calendar.getInstance().getTime());
            currentProduct.setLastModifiedDtm(Calendar.getInstance().getTime());
            currentProduct.setInventory(0);
            session.insert(currentProduct);
        } else { 
            currentProduct.setLastModifiedDtm(Calendar.getInstance().getTime());
            session.update(currentProduct);
        }
        tx.commit();
        session.close();
        
        // Reload all products
        this.loadExistingProducts();
        
        // reset
        this.reset();
    }
    
    private void reset() {
        currentProduct = null;
        partNumberTextField.setText("");
        descriptionTextField.setText("");
        priceTextField.setText("");
        weightTextField.setText("");
        upcTextField.setText("");
    }
    
    private void showProductDetails() {

        // Populate the product details panel
        partNumberTextField.setText(currentProduct.getPartNbr());
        descriptionTextField.setText(currentProduct.getDescription());
        priceTextField.setText(currentProduct.getPrice().toString());
        inventoryTextField.setText(currentProduct.getInventory().toString());
        weightTextField.setText(currentProduct.getWeight().toString());
        upcTextField.setText(currentProduct.getUpc());

        // Determine the inventory value
        // This value excludes any units that have already been sold (has an invoice id)
        List<Unit> units = getUnitsForProduct.apply(currentProduct)
                .stream()
                .filter(p -> p.getInvoiceId() == null)
                .collect(Collectors.toList());
        inventoryTextField.setText(String.valueOf(units.size()));

        // Grab all the "CREATED" events of all the units
        List<UnitHist> hists = units.stream()
                .map(getHistoryOfUnit)
                .flatMap(v -> v.stream())
                .filter(h -> h.getEvent().equals("CREATED"))
                .collect(Collectors.toList());
        unitHistoryTable.setModel(new UnitHistoryTableModel(hists));
        unitHistoryTable.getTableHeader().getColumnModel().getColumn(0).setHeaderValue("Unit History");
    }
    
    private void loadExistingProducts() {
        SwingUtilities.invokeLater(() -> {
            StatelessSession session = HibernateUtil.getSessionFactory().openStatelessSession();
            Query query = session.createQuery("from Product");
            existingProducts = query.list();
            session.close();
            
            // Populate the product list table
            ProductTableModel productTableModel = new ProductTableModel(existingProducts);
            productListTable.setModel(productTableModel);
            productListTable.getTableHeader().getColumnModel().getColumn(0).setHeaderValue("Part Number");
            productListTable.addMouseListener(new MouseListener() {
                @Override
                public void mousePressed(MouseEvent e) {
                    currentProduct = ((ProductTableModel) productListTable.getModel()).getObjectAt(productListTable.getSelectedRow());
                    showProductDetails();
                }
                
                @Override
                public void mouseClicked(MouseEvent e) {
                }
                
                @Override
                public void mouseReleased(MouseEvent e) {
                }
                
                @Override
                public void mouseEntered(MouseEvent e) {
                }
                
                @Override
                public void mouseExited(MouseEvent e) {
                }
            });
        });
 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        newProductButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        productListTable = new javax.swing.JTable();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        partNumberTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        descriptionTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        priceTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        inventoryTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        weightTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        upcTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        unitHistoryTable = new javax.swing.JTable();
        navButtons = new gearshop.ui.NavButtonPannel();

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        newProductButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/1489530700_12_-_Plus.png"))); // NOI18N
        newProductButton.setText("New Product");
        newProductButton.setFocusable(false);
        newProductButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        newProductButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        newProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newProductButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(newProductButton);

        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/1489530509_save.png"))); // NOI18N
        saveButton.setText("       Save       ");
        saveButton.setFocusable(false);
        saveButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        saveButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(saveButton);

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Product List", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 18))); // NOI18N

        productListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Part Number"
            }
        ));
        jScrollPane1.setViewportView(productListTable);

        jLayeredPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jLayeredPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Product Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 18))); // NOI18N

        jLabel1.setText("Part Number:");

        jLabel2.setText("Description:");

        jLabel3.setText("Price:");

        jLabel4.setText("Inventory:");

        inventoryTextField.setEnabled(false);

        jLabel5.setText("Weight:");

        jLabel6.setText("UPC:");

        unitHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Unit History"
            }
        ));
        jScrollPane2.setViewportView(unitHistoryTable);

        jLayeredPane2.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(partNumberTextField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(descriptionTextField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(priceTextField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(inventoryTextField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(weightTextField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(upcTextField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(partNumberTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(priceTextField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descriptionTextField)
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addComponent(inventoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(weightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(upcTextField)))))
                .addContainerGap())
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(partNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(descriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(inventoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(weightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(upcTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(navButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLayeredPane2)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(navButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane1)
                    .addComponent(jLayeredPane2))
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        this.save();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void newProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProductButtonActionPerformed
        this.reset();
    }//GEN-LAST:event_newProductButtonActionPerformed

    class ProductTableModel extends AbstractTableModel {

        private final List<Product> products;
        
        public ProductTableModel(List<Product> products) {
            this.products = products;
        }
        
        @Override
        public int getRowCount() {
            return this.products.size();
        }

        @Override
        public int getColumnCount() {
            return 1;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return this.products.get(rowIndex).getPartNbr();
        }
        
        public Product getObjectAt(int rowIndex) {
            return this.products.get(rowIndex);
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField descriptionTextField;
    private javax.swing.JTextField inventoryTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private gearshop.ui.NavButtonPannel navButtons;
    private javax.swing.JButton newProductButton;
    private javax.swing.JTextField partNumberTextField;
    private javax.swing.JTextField priceTextField;
    private javax.swing.JTable productListTable;
    private javax.swing.JButton saveButton;
    private javax.swing.JTable unitHistoryTable;
    private javax.swing.JTextField upcTextField;
    private javax.swing.JTextField weightTextField;
    // End of variables declaration//GEN-END:variables
}
