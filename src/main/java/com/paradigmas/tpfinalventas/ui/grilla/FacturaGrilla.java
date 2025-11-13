package com.paradigmas.tpfinalventas.ui.grilla;

import com.paradigmas.tpfinalventas.objetos.Factura;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class FacturaGrilla extends AbstractTableModel {
    
    private List<Factura> facturas;
    
    public static int COLUMNS = 3;

    public FacturaGrilla(List<Factura> facturas) {
        this.facturas = facturas;
    }

    @Override
    public int getRowCount() {
        return facturas.size();
    }

    @Override
    public int getColumnCount() {
        return this.COLUMNS;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
           Factura c = facturas.get(rowIndex);
                
          switch(columnIndex){
              case 0: return c.getNumeroFactura();
              case 1: return c.getFecha();
              case 2: return c.getTotal();
              default: return "";
          }
    }

    @Override
    public String getColumnName(int column) {
        
        switch(column){
            case 0: return "Numero";
            case 1: return "Fecha";
            case 2: return "Total";
            default: return "";
        }
    }
    public Factura getFacturaByIndex(Integer index){
        return this.facturas.get(index);
    }
    
}
