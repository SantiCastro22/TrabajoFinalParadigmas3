package com.paradigmas.tpfinalventas.controladores;

import com.paradigmas.tpfinalventas.dominio.Conexion;
import com.paradigmas.tpfinalventas.objetos.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoriaControlador implements ICrud<Categoria> {

    private static final Logger LOGGER = Logger.getLogger(CategoriaControlador.class.getName());

    @Override
    public List<Categoria> listar() {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT * FROM categoria";

        try (Connection conn = Conexion.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setDenominacion(rs.getString("denominacion"));
                categoria.setDescripcion(rs.getString("descripcion"));
                categorias.add(categoria);
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error al listar las categorías", ex);
        }
        return categorias;
    }

    @Override
    public boolean crear(Categoria entidad) {
        String sql = "INSERT INTO categoria (denominacion, descripcion) VALUES (?, ?)";
        
        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, entidad.getDenominacion());
            ps.setString(2, entidad.getDescripcion());
            
            return ps.executeUpdate() > 0;

        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error al crear la categoría", ex);
            return false;
        }
    }

    @Override
    public boolean eliminar(Categoria entidad) {
        String sql = "DELETE FROM categoria WHERE id = ?";
        
        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, entidad.getId());
            return ps.executeUpdate() > 0;

        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error al eliminar la categoría con ID: " + entidad.getId(), ex);
            return false;
        }
    }

    @Override
    public Categoria extraer(int id) {
        String sql = "SELECT * FROM categoria WHERE id = ?";
        
        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Categoria categoria = new Categoria();
                    categoria.setId(rs.getInt("id"));
                    categoria.setDenominacion(rs.getString("denominacion"));
                    categoria.setDescripcion(rs.getString("descripcion"));
                    return categoria;
                }
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error al extraer la categoría con ID: " + id, ex);
        }
        return null;
    }

    @Override
    public boolean modificar(Categoria entidad) {
        String sql = "UPDATE categoria SET denominacion = ?, descripcion = ? WHERE id = ?";
        
        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, entidad.getDenominacion());
            ps.setString(2, entidad.getDescripcion());
            ps.setInt(3, entidad.getId());
            
            return ps.executeUpdate() > 0;

        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error al modificar la categoría con ID: " + entidad.getId(), ex);
            return false;
        }
    }
}
