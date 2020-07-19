/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.placeholder.PlaceHolder;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.DevolucionEntrada;
import persistencia.ArticuloJpaController;
import persistencia.DevolucionEntradaJpaController;
import persistencia.EntradaJpaController;

/**
 *
 * @author llStiven
 */
public class ConsultaDevolucionEntrada extends javax.swing.JFrame {

    public DevolucionEntradaJpaController devolucionEntradaDAO = new DevolucionEntradaJpaController();
    public ArticuloJpaController articuloDAO = new ArticuloJpaController();
    public EntradaJpaController EntradaDAO = new EntradaJpaController();
    
    PlaceHolder holder;

    /**
     * Creates new form ConsultaDevolucionEntrada
     */
    public ConsultaDevolucionEntrada() {
        initComponents();
        setLocationRelativeTo(null);
        holder = new PlaceHolder(jTextFieldBuscar, "Ingrese # de la órden");

    }

    /**************************************************************************/
    public void tablaTodos(){
            List<DevolucionEntrada> devEntrada = devolucionEntradaDAO.findDevolucionEntradaEntities();
            DefaultTableModel modelo = new DefaultTableModel();
            
                modelo.addColumn("Articulo");
                modelo.addColumn("ID Devolución");
                modelo.addColumn("ID Entrada");
                modelo.addColumn("Fecha Devolución");
                modelo.addColumn("Cantidad");
                String[] datos = new String[5];
                
                for (DevolucionEntrada e : devEntrada) {
                    datos[0] = e.getIdEntrada().getIdArticulo().getNombreArticulo();
                    datos[1] = e.getIdDevolucionEntrada().toString();
                    datos[2] = e.getIdEntrada().getIdEntrada().toString();
                    datos[3] = e.getFechaDevEntrada().toString();
                    datos[4] = Integer.toString (e.getCantidadDevEntrada());
                    
                    modelo.addRow(datos);
                }
                
                jTable.setModel(modelo); 
    }
    /**************************************************************************/
    
    /**************************************************************************/
    public void tablaBuscar(){
        List<DevolucionEntrada> devEntrada = devolucionEntradaDAO.findDevolucionEntradaEntities();
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Articulo");
        modelo.addColumn("ID Devolución");
        modelo.addColumn("ID Entrada");
        modelo.addColumn("Fecha Devolución");
        modelo.addColumn("Cantidad");
        String[] datos = new String[5];
        
        if ("".equals(jTextFieldBuscar.getText())) {
            JOptionPane.showMessageDialog(null, "El campo está vacio");
        }else{
            for (DevolucionEntrada e: devEntrada){
            if (e.getIdEntrada().getIdEntrada() == Integer.parseInt(jTextFieldBuscar.getText())) {
                datos[0] = e.getIdEntrada().getIdArticulo().getNombreArticulo();
                datos[1] = e.getIdDevolucionEntrada().toString();
                datos[2] = e.getIdEntrada().getIdEntrada().toString();
                datos[3] = e.getFechaDevEntrada().toString();
                datos[4] = Integer.toString (e.getCantidadDevEntrada());
                modelo.addRow(datos);
                }   
            }
            jTable.setModel(modelo); 
        }
    }
    /**************************************************************************/
        
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jButtonCancelar = new javax.swing.JButton();
        jButtonConsultar = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jTextFieldBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jButtonBack = new javax.swing.JButton();
        jButtonTest = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(680, 380));
        setMinimumSize(new java.awt.Dimension(680, 380));
        setPreferredSize(new java.awt.Dimension(680, 340));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CONSULTA DEVOLUCIÓN ENTRADA");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 120, 40));

        jButtonConsultar.setText("Consultar Todo");
        jButtonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 120, 40));

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 80, 40));

        jTextFieldBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 170, 40));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("ID Entrada:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 100, 40));

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Articulo", "ID Devolucion", "ID Entrada", "Fecha", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(1).setResizable(false);
            jTable.getColumnModel().getColumn(2).setResizable(false);
            jTable.getColumnModel().getColumn(3).setResizable(false);
            jTable.getColumnModel().getColumn(4).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 680, 200));

        jButtonBack.setText("Volver");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 80, 30));
        getContentPane().add(jButtonTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, 40, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarActionPerformed
        tablaTodos();
    }//GEN-LAST:event_jButtonConsultarActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        try {
           
            if (Integer.parseInt(jTextFieldBuscar.getText()) <= 0) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un ID o número de órden válido.");
                jTextFieldBuscar.setText("");
            } else {
                tablaBuscar();
            }
            
        } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(null, e.getMessage());
            JOptionPane.showMessageDialog(null, "Debe ingresar un ID o número de órden válido.");
            jTextFieldBuscar.setText("");
            
            System.out.println(e.getMessage());
        }
        

    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        // TODO add your handling code here:
        MenuSistema menu = new MenuSistema();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jTextFieldBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBuscarActionPerformed
        // TODO add your handling code here:
         if ("".equals(jTextFieldBuscar.getText())) {
                jButtonBack.setEnabled(false);
            }
    }//GEN-LAST:event_jTextFieldBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultaDevolucionEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaDevolucionEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaDevolucionEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaDevolucionEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaDevolucionEntrada().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConsultar;
    private javax.swing.JButton jButtonTest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextFieldBuscar;
    // End of variables declaration//GEN-END:variables
}
