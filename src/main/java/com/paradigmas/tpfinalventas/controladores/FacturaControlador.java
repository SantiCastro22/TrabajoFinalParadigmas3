package com.paradigmas.tpfinalventas.controladores;

import com.paradigmas.tpfinalventas.dominio.Conexion;
import com.paradigmas.tpfinalventas.objetos.Cliente;
import com.paradigmas.tpfinalventas.objetos.Factura;
import com.paradigmas.tpfinalventas.objetos.FormaPago;
import com.paradigmas.tpfinalventas.objetos.LineaFactura;
import com.paradigmas.tpfinalventas.objetos.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FacturaControlador implements ICrud<Factura> {

    private static final Logger LOGGER = Logger.getLogger(FacturaControlador.class.getName());

    @Override
    public boolean crear(Factura factura) {
        String sqlFactura = "INSERT INTO factura (numero_factura, cliente_id, forma_pago_id, fecha_emision, total, observaciones) VALUES (?, ?, ?, ?, ?, ?)";
        String sqlLinea = "INSERT INTO linea_factura (factura_id, producto_id, cantidad, subtotal) VALUES (?, ?, ?, ?)";
        
        Connection conn = null;
        try {
            conn = Conexion.obtenerConexion();

            conn.setAutoCommit(false);

            //  Insertar factura principal
            try (PreparedStatement psFactura = conn.prepareStatement(sqlFactura, Statement.RETURN_GENERATED_KEYS)) {
                psFactura.setString(1, factura.getNumeroFactura());
                psFactura.setInt(2, factura.getCliente().getId());
                psFactura.setInt(3, factura.getFormaDePago().getId());
                psFactura.setTimestamp(4, new Timestamp(factura.getFecha().getTime()));
                psFactura.setDouble(5, factura.getTotal());
                psFactura.setString(6, factura.getObservaciones());
                
                psFactura.executeUpdate();

                // Obtener el ID de la factura creada
                try (ResultSet generatedKeys = psFactura.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        factura.setId(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("No se pudo obtener el ID de la factura, la creación falló.");
                    }
                }
            }

            // Insertar linea de la factura
            try (PreparedStatement psLinea = conn.prepareStatement(sqlLinea)) {
                for (LineaFactura linea : factura.getLineaFactura()) {
                    psLinea.setInt(1, factura.getId());
                    psLinea.setInt(2, linea.getProducto().getId());
                    psLinea.setDouble(3, linea.getCantidad());
                    psLinea.setDouble(4, linea.getSubtotal());
                    psLinea.addBatch(); // Agrupar las inserciones
                }
                psLinea.executeBatch();
            }

            conn.commit();
            return true;

        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error al crear la factura. Se Revirte la transaccion.", ex);
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e) {
                    LOGGER.log(Level.SEVERE, "Error al intentar revertir la transacción.", e);
                }
            }
            return false;
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    LOGGER.log(Level.SEVERE, "Error al cerrar la conexion.", e);
                }
            }
        }
    }

    @Override
    public boolean eliminar(Factura factura) {
        String sql = "DELETE FROM factura WHERE id = ?";
        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, factura.getId());
            return ps.executeUpdate() > 0;

        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error al eliminar la factura con ID: " + factura.getId(), ex);
            return false;
        }
    }

    @Override
    public Factura extraer(int id) {
        String sql = "SELECT f.id, f.numero_factura, f.fecha_emision, f.total, f.observaciones, " +
                     "c.id AS cliente_id, c.nombre AS cliente_nombre, c.apellido AS cliente_apellido, " +
                     "fp.id AS fp_id, fp.descripcion AS fp_desc " +
                     "FROM factura f " +
                     "JOIN cliente c ON f.cliente_id = c.id " +
                     "JOIN forma_pago fp ON f.forma_pago_id = fp.id " +
                     "WHERE f.id = ?";
        
        Factura factura = null;
        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    factura = new Factura();
                    factura.setId(rs.getInt("id"));
                    factura.setNumeroFactura(rs.getString("numero_factura"));
                    factura.setFecha(rs.getTimestamp("fecha_emision"));
                    factura.setTotal(rs.getDouble("total"));
                    factura.setObservaciones(rs.getString("observaciones"));

                    Cliente cliente = new Cliente();
                    cliente.setId(rs.getInt("cliente_id"));
                    cliente.setNombre(rs.getString("cliente_nombre"));
                    cliente.setApellido(rs.getString("cliente_apellido"));
                    factura.setCliente(cliente);

                    FormaPago formaPago = new FormaPago();
                    formaPago.setId(rs.getInt("fp_id"));
                    formaPago.setDescripcion(rs.getString("fp_desc"));
                    factura.setFormaDePago(formaPago);
                    
                    // Cargar de las de la factura
                    factura.setLineaFactura(extraerLineasDeFactura(factura.getId(), conn));
                }
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error al extraer la factura con ID: " + id, ex);
        }
        return factura;
    }

    private List<LineaFactura> extraerLineasDeFactura(int facturaId, Connection conn) throws SQLException {
        List<LineaFactura> lineas = new ArrayList<>();
        String sql = "SELECT lf.id, lf.cantidad, lf.subtotal, " +
                     "p.id AS prod_id, p.nombre AS prod_nombre, p.precio AS prod_precio " +
                     "FROM linea_factura lf " +
                     "JOIN producto p ON lf.producto_id = p.id " +
                     "WHERE lf.factura_id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, facturaId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Producto producto = new Producto();
                    producto.setId(rs.getInt("prod_id"));
                    producto.setNombre(rs.getString("prod_nombre"));
                    producto.setPrecio(rs.getFloat("prod_precio"));

                    LineaFactura linea = new LineaFactura();
                    linea.setId(rs.getInt("id"));
                    linea.setCantidad(rs.getDouble("cantidad"));
                    linea.setSubtotal(rs.getDouble("subtotal"));
                    linea.setProducto(producto);
                    
                    lineas.add(linea);
                }
            }
        }
        return lineas;
    }

    @Override
    public boolean modificar(Factura entidad) {
        LOGGER.log(Level.WARNING, "La modificación de facturas no está implementada por completo.");
        return false;
    }

    @Override
    public List<Factura> listar() {
        List<Factura> facturas = new ArrayList<>();

        String sql = "SELECT f.id, f.numero_factura, f.fecha_emision, f.total, " +
                     "c.id AS cliente_id, c.nombre AS cliente_nombre, c.apellido AS cliente_apellido " +
                     "FROM factura f " +
                     "JOIN cliente c ON f.cliente_id = c.id " +
                     "ORDER BY f.fecha_emision DESC";

        try (Connection conn = Conexion.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Factura factura = new Factura();
                factura.setId(rs.getInt("id"));
                factura.setNumeroFactura(rs.getString("numero_factura"));
                factura.setFecha(rs.getTimestamp("fecha_emision"));
                factura.setTotal(rs.getDouble("total"));

                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("cliente_id"));
                cliente.setNombre(rs.getString("cliente_nombre"));
                cliente.setApellido(rs.getString("cliente_apellido"));
                factura.setCliente(cliente);
                
                facturas.add(factura);
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error al listar las facturas", ex);
        }
        return facturas;
    }
}
