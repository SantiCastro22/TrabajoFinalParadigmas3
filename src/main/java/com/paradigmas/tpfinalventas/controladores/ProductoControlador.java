package com.paradigmas.tpfinalventas.controladores;

import com.paradigmas.tpfinalventas.dominio.Conexion;
import com.paradigmas.tpfinalventas.objetos.Categoria;
import com.paradigmas.tpfinalventas.objetos.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductoControlador implements ICrud<Producto> {

    private static final Logger LOGGER = Logger.getLogger(ProductoControlador.class.getName());

    @Override
    public boolean crear(Producto entidad) {
        String sql = "INSERT INTO producto (nombre, descripcion, precio, fecha_creacion, categoria_id) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getDescripcion());
            ps.setFloat(3, entidad.getPrecio());
            ps.setDate(4, new java.sql.Date(entidad.getFechaCreacion().getTime()));
            ps.setInt(5, entidad.getCategoria().getId());
            
            return ps.executeUpdate() > 0;

        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error al crear el producto", ex);
            return false;
        }
    }

    @Override
    public boolean eliminar(Producto entidad) {
        String sql = "DELETE FROM producto WHERE id = ?";

        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, entidad.getId());
            
            return ps.executeUpdate() > 0;

        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error al eliminar el producto con ID: " + entidad.getId(), ex);
            return false;
        }
    }

    
    @Override
    public Producto extraer(int id) {
        String sql = "SELECT p.id, p.nombre, p.descripcion, p.precio, p.fecha_creacion, " +
                     "c.id AS cat_id, c.denominacion AS cat_denominacion, c.descripcion AS cat_desc " +
                     "FROM producto p " +
                     "JOIN categoria c ON p.categoria_id = c.id " +
                     "WHERE p.id = ?";
        
        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Categoria categoria = new Categoria();
                    categoria.setId(rs.getInt("cat_id"));
                    categoria.setDenominacion(rs.getString("cat_denominacion"));
                    categoria.setDescripcion(rs.getString("cat_desc"));

                    Producto producto = new Producto();
                    producto.setId(rs.getInt("id"));
                    producto.setNombre(rs.getString("nombre"));
                    producto.setDescripcion(rs.getString("descripcion"));
                    producto.setPrecio(rs.getFloat("precio"));
                    producto.setFechaCreacion(rs.getDate("fecha_creacion"));
                    producto.setCategoria(categoria);
                    
                    return producto;
                }
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error al extraer el producto con ID: " + id, ex);
        }
        return null;
    }

    
    @Override
    public boolean modificar(Producto entidad) {
        String sql = "UPDATE producto SET nombre = ?, descripcion = ?, precio = ?, fecha_creacion = ?, categoria_id = ? WHERE id = ?";
        
        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getDescripcion());
            ps.setFloat(3, entidad.getPrecio());
            ps.setDate(4, new java.sql.Date(entidad.getFechaCreacion().getTime()));
            ps.setInt(5, entidad.getCategoria().getId());
            ps.setInt(6, entidad.getId()); // ID para la cláusula WHERE
            
            return ps.executeUpdate() > 0;

        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error al modificar el producto con ID: " + entidad.getId(), ex);
            return false;
        }
    }

    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT p.id, p.nombre, p.descripcion, p.precio, p.fecha_creacion, " +
                     "c.id AS cat_id, c.denominacion AS cat_denominacion, c.descripcion AS cat_desc " +
                     "FROM producto p " +
                     "JOIN categoria c ON p.categoria_id = c.id";

        try (Connection conn = Conexion.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("cat_id"));
                categoria.setDenominacion(rs.getString("cat_denominacion"));
                categoria.setDescripcion(rs.getString("cat_desc"));

                Producto producto = new Producto();
                producto.setId(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getFloat("precio"));
                producto.setFechaCreacion(rs.getDate("fecha_creacion"));
                producto.setCategoria(categoria);

                productos.add(producto);
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error al listar los productos", ex);
        }
        return productos;
    }
}
