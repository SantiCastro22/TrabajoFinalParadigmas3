package com.paradigmas.tpfinalventas.ui.grilla;

import com.paradigmas.tpfinalventas.objetos.TipoCliente;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class GrillaTipoCliente extends AbstractTableModel{
    private ArrayList<TipoCliente> tiposCliente = new ArrayList<>();

    public GrillaTipoCliente(ArrayList<TipoCliente> datos) {
        this.tiposCliente = datos;
    }

    @Override
    public int getRowCount() {
        return tiposCliente.size(); 
    }

    @Override
    public int getColumnCount() {
        return 3; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
          TipoCliente c = tiposCliente.get(rowIndex);
                
          switch(columnIndex){
              case 0: return c.getId();
              case 1: return c.getNombre();
              case 2: return c.getDescripcion();
              default: return "";
          }

    }

    @Override
    public String getColumnName(int column) {
        
        switch(column){
            case 0: return "ID";
            case 1: return "DENOMINACION";
            case 2: return "DESCRIPCION";
            default: return "";
        }
        
    }
    
   public TipoCliente getCategoriaFromRow(int rowIndex){
   
            return tiposCliente.get(rowIndex);
   }
    
}
