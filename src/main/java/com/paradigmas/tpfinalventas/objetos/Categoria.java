package com.paradigmas.tpfinalventas.objetos;

public class Categoria {
   private Integer id;
   private String denominacion;
   private String descripcion;

    public Categoria() {
    }

    public Categoria(Integer id, String denominacion, String descripcion) {
        this.id = id;
        this.denominacion = denominacion;
        this.descripcion = descripcion;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return denominacion;
    }
    
    @Override
    public boolean equals(Object obj) {
        // Si es el mismo objeto, es igual
        if (this == obj) {
            return true;
        }
        // Si el otro es nulo o no es de la clase Categoria, no es igual
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        // Comparamos los IDs
        final Categoria other = (Categoria) obj;
        if (this.id == null || other.id == null) {
            return false;
        }
        return this.id.equals(other.id);
    }

    @Override
    public int hashCode() {
        // Un hashCode basado en el ID
        return (id != null ? id.hashCode() : 0);
    }
   
}
