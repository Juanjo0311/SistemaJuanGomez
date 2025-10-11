/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jjm_view;


import java.util.List;
import javax.swing.table.AbstractTableModel;
import bean.JjmProdutos;

/**
 *
 * @author u47443281803
 */
public class Jjm_ControllerProduto extends AbstractTableModel{

    List lista;
    
    public void setList(List lista){
     this. lista = lista;   
    }
    
    public Object getBean(int rowIndex){
        return lista.get(rowIndex);
    }
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        JjmProdutos produto = (JjmProdutos) lista.get(rowIndex);
        if (columnIndex == 0){
            return produto.getJjmIdProduto();
        }
        if (columnIndex == 1){
            return produto.getJjmNome();
        }
        if (columnIndex == 2){
            return produto.getJjmMarca();
        }
        if (columnIndex == 3){
            return produto.getJjmDataCadastro();
        }
        return "LP 4";
        
    }
        
    @Override
    public String getColumnName (int column) {
        if (column == 0) return "Código";
        if (column == 1) return "Nome";
        if (column == 2) return "Marca";
        if (column == 3) return "Data de Cadastro";
        return "";
    }
    
}
