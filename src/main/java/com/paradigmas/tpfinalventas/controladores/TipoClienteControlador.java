package com.paradigmas.tpfinalventas.controladores;

import com.paradigmas.tpfinalventas.dominio.Conexion;
import com.paradigmas.tpfinalventas.objetos.TipoCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TipoClienteControlador implements ICrud<TipoCliente> {

    private static final Logger LOGGER = Logger.getLogger(TipoClienteControlador.class.getName());

    @Override
    public boolean crear(TipoCliente entidad) {
        String sql = "INSERT INTO tipo_cliente (nombre, descripcion) VALUES (?, ?)";
        
        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getDescripcion());
            
            return ps.executeUpdate() > 0;

        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error al crear el tipo de cliente", ex);
            return false;
        }
    }

    @Override
    public boolean eliminar(TipoCliente entidad) {
        String sql = "DELETE FROM tipo_cliente WHERE id = ?";
        
        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, entidad.getId());
            return ps.executeUpdate() > 0;

        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error al eliminar el tipo de cliente con ID: " + entidad.getId(), ex);
            return false;
        }
    }

    @Override
    public TipoCliente extraer(int id) {
        String sql = "SELECT * FROM tipo_cliente WHERE id = ?";
        
        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    TipoCliente tipoCliente = new TipoCliente();
                    tipoCliente.setId(rs.getInt("id"));
                    tipoCliente.setNombre(rs.getString("nombre"));
                    tipoCliente.setDescripcion(rs.getString("descripcion"));
                    return tipoCliente;
                }
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error al extraer el tipo de cliente con ID: " + id, ex);
        }
        return null;
    }

    @Override
    public boolean modificar(TipoCliente entidad) {
        String sql = "UPDATE tipo_cliente SET nombre = ?, descripcion = ? WHERE id = ?";
        
        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getDescripcion());
            ps.setInt(3, entidad.getId());
            
            return ps.executeUpdate() > 0;

        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error al modificar el tipo de cliente con ID: " + entidad.getId(), ex);
            return false;
        }
    }

    @Override
    public List<TipoCliente> listar() {
        List<TipoCliente> tipoClientes = new ArrayList<>();
        String sql = "SELECT * FROM tipo_cliente";
        
        try (Connection conn = Conexion.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                TipoCliente tipoCliente = new TipoCliente();
                tipoCliente.setId(rs.getInt("id"));
                tipoCliente.setNombre(rs.getString("nombre"));
                tipoCliente.setDescripcion(rs.getString("descripcion"));
                tipoClientes.add(tipoCliente);
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error al listar los tipos de cliente", ex);
        }
        return tipoClientes;
    }
}
