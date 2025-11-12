package com.paradigmas.tpfinalventas.objetos;

import java.util.Date;
import java.util.List;

public class Factura {
    
    private Integer id;
    private String numeroFactura;
    private Date fecha;
    private List<LineaFactura> lineaFactura;
    private Cliente cliente;
    private Double total;
    private FormaPago formaDePago;
    private String observaciones;

    public Factura() {
    }

    public Factura(Integer id, String numeroFactura, Date fecha, List<LineaFactura> lineaFactura, Cliente cliente, Double total, FormaPago formaDePago, String observaciones) {
        this.id = id;
        this.numeroFactura = numeroFactura;
        this.fecha = fecha;
        this.lineaFactura = lineaFactura;
        this.cliente = cliente;
        this.total = total;
        this.formaDePago = formaDePago;
        this.observaciones = observaciones;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
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

    public FormaPago getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(FormaPago formaDePago) {
        this.formaDePago = formaDePago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<LineaFactura> getLineaFactura() {
        return lineaFactura;
    }

    public void setLineaFactura(List<LineaFactura> lineaFactura) {
        this.lineaFactura = lineaFactura;
    }
}
