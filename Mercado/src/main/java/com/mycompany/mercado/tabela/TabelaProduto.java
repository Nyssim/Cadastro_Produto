
package com.mycompany.mercado.tabela;

import com.mycompany.conectamysql.PersistenciaProduto;
import com.mycompany.mercado.classe.ClasseProduto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelaProduto extends AbstractTableModel{
    private String[] colunas = {"Id", "Nome", "Codigo de Barra", "Preço", "Quantidade"};
    private List<ClasseProduto> listaDeProduto;
    private PersistenciaProduto persistir = new PersistenciaProduto();
    
    public TabelaProduto() {
        this.listaDeProduto = new ArrayList<>();
        this.listaDeProduto = persistir.listarTodosOsProduto();
    }
    
    private void atualizarLista(){
        persistir = new PersistenciaProduto();
        this.listaDeProduto = persistir.listarTodosOsProduto();
    }
    
    public ClasseProduto pegarProduto(int linha) {
        return this.listaDeProduto.get(linha);
    }
    
    public void adicionarUsuario(ClasseProduto prod) {
        persistir = new PersistenciaProduto();
        persistir.salvarProduto(prod);
        atualizarLista();
        fireTableDataChanged();
    }
    
    public void atualizarProduto(ClasseProduto prod) {
        persistir = new PersistenciaProduto();
        persistir.atualizarProduto(prod);
        atualizarLista();
        fireTableDataChanged();
    }
    
    public void removerProduto(Long idProduto) {
        persistir = new PersistenciaProduto();
        persistir.excluirProduto(idProduto);
        atualizarLista();
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return this.listaDeProduto.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return this.listaDeProduto.get(rowIndex).getId();
            case 1:
                return this.listaDeProduto.get(rowIndex).getNome();
            case 2:
                return this.listaDeProduto.get(rowIndex).getCodigoBarra();
            case 3:
                return this.listaDeProduto.get(rowIndex).getPreco();
            case 4:
                return this.listaDeProduto.get(rowIndex).getQuantidade();
                
            default:
                return this.listaDeProduto.get(rowIndex);
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return this.colunas[columnIndex];
    }
    
    
}
