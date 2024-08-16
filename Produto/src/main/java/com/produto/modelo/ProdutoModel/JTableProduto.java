/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.produto.modelo.ProdutoModel;

import com.produto.interfacegrafica.CadastroProduto;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Aluno
 */
public class JTableProduto extends AbstractTableModel {
    
    //Atriutos da Tabela
    
    private ArrayList<ProdutoModel>  listaDeProduto;
    private String[] colunas = {"Código","Produto","Código de Barras", "Unidade"};
    
    //Metodos da Tabela
    
    //Criar a lista que vai agrupar os dados da Tabela
    public JTableProduto() {
        this.listaDeProduto = new ArrayList<>();
    }
    
    //Metodo adicionar
    public void addProduto(ProdutoModel func) {
        this.listaDeProduto.add( func);
        fireTableDataChanged();
    }
    
    //Metodo deletar
    public void delProduto(int linha) {
        this.listaDeProduto.remove( linha);
        fireTableDataChanged();
    }
    
    //Metodo de Alterar
    public void altProduto(int linha) {
        
    }
    
    //Metodo de Alterar
    public void inaProduto(int linha) {
        
    }
    
    //Metodo de Ativar
    public void atiProduto(int linha) {
        
    }

    @Override
    public int getRowCount() {
        return listaDeProduto.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                 return this.listaDeProduto.get(rowIndex).getCodigo();
            case 1:
                return this.listaDeProduto.get(rowIndex).getCodigoBarra();
            case 2:
                return this.listaDeProduto.get(rowIndex).getNome();
            case 3:
                return this.listaDeProduto.get(rowIndex).getUnidade();
                
            default:
                return this.listaDeProduto.get(rowIndex);
        }
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return this.colunas[columnIndex];
    }
}
