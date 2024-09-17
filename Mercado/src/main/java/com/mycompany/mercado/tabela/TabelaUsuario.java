
package com.mycompany.mercado.tabela;

import com.mycompany.conectamysql.PersistenciaUsuario;
import com.mycompany.mercado.classe.ClasseUsuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelaUsuario extends AbstractTableModel{
    
    
    private String[] colunas = {"id", "nome", "perfil"};
    private List<ClasseUsuario> listaDeUsuario;
    private PersistenciaUsuario persistir = new PersistenciaUsuario();
    
    public TabelaUsuario() {
        this.listaDeUsuario = new ArrayList<>();
        this.listaDeUsuario = persistir.listarTodosOsUsuario();
    }
    
    private void atualizarLista() {
        persistir = new PersistenciaUsuario();
        this.listaDeUsuario = persistir.listarTodosOsUsuario();
    }
    
    public ClasseUsuario pegarUsuario(int linha) {
        return this.listaDeUsuario.get(linha);
    }
    
    public void adicionarUsuario(ClasseUsuario user) {
        persistir = new PersistenciaUsuario();
        persistir.salvarUsuario(user);
        atualizarLista();
        fireTableDataChanged();
    }
    
    public void atualizarUsuario(ClasseUsuario user) {
        persistir = new PersistenciaUsuario();
        persistir.atualizar(user);
        atualizarLista();
        fireTableDataChanged();
    }

   public void removerUsuario(Long idUsuario) {
        persistir = new PersistenciaUsuario();
        persistir.excluirUsuario(idUsuario);
        atualizarLista();
        fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return this.listaDeUsuario.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return this.listaDeUsuario.get(rowIndex).getId();
            case 1:
                return this.listaDeUsuario.get(rowIndex).getNome();
            case 2:
                return this.listaDeUsuario.get(rowIndex).getPerfil();
            default:
                return this.listaDeUsuario.get(rowIndex);
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return this.colunas[columnIndex];
    }
    
    public void pesquisar(ClasseUsuario user) {
        List<ClasseUsuario> aux = new ArrayList<>();
    }
}
