/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import reportes.Persistencia;

/**
 *
 * @author luisalvaranleavpc
 */
public class MenuSistema extends javax.swing.JFrame {

    /**
     * Creates new form MenuSistema
     */
    public MenuSistema() {
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

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonRegDevEntrada = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jButtonRegEntrada = new javax.swing.JButton();
        jButtonRegSalida = new javax.swing.JButton();
        jButtonRegistrarDevSalida = new javax.swing.JButton();
        jButtonRegistrarArt = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jButtonConsultarInventario = new javax.swing.JButton();
        jButtonConsDevEntrada = new javax.swing.JButton();
        jButtonConsEntrada = new javax.swing.JButton();
        jButtonConsSalida = new javax.swing.JButton();
        jButtonConsultarDevSalida = new javax.swing.JButton();
        jButtonRepSalida = new javax.swing.JButton();
        jButtonReporteDevSalida = new javax.swing.JButton();
        jButtonReporteInventario = new javax.swing.JButton();
        jButtonRepDevEntrada = new javax.swing.JButton();
        jButtonRepEntrada = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("EMPRESA COMERCIALIZADORA");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("SISTEMA DE GESTIÓN DE VENTAS");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("BIENVENIDO ");

        jButtonRegDevEntrada.setText("DEVOLUCIÓN ENTRADA");
        jButtonRegDevEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegDevEntradaActionPerformed(evt);
            }
        });

        jButtonSalir.setText("SALIR");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        jButtonRegEntrada.setText("ENTRADA");
        jButtonRegEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegEntradaActionPerformed(evt);
            }
        });

        jButtonRegSalida.setText("SALIDA");
        jButtonRegSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegSalidaActionPerformed(evt);
            }
        });

        jButtonRegistrarDevSalida.setText("DEVOLUCIÓN SALIDA");
        jButtonRegistrarDevSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarDevSalidaActionPerformed(evt);
            }
        });

        jButtonRegistrarArt.setText("ARTÍCULO");
        jButtonRegistrarArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarArtActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("CONSULTAR");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("REGISTRAR");

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("REPORTES");

        jButtonConsultarInventario.setText("INVENTARIO");
        jButtonConsultarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarInventarioActionPerformed(evt);
            }
        });

        jButtonConsDevEntrada.setText("DEVOLUCIÓN ENTRADA");
        jButtonConsDevEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsDevEntradaActionPerformed(evt);
            }
        });

        jButtonConsEntrada.setText("ENTRADA");
        jButtonConsEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsEntradaActionPerformed(evt);
            }
        });

        jButtonConsSalida.setText("SALIDA");
        jButtonConsSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsSalidaActionPerformed(evt);
            }
        });

        jButtonConsultarDevSalida.setText("DEVOLUCIÓN SALIDA");
        jButtonConsultarDevSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarDevSalidaActionPerformed(evt);
            }
        });

        jButtonRepSalida.setText("SALIDA");
        jButtonRepSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRepSalidaActionPerformed(evt);
            }
        });

        jButtonReporteDevSalida.setText("DEVOLUCIÓN SALIDA");
        jButtonReporteDevSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReporteDevSalidaActionPerformed(evt);
            }
        });

        jButtonReporteInventario.setText("INVENTARIO");
        jButtonReporteInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReporteInventarioActionPerformed(evt);
            }
        });

        jButtonRepDevEntrada.setText("DEVOLUCIÓN ENTRADA");
        jButtonRepDevEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRepDevEntradaActionPerformed(evt);
            }
        });

        jButtonRepEntrada.setText("ENTRADA");
        jButtonRepEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRepEntradaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(99, 99, 99))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonRegDevEntrada, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonRegSalida, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonRegEntrada, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonRegistrarArt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonRegistrarDevSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonConsDevEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonConsultarDevSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonConsEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonConsSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonConsultarInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButtonRepDevEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonReporteDevSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonRepEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonRepSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonReporteInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(13, 13, 13)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(570, Short.MAX_VALUE)
                    .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(22, 22, 22)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRegistrarArt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRegEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRegSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRegDevEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRegistrarDevSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonConsultarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonConsEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonConsSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonConsDevEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonConsultarDevSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonReporteInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonRepEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonRepSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonRepDevEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonReporteDevSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(jButtonSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addGap(308, 308, 308)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegDevEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegDevEntradaActionPerformed
        VistaDevolucionEntrada vistaDevolucionEntrada = new VistaDevolucionEntrada();
        vistaDevolucionEntrada.setVisible(true); 
    }//GEN-LAST:event_jButtonRegDevEntradaActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonRegEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegEntradaActionPerformed
        RegistrarEntrada registrarEntrada = new RegistrarEntrada();
        registrarEntrada.setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRegEntradaActionPerformed

    private void jButtonRegSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegSalidaActionPerformed
        RegistrarSalida registrarSalida = new RegistrarSalida();
        registrarSalida.setVisible(true); // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRegSalidaActionPerformed

    private void jButtonRegistrarDevSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarDevSalidaActionPerformed
        RegistrarDevolucionSalida registrarDevolucionSalida = new RegistrarDevolucionSalida();
        registrarDevolucionSalida.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRegistrarDevSalidaActionPerformed

    private void jButtonRegistrarArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarArtActionPerformed
        RegistrarArticulo registrarArticulo = new RegistrarArticulo();
        registrarArticulo.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRegistrarArtActionPerformed

    private void jButtonConsultarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarInventarioActionPerformed
        ConsultarArticulo consultarArticulo = new ConsultarArticulo();
        consultarArticulo.setVisible(true);
    }//GEN-LAST:event_jButtonConsultarInventarioActionPerformed

    private void jButtonConsDevEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsDevEntradaActionPerformed
        // TODO add your handling code here:
        ConsultaDevolucionEntrada consulta = new ConsultaDevolucionEntrada();
        consulta.setVisible(true);
    }//GEN-LAST:event_jButtonConsDevEntradaActionPerformed

    private void jButtonConsEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsEntradaActionPerformed
        ConsultarEntrada consultarEntrada = new ConsultarEntrada();
        consultarEntrada.setVisible(true);
    }//GEN-LAST:event_jButtonConsEntradaActionPerformed

    private void jButtonConsSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsSalidaActionPerformed
        ConsultarSalida consultarSalida = new ConsultarSalida();
        consultarSalida.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonConsSalidaActionPerformed

    private void jButtonConsultarDevSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarDevSalidaActionPerformed
        ConsultarDevolucionSalida consultarDevolucionSalida = new ConsultarDevolucionSalida();
        consultarDevolucionSalida.setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_jButtonConsultarDevSalidaActionPerformed

    private void jButtonRepSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRepSalidaActionPerformed
        // TODO add your handling code here:
        
        try {
            Persistencia con = new Persistencia();
            Connection conn = con.conectar();
            
            JasperReport reporte =null;
            String path= "src\\reportes\\Reporte_Salida.jasper";

            reporte =(JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(reporte,null,conn);
            
            JasperViewer view = new JasperViewer(jprint,false);
            
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
            view.setVisible(true);
            
        } catch (JRException ex) {
            Logger.getLogger(MenuSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonRepSalidaActionPerformed

    private void jButtonReporteDevSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReporteDevSalidaActionPerformed
        // TODO add your handling code here:
        
        try {
            Persistencia con = new Persistencia();
            Connection conn = con.conectar();
            
            JasperReport reporte =null;
            String path= "src\\reportes\\Reporte_Dev_Salida.jasper";

            reporte =(JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(reporte,null,conn);
            
            JasperViewer view = new JasperViewer(jprint,false);
            
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
            view.setVisible(true);
            
        } catch (JRException ex) {
            Logger.getLogger(MenuSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonReporteDevSalidaActionPerformed

    private void jButtonReporteInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReporteInventarioActionPerformed
        // TODO add your handling code here:
        
        try {
            Persistencia con = new Persistencia();
            Connection conn = con.conectar();
            
            JasperReport reporte =null;
            String path= "src\\reportes\\Reporte_Inventario.jasper";

            reporte =(JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(reporte,null,conn);
            
            JasperViewer view = new JasperViewer(jprint,false);
            
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
            view.setVisible(true);
            
        } catch (JRException ex) {
            Logger.getLogger(MenuSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButtonReporteInventarioActionPerformed

    private void jButtonRepDevEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRepDevEntradaActionPerformed
        // TODO add your handling code here:
        
        try {
            Persistencia con = new Persistencia();
            Connection conn = con.conectar();
            
            JasperReport reporte =null;
            String path= "src\\reportes\\Reporte_Dev_Entrada.jasper";

            reporte =(JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(reporte,null,conn);
            
            JasperViewer view = new JasperViewer(jprint,false);
            
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
            view.setVisible(true);
            
        } catch (JRException ex) {
            Logger.getLogger(MenuSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonRepDevEntradaActionPerformed

    private void jButtonRepEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRepEntradaActionPerformed
        // TODO add your handling code here:
        
        try {
            Persistencia con = new Persistencia();
            Connection conn = con.conectar();
            
            JasperReport reporte =null;
            String path= "src\\reportes\\Reporte_Entrada.jasper";

            reporte =(JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(reporte,null,conn);
            
            JasperViewer view = new JasperViewer(jprint,false);
            
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
            view.setVisible(true);
            
        } catch (JRException ex) {
            Logger.getLogger(MenuSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonRepEntradaActionPerformed
     
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
            java.util.logging.Logger.getLogger(MenuSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuSistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConsDevEntrada;
    private javax.swing.JButton jButtonConsEntrada;
    private javax.swing.JButton jButtonConsSalida;
    private javax.swing.JButton jButtonConsultarDevSalida;
    private javax.swing.JButton jButtonConsultarInventario;
    private javax.swing.JButton jButtonRegDevEntrada;
    private javax.swing.JButton jButtonRegEntrada;
    private javax.swing.JButton jButtonRegSalida;
    private javax.swing.JButton jButtonRegistrarArt;
    private javax.swing.JButton jButtonRegistrarDevSalida;
    private javax.swing.JButton jButtonRepDevEntrada;
    private javax.swing.JButton jButtonRepEntrada;
    private javax.swing.JButton jButtonRepSalida;
    private javax.swing.JButton jButtonReporteDevSalida;
    private javax.swing.JButton jButtonReporteInventario;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
