/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;

import javax.swing.table.DefaultTableModel;
import classes.*;

/**
 *
 * @author alumne
 */
public class jframe_principal extends javax.swing.JFrame {

    public static LlistaIncidencies li;
    /**
     * Creates new form jframe_principal
     */
    public jframe_principal(LlistaIncidencies li) {
        initComponents();
        this.li = li;
        setLocationRelativeTo(null);
        
        emplenarTaula();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        ButtonCrearIncidencia = new javax.swing.JButton();
        Button_Esborrar = new javax.swing.JButton();
        TextField_Filter = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 500));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        jLabel1.setText("Gestió Incidències");

        ButtonCrearIncidencia.setText("Crear Incidència");
        ButtonCrearIncidencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCrearIncidenciaActionPerformed(evt);
            }
        });

        Button_Esborrar.setText("Esborrar Seleccionat");
        Button_Esborrar.setToolTipText("Selecciona una incidència en la taula i prem el botó per esborrar");
        Button_Esborrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_EsborrarActionPerformed(evt);
            }
        });

        TextField_Filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_FilterActionPerformed(evt);
            }
        });
        TextField_Filter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextField_FilterKeyTyped(evt);
            }
        });

        jLabel2.setText("Búsqueda:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(ButtonCrearIncidencia)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Button_Esborrar)
                            .addGap(28, 28, 28)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TextField_Filter, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonCrearIncidencia)
                    .addComponent(Button_Esborrar)
                    .addComponent(TextField_Filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonCrearIncidenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCrearIncidenciaActionPerformed
        dispose();
        jframe_CrearIncidencia j = new jframe_CrearIncidencia(li);
        j.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonCrearIncidenciaActionPerformed

    private void Button_EsborrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_EsborrarActionPerformed
        int id = (int) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
        LlistaIncidencies.eliminarJframe(id);
        emplenarTaula();
    }//GEN-LAST:event_Button_EsborrarActionPerformed

    private void TextField_FilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_FilterActionPerformed
        
    }//GEN-LAST:event_TextField_FilterActionPerformed

    private void TextField_FilterKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextField_FilterKeyTyped
        consulta(TextField_Filter.getText());
    }//GEN-LAST:event_TextField_FilterKeyTyped

    // METODES
    public void consulta(String filter) {
        
        Object columnNames[] = {"ID", "Concern", "Description", "Status", "Priority", "Data Creació", "Data Resolució", "Usuari Assignat", "Autor", "Entitat"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        
        for (int i = 0; i < LlistaIncidencies.incidenciesTotals; i++) {
            Incidencia e = li.returnList()[i];
            String x = e.toString(e);
            
            if (x.toLowerCase().contains(filter.toLowerCase())) {
                Object rowData[] = {e.getId(), e.getConcern(), e.getDescription(), e.getStatus(), e.getPriority(), e.getCreation_date(), e.getSolved_date(), e.getAssigned_user(), e.getAuthor(), e.getEntity()};
                model.addRow(rowData);
            }  
        }
        jTable1.setModel(model);
        
    }
    public void emplenarTaula() {
        Object columnNames[] = {"ID", "Concern", "Description", "Status", "Priority", "Data Creació", "Data Resolució", "Usuari Assignat", "Autor", "Entitat"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        
        for (int i = 0; i < LlistaIncidencies.incidenciesTotals; i++) {
            
            Incidencia e = li.returnList()[i];
            Object rowData[] = {e.getId(), e.getConcern(), e.getDescription(), e.getStatus(), e.getPriority(), e.getCreation_date(), e.getSolved_date(), e.getAssigned_user(), e.getAuthor(), e.getEntity() };
            model.addRow(rowData);
        }
        jTable1.setModel(model);
    }   
    
    
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
            java.util.logging.Logger.getLogger(jframe_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jframe_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jframe_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jframe_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jframe_principal(li).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonCrearIncidencia;
    private javax.swing.JButton Button_Esborrar;
    private javax.swing.JTextField TextField_Filter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
