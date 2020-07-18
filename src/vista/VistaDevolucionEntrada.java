/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.placeholder.PlaceHolder;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import logica.DevolucionEntradaLogica;
import modelo.DevolucionEntrada;
import modelo.Entrada;
import persistencia.ArticuloJpaController;
import persistencia.DevolucionEntradaJpaController;
import persistencia.EntradaJpaController;

/**
 *
 * @author llStiven
 */
public class VistaDevolucionEntrada extends javax.swing.JFrame {

    /**************************************************************************/
    public DevolucionEntradaJpaController devolucionEntradaDAO =  new DevolucionEntradaJpaController();
    public EntradaJpaController entradaDAO = new EntradaJpaController();
    public DevolucionEntradaLogica devolucionEntradaLogica = new DevolucionEntradaLogica();
    public ArticuloJpaController articuloDAO = new ArticuloJpaController();
    PlaceHolder holder;
    PlaceHolder holder2;
    /**************************************************************************/
    
    
    
    /**
     * Creates new form VistaDevolucionEntrada
     */
    public VistaDevolucionEntrada() {
        initComponents();
        
    /**************************************************************************/
        setLocationRelativeTo(null);
        holder = new PlaceHolder(jTextFieldID, "Código de la entrada");
        holder2 = new PlaceHolder(jTextField_cantidadDev, "Número de unidades");
    /**************************************************************************/
    }
    /**
     * @param idEntrada*
     * @param cantidadDev*
     **************************************************************************/
    public void actualizarEntrada(String idEntrada, int cantidadDev){
        
        Entrada entrada = entradaDAO.findEntrada(Integer.parseInt(idEntrada));
        int cantidadActual = entrada.getCantidadArticulo();
        
        try {
            entrada.setCantidadArticulo(cantidadActual - cantidadDev);
            entradaDAO.edit(entrada);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    /**************************************************************************/

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabelProducto = new javax.swing.JLabel();
        jTextField_cantidadDev = new javax.swing.JTextField();
        jTextFieldID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton_confirmarDev = new javax.swing.JButton();
        jButton_cancelarDev = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jTextFieldTest = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(762, 364));
        setMinimumSize(new java.awt.Dimension(762, 364));
        setPreferredSize(new java.awt.Dimension(762, 364));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 22)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sistema de Devoluciones");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, -1));

        jLabelProducto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelProducto.setText("PRODUCTO:");
        jLabelProducto.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabelProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 150, 30));

        jTextField_cantidadDev.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_cantidadDev.setToolTipText("Ingrese la cantidad del producto que desea devolver");
        jTextField_cantidadDev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_cantidadDevActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_cantidadDev, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 170, 30));

        jTextFieldID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIDActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldID, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 170, 30));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("DEVOLUCIÓN:");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 160, 30));

        jButton_confirmarDev.setText("Confirmar");
        jButton_confirmarDev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_confirmarDevActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_confirmarDev, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, 180, 40));

        jButton_cancelarDev.setText("Cancelar");
        jButton_cancelarDev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelarDevActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_cancelarDev, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 180, 40));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 520, -1));

        jTextFieldTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTestActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 20, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_confirmarDevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_confirmarDevActionPerformed
    /**************************************************************************/
        String idEntrada;
        int cantidadDev, cantidadActual;
        try {

            if ("".equals(jTextFieldID.getText()) || "".equals(jTextField_cantidadDev.getText())) {
                JOptionPane.showMessageDialog(null, "Asegurese de llenar todos los campos");

            }else{
                DevolucionEntrada nuevaDevolucionEntrada = new DevolucionEntrada();
                //Date fechaActual = new Date(2020, 07, 16);
                Calendar fechaActual = Calendar.getInstance();
                Date date = fechaActual.getTime();

                nuevaDevolucionEntrada.setCantidadDevEntrada(Integer.parseInt(jTextField_cantidadDev.getText()));
                nuevaDevolucionEntrada.setIdEntrada(entradaDAO.findEntrada(Integer.parseInt(jTextFieldID.getText())));
                nuevaDevolucionEntrada.setFechaDevEntrada(date);

                idEntrada = nuevaDevolucionEntrada.getIdEntrada().getIdEntrada().toString();
                cantidadDev = Integer.parseInt(jTextField_cantidadDev.getText());
                cantidadActual = nuevaDevolucionEntrada.getIdEntrada().getCantidadArticulo();
                System.out.println(idEntrada);

                if (cantidadDev > cantidadActual){
                    JOptionPane.showMessageDialog(null, "La cantidad de productos a devolver supera la cantidad que salió, ingrese el valor correcto");
                }else{
                    devolucionEntradaLogica.registrarDevolucion(nuevaDevolucionEntrada);
                    actualizarEntrada(idEntrada, cantidadDev);
                    JOptionPane.showMessageDialog(null, "Devolucion de salida registrada exitosamente");
                }
            }
        }
    /**************************************************************************/
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jButton_confirmarDevActionPerformed

    private void jButton_cancelarDevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelarDevActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton_cancelarDevActionPerformed

    private void jTextFieldIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIDActionPerformed

    private void jTextField_cantidadDevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_cantidadDevActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_cantidadDevActionPerformed

    private void jTextFieldTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTestActionPerformed

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
            java.util.logging.Logger.getLogger(VistaDevolucionEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaDevolucionEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaDevolucionEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaDevolucionEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaDevolucionEntrada().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_cancelarDev;
    private javax.swing.JButton jButton_confirmarDev;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelProducto;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldTest;
    private javax.swing.JTextField jTextField_cantidadDev;
    // End of variables declaration//GEN-END:variables
}
