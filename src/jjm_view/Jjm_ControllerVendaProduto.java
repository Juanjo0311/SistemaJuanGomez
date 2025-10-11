/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jjm_view;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import bean.JjmVendaProdutos;

/**
 *
 * @author u47443281803
 */
public class Jjm_ControllerVendaProduto extends AbstractTableModel {

    List lista;

    public void setList(List lista) {
        this.lista = lista;
    }

    public Object getBean(int rowIndex) {
        return lista.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Código";
        }
        if (column == 1) {
            return "Produto";
        }
        if (column == 2) {
            return "Quantidade";
        }
        if (column == 3) {
            return "Valor Unit.";
        }
        return "";
    }

}
