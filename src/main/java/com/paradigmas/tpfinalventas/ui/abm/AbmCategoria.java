package com.paradigmas.tpfinalventas.ui.abm;

import com.paradigmas.tpfinalventas.controladores.CategoriaControlador;
import com.paradigmas.tpfinalventas.controladores.TipoClienteControlador;
import com.paradigmas.tpfinalventas.objetos.Categoria;
import com.paradigmas.tpfinalventas.objetos.TipoCliente;
import com.paradigmas.tpfinalventas.ui.grilla.GrillaCategoria;
import com.paradigmas.tpfinalventas.ui.grilla.GrillaTipoCliente;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AbmCategoria extends javax.swing.JPanel {

    private final TipoClienteControlador tipoClienteControlador;
    private final CategoriaControlador categoriaControlador;
    
    public AbmCategoria() {
        initComponents();
        
        tipoClienteControlador = new TipoClienteControlador();
        categoriaControlador = new CategoriaControlador();
        
        refreshTableCat();
        refreshTableCli();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        inputNombreCat = new javax.swing.JTextField();
        inputDescripcionCat = new javax.swing.JTextField();
        btnLimpiarCat = new javax.swing.JButton();
        btnAgregarCat = new javax.swing.JButton();
        btnEliminarCat = new javax.swing.JButton();
        btnModificarCat = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCategorias = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        inputNombreCli = new javax.swing.JTextField();
        inputDescripcionCli = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnLimpiarCli = new javax.swing.JButton();
        btnEliminarCli = new javax.swing.JButton();
        btnModificarCli = new javax.swing.JButton();
        btnAgregarCli = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtTipoCliente = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("ABM CATEGORIAS");

        jLabel2.setText("Nombre");

        jLabel3.setText("Descripcion");

        btnLimpiarCat.setText("LIMPIAR");
        btnLimpiarCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCatActionPerformed(evt);
            }
        });

        btnAgregarCat.setText("AGREGAR");
        btnAgregarCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCatActionPerformed(evt);
            }
        });

        btnEliminarCat.setText("ELIMINAR");
        btnEliminarCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCatActionPerformed(evt);
            }
        });

        btnModificarCat.setText("MODIFICAR");
        btnModificarCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarCatActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("LISTA CATEGORIAS DE PRODUCTOS");

        jtCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {}
        ));
        jtCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtCategoriasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtCategorias);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("ABM TIPO CLIENTE");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("LISTA TIPOS DE CLIENTE");

        jLabel7.setText("Nombre");

        jLabel8.setText("Descripcion");

        btnLimpiarCli.setText("LIMPIAR");
        btnLimpiarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCliActionPerformed(evt);
            }
        });

        btnEliminarCli.setText("ELIMINAR");
        btnEliminarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCliActionPerformed(evt);
            }
        });

        btnModificarCli.setText("MODIFICAR");
        btnModificarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarCliActionPerformed(evt);
            }
        });

        btnAgregarCli.setText("AGREGAR");
        btnAgregarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCliActionPerformed(evt);
            }
        });

        jtTipoCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {}
        ));
        jtTipoCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTipoClienteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtTipoCliente);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(225, 225, 225))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                    .addGap(25, 25, 25)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(inputNombreCat)
                                        .addComponent(inputDescripcionCat, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(btnLimpiarCat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnEliminarCat, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
                                    .addGap(23, 23, 23)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnAgregarCat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnModificarCat, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))))
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnLimpiarCli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEliminarCli, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnAgregarCli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnModificarCli, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(inputNombreCli)
                                    .addComponent(inputDescripcionCli, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(188, 188, 188))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 65, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(inputNombreCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(inputDescripcionCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLimpiarCat)
                            .addComponent(btnAgregarCat))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminarCat)
                            .addComponent(btnModificarCat)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(inputNombreCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(inputDescripcionCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLimpiarCli)
                            .addComponent(btnAgregarCli))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminarCli)
                            .addComponent(btnModificarCli)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarCatActionPerformed(java.awt.event.ActionEvent evt) {
        inputNombreCat.setText("");
        inputDescripcionCat.setText("");
        jtCategorias.clearSelection();
    }

    private void btnLimpiarCliActionPerformed(java.awt.event.ActionEvent evt) {
        inputNombreCli.setText("");
        inputDescripcionCli.setText("");
        jtTipoCliente.clearSelection();
    }

    private void btnAgregarCatActionPerformed(java.awt.event.ActionEvent evt) {
        String nombre = inputNombreCat.getText();
        if (nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre de la categoría es obligatorio.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Categoria nuevaCategoria = new Categoria();
        nuevaCategoria.setDenominacion(nombre);
        nuevaCategoria.setDescripcion(inputDescripcionCat.getText());

        if (categoriaControlador.crear(nuevaCategoria)) {
            JOptionPane.showMessageDialog(this, "Categoría agregada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            refreshTableCat();
            btnLimpiarCatActionPerformed(null);
        } else {
            JOptionPane.showMessageDialog(this, "Error al agregar la categoría.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnAgregarCliActionPerformed(java.awt.event.ActionEvent evt) {
        String nombre = inputNombreCli.getText();
        if (nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre del tipo de cliente es obligatorio.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        TipoCliente nuevoTipo = new TipoCliente();
        nuevoTipo.setNombre(nombre);
        nuevoTipo.setDescripcion(inputDescripcionCli.getText());

        if (tipoClienteControlador.crear(nuevoTipo)) {
            JOptionPane.showMessageDialog(this, "Tipo de cliente agregado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            refreshTableCli();
            btnLimpiarCliActionPerformed(null);
        } else {
            JOptionPane.showMessageDialog(this, "Error al agregar el tipo de cliente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnModificarCatActionPerformed(java.awt.event.ActionEvent evt) {
        int fila = jtCategorias.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una categoría para modificar.", "Acción Requerida", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Integer id = (Integer) jtCategorias.getModel().getValueAt(fila, 0);
        String nombre = inputNombreCat.getText();
        if (nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre de la categoría es obligatorio.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Categoria categoriaModificada = new Categoria();
        categoriaModificada.setId(id);
        categoriaModificada.setDenominacion(nombre);
        categoriaModificada.setDescripcion(inputDescripcionCat.getText());

        if (categoriaControlador.modificar(categoriaModificada)) {
            JOptionPane.showMessageDialog(this, "Categoría modificada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            refreshTableCat();
            btnLimpiarCatActionPerformed(null);
        } else {
            JOptionPane.showMessageDialog(this, "Error al modificar la categoría.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnEliminarCatActionPerformed(java.awt.event.ActionEvent evt) {
        int fila = jtCategorias.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una categoría para eliminar.", "Acción Requerida", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar esta categoría?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        Integer id = (Integer) jtCategorias.getModel().getValueAt(fila, 0);
        Categoria categoriaAEliminar = new Categoria();
        categoriaAEliminar.setId(id);

        if (categoriaControlador.eliminar(categoriaAEliminar)) {
            JOptionPane.showMessageDialog(this, "Categoría eliminada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            refreshTableCat();
            btnLimpiarCatActionPerformed(null);
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar la categoría. Puede estar en uso.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnEliminarCliActionPerformed(java.awt.event.ActionEvent evt) {
        int fila = jtTipoCliente.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un tipo de cliente para eliminar.", "Acción Requerida", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar este tipo de cliente?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        Integer id = (Integer) jtTipoCliente.getModel().getValueAt(fila, 0);
        TipoCliente tipoAEliminar = new TipoCliente();
        tipoAEliminar.setId(id);

        if (tipoClienteControlador.eliminar(tipoAEliminar)) {
            JOptionPane.showMessageDialog(this, "Tipo de cliente eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            refreshTableCli();
            btnLimpiarCliActionPerformed(null);
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar el tipo de cliente. Puede estar en uso.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnModificarCliActionPerformed(java.awt.event.ActionEvent evt) {
        int fila = jtTipoCliente.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un tipo de cliente para modificar.", "Acción Requerida", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Integer id = (Integer) jtTipoCliente.getModel().getValueAt(fila, 0);
        String nombre = inputNombreCli.getText();
        if (nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre del tipo de cliente es obligatorio.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        TipoCliente tipoModificado = new TipoCliente();
        tipoModificado.setId(id);
        tipoModificado.setNombre(nombre);
        tipoModificado.setDescripcion(inputDescripcionCli.getText());

        if (tipoClienteControlador.modificar(tipoModificado)) {
            JOptionPane.showMessageDialog(this, "Tipo de cliente modificado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            refreshTableCli();
            btnLimpiarCliActionPerformed(null);
        } else {
            JOptionPane.showMessageDialog(this, "Error al modificar el tipo de cliente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void jtCategoriasMouseClicked(java.awt.event.MouseEvent evt) {
        int fila = jtCategorias.getSelectedRow();
        if (fila == -1) return;
        
        inputNombreCat.setText(jtCategorias.getModel().getValueAt(fila, 1).toString());
        inputDescripcionCat.setText(jtCategorias.getModel().getValueAt(fila, 2).toString());
    }

    private void jtTipoClienteMouseClicked(java.awt.event.MouseEvent evt) {
        int fila = jtTipoCliente.getSelectedRow();
        if (fila == -1) return;

        inputNombreCli.setText(jtTipoCliente.getModel().getValueAt(fila, 1).toString());
        inputDescripcionCli.setText(jtTipoCliente.getModel().getValueAt(fila, 2).toString());
    }
    
    private void refreshTableCat(){
        try {
            List<Categoria> categorias = categoriaControlador.listar();
            jtCategorias.setModel(new GrillaCategoria((ArrayList<Categoria>) categorias));
        } catch (Exception ex) {
            Logger.getLogger(AbmCategoria.class.getName()).log(Level.SEVERE, "Error al refrescar la tabla de categorias", ex);
        }
    }
    
    private void refreshTableCli(){
        try {
            List<TipoCliente> tipoCliente = tipoClienteControlador.listar();
            jtTipoCliente.setModel(new GrillaTipoCliente((ArrayList<TipoCliente>) tipoCliente));
        } catch (Exception ex) {
            Logger.getLogger(AbmCategoria.class.getName()).log(Level.SEVERE, "Error al refrescar la tabla de tipo cliente", ex);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField inputDescripcionCat;
    private javax.swing.JTextField inputDescripcionCli;
    private javax.swing.JButton btnAgregarCat;
    private javax.swing.JButton btnAgregarCli;
    private javax.swing.JButton btnEliminarCat;
    private javax.swing.JButton btnEliminarCli;
    private javax.swing.JButton btnLimpiarCat;
    private javax.swing.JButton btnLimpiarCli;
    private javax.swing.JButton btnModificarCat;
    private javax.swing.JButton btnModificarCli;
    private javax.swing.JTextField inputNombreCat;
    private javax.swing.JTextField inputNombreCli;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jtCategorias;
    private javax.swing.JTable jtTipoCliente;
    // End of variables declaration//GEN-END:variables
}
