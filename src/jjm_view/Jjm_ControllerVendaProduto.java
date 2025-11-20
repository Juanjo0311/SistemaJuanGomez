/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jjm_view;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import bean.JjmUsuarios;
import bean.JjmVendaProdutos;


/**
 *
 * @author clari
 */
public class Jjm_ControllerVendaProduto extends AbstractTableModel {
    private List lstVendasProdutos;
    
    public void setList(List lstVendasProdutos){
     this.lstVendasProdutos = lstVendasProdutos;  
    }
    
    public Object getBean(int rowIndex){
        return (JjmVendaProdutos) lstVendasProdutos.get(rowIndex);
    }
    
    public void addBean (JjmVendaProdutos jjmVendaProdutos){
        this.lstVendasProdutos.add(jjmVendaProdutos);
        this.fireTableDataChanged();
    }
    
    public void removeBean (int rowIndex){
        this.lstVendasProdutos.remove(rowIndex);
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return lstVendasProdutos.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        JjmVendaProdutos jjmVendaProdutos = (JjmVendaProdutos) lstVendasProdutos.get(rowIndex);
        if (columnIndex == 0){
           return jjmVendaProdutos.getJjmProdutos().getJjmIdProduto();
        } else if (columnIndex ==1) {
            return jjmVendaProdutos.getJjmProdutos().getJjmNome();        
        } else if (columnIndex ==2) {
            return jjmVendaProdutos.getJjmQuantidade();
        } else if (columnIndex ==3) {
            return jjmVendaProdutos.getJjmValorUnitario();
        } else if (columnIndex ==4) {
            return jjmVendaProdutos.getJjmQuantidade()* jjmVendaProdutos.getJjmValorUnitario();
        }
        return "";
        
    }
        
    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Nome";         
        } else if ( columnIndex == 2) {
            return "Quantidade";
        } else if ( columnIndex == 3) {
            return "Valor Unitário";
        }  else if ( columnIndex == 4) {
            return "Total";
        }
        return "";
    }
    
}