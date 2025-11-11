package com.paradigmas.tpfinalventas.objetos;

public class FormaPago {
    private Integer id;
    private String descripcion;

    public FormaPago() {
    }

    public FormaPago(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
