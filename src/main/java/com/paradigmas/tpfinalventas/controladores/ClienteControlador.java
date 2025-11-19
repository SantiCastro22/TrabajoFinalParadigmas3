package com.paradigmas.tpfinalventas.controladores;

import com.paradigmas.tpfinalventas.dominio.Conexion;
import com.paradigmas.tpfinalventas.objetos.Cliente;
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

public class ClienteControlador implements ICrud<Cliente> {

    private static final Logger LOGGER = Logger.getLogger(ClienteControlador.class.getName());
    
    @Override
    public boolean crear(Cliente cliente) {
        String sql = "INSERT INTO cliente (documento, nombre, apellido, fecha_nacimiento, direccion, tipo_cliente_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, cliente.getDocumento());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellido());
            ps.setDate(4, new java.sql.Date(cliente.getFechaNacimiento().getTime()));
            ps.setString(5, cliente.getDireccion());
            ps.setInt(6, cliente.getTipoCliente().getId());
            
            return ps.executeUpdate() > 0;

        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error al crear cliente", ex);
            return false;
        }
    }
    
    @Override
    public boolean eliminar(Cliente entidad) {
        String sql = "DELETE FROM cliente WHERE id = ?";
        
        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, entidad.getId());
            return ps.executeUpdate() > 0;

        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error al eliminar el cliente con ID: " + entidad.getId(), ex);
            return false;
        }
    }
    
    @Override
    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT c.id, c.documento, c.nombre, c.apellido, c.fecha_nacimiento, c.direccion, " +
                     "tc.id AS tipo_cliente_id, tc.nombre AS tipo_cliente_nombre, tc.descripcion AS tipo_cliente_descripcion " +
                     "FROM cliente c " +
                     "JOIN tipo_cliente tc ON c.tipo_cliente_id = tc.id";

        try (Connection conn = Conexion.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                TipoCliente tipoCliente = new TipoCliente(
                    rs.getInt("tipo_cliente_id"),
                    rs.getString("tipo_cliente_nombre"),
                    rs.getString("tipo_cliente_descripcion")
                );

                Cliente cliente = new Cliente(
                    rs.getInt("id"),
                    rs.getString("documento"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getDate("fecha_nacimiento"),
                    rs.getString("direccion"),
                    tipoCliente
                );
                clientes.add(cliente);
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error al listar clientes", ex);
        }
        return clientes;
    }
    
    @Override
    public boolean modificar(Cliente cliente) {
        String sql = "UPDATE cliente SET documento = ?, nombre = ?, apellido = ?, fecha_nacimiento = ?, direccion = ?, tipo_cliente_id = ? WHERE id = ?";
        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cliente.getDocumento());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellido());
            ps.setDate(4, new java.sql.Date(cliente.getFechaNacimiento().getTime()));
            ps.setString(5, cliente.getDireccion());
            ps.setInt(6, cliente.getTipoCliente().getId());
            ps.setInt(7, cliente.getId());
            
            return ps.executeUpdate() > 0;

        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error al modificar cliente con ID: " + cliente.getId(), ex);
            return false;
        }
    }
    
    @Override
    public Cliente extraer(int id) {
        String sql = "SELECT c.id, c.documento, c.nombre, c.apellido, c.fecha_nacimiento, c.direccion, " +
                     "tc.id AS tipo_cliente_id, tc.nombre AS tipo_cliente_nombre, tc.descripcion AS tipo_cliente_descripcion " +
                     "FROM cliente c " +
                     "JOIN tipo_cliente tc ON c.tipo_cliente_id = tc.id " +
                     "WHERE c.id = ?";
        
        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    TipoCliente tipoCliente = new TipoCliente(
                        rs.getInt("tipo_cliente_id"),
                        rs.getString("tipo_cliente_nombre"),
                        rs.getString("tipo_cliente_descripcion")
                    );

                    return new Cliente(
                        rs.getInt("id"),
                        rs.getString("documento"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getDate("fecha_nacimiento"),
                        rs.getString("direccion"),
                        tipoCliente
                    );
                }
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error al extraer cliente con ID: " + id, ex);
        }
        return null;
    }
}
