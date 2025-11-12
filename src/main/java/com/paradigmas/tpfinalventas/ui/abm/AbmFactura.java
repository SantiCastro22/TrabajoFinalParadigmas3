package com.paradigmas.tpfinalventas.ui.abm;

import com.paradigmas.tpfinalventas.controladores.ClienteControlador;
import com.paradigmas.tpfinalventas.controladores.FacturaControlador;
import com.paradigmas.tpfinalventas.controladores.FormaPagoControlador;
import com.paradigmas.tpfinalventas.controladores.ProductoControlador;
import com.paradigmas.tpfinalventas.objetos.Cliente;
import com.paradigmas.tpfinalventas.objetos.Factura;
import com.paradigmas.tpfinalventas.objetos.FormaPago;
import com.paradigmas.tpfinalventas.objetos.LineaFactura;
import com.paradigmas.tpfinalventas.objetos.Producto;
import com.paradigmas.tpfinalventas.ui.grilla.FacturaGrilla;
import com.paradigmas.tpfinalventas.ui.grilla.LineaGrilla;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AbmFactura extends javax.swing.JPanel {

    private static final Logger LOGGER = Logger.getLogger(AbmFactura.class.getName());

    private final FacturaControlador facturaControlador;
    private final ProductoControlador productoControlador;
    private final ClienteControlador clienteControlador;
    private final FormaPagoControlador formaPagoControlador;

    private List<LineaFactura> lineasFacturaActual;
    private double totalFacturaActual = 0.0;

    public AbmFactura() {
        initComponents();

        facturaControlador = new FacturaControlador();
        productoControlador = new ProductoControlador();
        clienteControlador = new ClienteControlador();
        formaPagoControlador = new FormaPagoControlador();

        lineasFacturaActual = new ArrayList<>();

        configurarComponentes();
        cargarDatosIniciales();
    }

    private void configurarComponentes() {
        SpinnerNumberModel spinnerModel = new SpinnerNumberModel(1, 1, 1000, 1);
        cantidadSeleccionada.setModel(spinnerModel);
        jtLineaFactura.setModel(new LineaGrilla(new ArrayList<>()));
    }

    private void cargarDatosIniciales() {
        cargarClientesEnComboBox();
        cargarFormasPagoEnComboBox();
        cargarProductosEnComboBox();
        refreshTableFacturas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtFactura = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtLineaFactura = new javax.swing.JTable();
        labelFactura = new javax.swing.JLabel();
        labelDetalleFactura = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        clienteSelected = new javax.swing.JComboBox<>();
        labelCliente = new javax.swing.JLabel();
        labelCliente1 = new javax.swing.JLabel();
        formaPagoSelected = new javax.swing.JComboBox<>();
        labelProducto = new javax.swing.JLabel();
        productoSelected = new javax.swing.JComboBox<>();
        cantidadSeleccionada = new javax.swing.JSpinner();
        labelCantidadProducto = new javax.swing.JLabel();
        btnAddLinea = new javax.swing.JButton();
        btnCrearFactura = new javax.swing.JButton();
        labelTotal = new javax.swing.JLabel();
        inputNumeroFactura = new javax.swing.JTextField();
        labelNumeroFactura = new javax.swing.JLabel();
        btnEliminarLinea = new javax.swing.JButton();

        jtFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {}
        ));
        jScrollPane1.setViewportView(jtFactura);

        jtLineaFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {}
        ));
        jScrollPane2.setViewportView(jtLineaFactura);

        labelFactura.setText("HISTORIAL DE FACTURAS");

        labelDetalleFactura.setText("DETALLE DE FACTURA ACTUAL");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("ADMINISTRACIÓN DE FACTURAS");

        labelCliente.setText("Cliente");

        labelCliente1.setText("Forma de Pago");

        labelProducto.setText("Producto");

        labelCantidadProducto.setText("Cantidad");

        btnAddLinea.setText("Agregar Producto");
        btnAddLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddLineaActionPerformed(evt);
            }
        });

        btnCrearFactura.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCrearFactura.setText("GUARDAR FACTURA");
        btnCrearFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearFacturaActionPerformed(evt);
            }
        });

        labelTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTotal.setText("TOTAL: $ 0.00");

        labelNumeroFactura.setText("Nro. Factura");

        btnEliminarLinea.setText("Quitar Producto");
        btnEliminarLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarLineaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelFactura)
                        .addGap(117, 117, 117))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelCliente1)
                                    .addComponent(labelCliente)
                                    .addComponent(labelNumeroFactura))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(clienteSelected, 0, 200, Short.MAX_VALUE)
                                    .addComponent(formaPagoSelected, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(inputNumeroFactura)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelProducto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(productoSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelCantidadProducto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cantidadSeleccionada, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAddLinea))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCrearFactura)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminarLinea)
                                .addGap(34, 34, 34)
                                .addComponent(labelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labelDetalleFactura))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFactura)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(clienteSelected, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(formaPagoSelected, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCliente1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputNumeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelNumeroFactura))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(productoSelected, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelProducto)
                            .addComponent(cantidadSeleccionada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCantidadProducto)
                            .addComponent(btnAddLinea))
                        .addGap(18, 18, 18)
                        .addComponent(labelDetalleFactura)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCrearFactura)
                            .addComponent(labelTotal)
                            .addComponent(btnEliminarLinea)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddLineaActionPerformed(java.awt.event.ActionEvent evt) {
        Producto producto = (Producto) productoSelected.getSelectedItem();
        int cantidadInt = (int) cantidadSeleccionada.getValue();

        if (producto == null) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un producto.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Convertir los valores a Double
        double cantidadDouble = (double) cantidadInt;
        double subtotal = (double) (producto.getPrecio() * cantidadInt);

        // Crear la línea de factura
        LineaFactura nuevaLinea = new LineaFactura();
        nuevaLinea.setProducto(producto);
        nuevaLinea.setCantidad(cantidadDouble);
        nuevaLinea.setSubtotal(subtotal);

        // Añadir la línea a la lista temporal
        lineasFacturaActual.add(nuevaLinea);

        // Actualizar la tabla de líneas y el total
        actualizarTablaLineas();
        actualizarTotal();
    }

    private void btnCrearFacturaActionPerformed(java.awt.event.ActionEvent evt) {
        Cliente cliente = (Cliente) clienteSelected.getSelectedItem();
        FormaPago formaPago = (FormaPago) formaPagoSelected.getSelectedItem();
        String numeroFactura = inputNumeroFactura.getText();

        if (cliente == null || formaPago == null || numeroFactura.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Cliente, Forma de Pago y Número de Factura son obligatorios.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (lineasFacturaActual.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La factura debe tener al menos una línea.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Factura nuevaFactura = new Factura();
        nuevaFactura.setCliente(cliente);
        nuevaFactura.setFormaDePago(formaPago);
        nuevaFactura.setNumeroFactura(numeroFactura);
        nuevaFactura.setFecha(new Date());
        nuevaFactura.setLineaFactura(lineasFacturaActual);
        nuevaFactura.setTotal(totalFacturaActual);
        nuevaFactura.setObservaciones("");

        boolean exito = facturaControlador.crear(nuevaFactura);

        if (exito) {
            JOptionPane.showMessageDialog(this, "Factura creada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            limpiarFormulario();
            refreshTableFacturas();
        } else {
            JOptionPane.showMessageDialog(this, "Error al crear la factura.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnEliminarLineaActionPerformed(java.awt.event.ActionEvent evt) {
        int filaSeleccionada = jtLineaFactura.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una línea de producto para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        lineasFacturaActual.remove(filaSeleccionada);
        actualizarTablaLineas();
        actualizarTotal();
    }

    private void cargarProductosEnComboBox() {
        try {
            List<Producto> productos = productoControlador.listar();
            DefaultComboBoxModel<Producto> model = new DefaultComboBoxModel<>(productos.toArray(new Producto[0]));
            productoSelected.setModel(model);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error al cargar productos en el ComboBox", ex);
        }
    }

    private void cargarClientesEnComboBox() {
        try {
            List<Cliente> clientes = clienteControlador.listar();
            DefaultComboBoxModel<Cliente> model = new DefaultComboBoxModel<>(clientes.toArray(new Cliente[0]));
            clienteSelected.setModel(model);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error al cargar clientes en el ComboBox", ex);
        }
    }

    private void cargarFormasPagoEnComboBox() {
        try {
            List<FormaPago> formasPago = formaPagoControlador.listar();
            DefaultComboBoxModel<FormaPago> model = new DefaultComboBoxModel<>(formasPago.toArray(new FormaPago[0]));
            formaPagoSelected.setModel(model);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error al cargar formas de pago en el ComboBox", ex);
        }
    }

    private void refreshTableFacturas() {
        try {
            List<Factura> facturas = facturaControlador.listar();
            jtFactura.setModel(new FacturaGrilla(facturas));
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error al refrescar la tabla de facturas", ex);
        }
    }

    private void actualizarTablaLineas() {
        jtLineaFactura.setModel(new LineaGrilla(lineasFacturaActual));
    }

    private void actualizarTotal() {
        totalFacturaActual = 0.0;
        for (LineaFactura linea : lineasFacturaActual) {
            totalFacturaActual += linea.getSubtotal();
        }
        labelTotal.setText(String.format("TOTAL: $ %.2f", totalFacturaActual));
    }

    private void limpiarFormulario() {
        if (clienteSelected.getItemCount() > 0) clienteSelected.setSelectedIndex(0);
        if (formaPagoSelected.getItemCount() > 0) formaPagoSelected.setSelectedIndex(0);
        inputNumeroFactura.setText("");
        lineasFacturaActual.clear();
        actualizarTablaLineas();
        actualizarTotal();
        cantidadSeleccionada.setValue(1);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddLinea;
    private javax.swing.JButton btnCrearFactura;
    private javax.swing.JButton btnEliminarLinea;
    private javax.swing.JSpinner cantidadSeleccionada;
    private javax.swing.JComboBox<Cliente> clienteSelected;
    private javax.swing.JComboBox<FormaPago> formaPagoSelected;
    private javax.swing.JTextField inputNumeroFactura;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtFactura;
    private javax.swing.JTable jtLineaFactura;
    private javax.swing.JLabel labelCantidadProducto;
    private javax.swing.JLabel labelCliente;
    private javax.swing.JLabel labelCliente1;
    private javax.swing.JLabel labelDetalleFactura;
    private javax.swing.JLabel labelFactura;
    private javax.swing.JLabel labelNumeroFactura;
    private javax.swing.JLabel labelProducto;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JComboBox<Producto> productoSelected;
    // End of variables declaration//GEN-END:variables
}
