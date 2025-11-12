package com.paradigmas.tpfinalventas.ui.grilla;

import com.paradigmas.tpfinalventas.objetos.Cliente;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class GrillaCliente extends AbstractTableModel{
    
    private ArrayList<Cliente> clientes = new ArrayList<>();
    
    public GrillaCliente(ArrayList<Cliente> datos) {
        this.clientes = datos;
    }
    
    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
         return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = clientes.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> cliente.getId();
            case 1 -> cliente.getNombre();
            case 2 -> cliente.getApellido();
            case 3 -> cliente.getDocumento();
            case 4 -> cliente.getDireccion();
            case 5 -> cliente.getFechaNacimiento();
            default -> "";
        };
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "ID";
            case 1 -> "Nombre";
            case 2 -> "Apellido";
            case 3 -> "Documento";
            case 4 -> "Direccion";
            case 5 -> "Fecha Nacimiento";
            default -> "";
        };
    }
    
}
