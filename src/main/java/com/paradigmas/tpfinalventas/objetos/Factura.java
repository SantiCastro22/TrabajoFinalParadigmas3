package com.paradigmas.tpfinalventas.objetos;

import java.util.Date;
import java.util.List;

public class Factura {
    
    private Integer id;
    private Date fecha;
    private List<LineaFactura> lineaFactura;
    private Cliente cliente;
    private Double total;
    private FormaPago formaDePago;
    private String observaciones;

    public Factura() {
    }

    public Factura(Date fecha, List<LineaFactura> lineaFactura, Cliente cliente, Double total, FormaPago formaDePago, String observaciones) {
        this.fecha = fecha;
        this.lineaFactura = lineaFactura;
        this.cliente = cliente;
        this.total = total;
        this.formaDePago = formaDePago;
        this.observaciones = observaciones;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
}
