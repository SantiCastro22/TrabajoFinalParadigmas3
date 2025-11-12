package com.paradigmas.tpfinalventas.controladores;

import com.paradigmas.tpfinalventas.dominio.Conexion;
import com.paradigmas.tpfinalventas.objetos.FormaPago;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FormaPagoControlador implements ICrud<FormaPago> {

    private static final Logger LOGGER = Logger.getLogger(FormaPagoControlador.class.getName());

    @Override
    public boolean crear(FormaPago entidad) {
        String sql = "INSERT INTO forma_pago (descripcion) VALUES (?)";
        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, entidad.getDescripcion());
            return ps.executeUpdate() > 0;

        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error al crear la forma de pago", ex);
            return false;
        }
    }

    @Override
    public boolean eliminar(FormaPago entidad) {
        String sql = "DELETE FROM forma_pago WHERE id = ?";
        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, entidad.getId());
            return ps.executeUpdate() > 0;

        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error al eliminar la forma de pago con ID: " + entidad.getId(), ex);
            return false;
        }
    }

    @Override
    public FormaPago extraer(int id) {
        String sql = "SELECT * FROM forma_pago WHERE id = ?";
        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    FormaPago formaPago = new FormaPago();
                    formaPago.setId(rs.getInt("id"));
                    formaPago.setDescripcion(rs.getString("descripcion"));
                    return formaPago;
                }
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error al extraer la forma de pago con ID: " + id, ex);
        }
        return null;
    }

    @Override
    public boolean modificar(FormaPago entidad) {
        String sql = "UPDATE forma_pago SET descripcion = ? WHERE id = ?";
        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, entidad.getDescripcion());
            ps.setInt(2, entidad.getId());
            return ps.executeUpdate() > 0;

        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error al modificar la forma de pago con ID: " + entidad.getId(), ex);
            return false;
        }
    }


    @Override
    public List<FormaPago> listar() {
        List<FormaPago> formasPago = new ArrayList<>();
        String sql = "SELECT * FROM forma_pago";

        try (Connection conn = Conexion.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                FormaPago formaPago = new FormaPago();
                formaPago.setId(rs.getInt("id"));
                formaPago.setDescripcion(rs.getString("descripcion"));
                formasPago.add(formaPago);
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error al listar las formas de pago", ex);
        }
        return formasPago;
    }
}
