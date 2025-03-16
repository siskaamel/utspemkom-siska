/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package generic;
import java.util.ArrayList;
import java.util.List;
import java.swing.table.AbstractTableModel;
/**
 *
 * @author acer
 */
public class DataInventaris extends AbstractTableModel{
    List<Inventaris> list = new ArrayList<>();
    @Override
    public int getRowCount(){
        return list.size();
    }
    
    @Override
    synchronized
            public Object getValueAt(int rowIndex, int columnIndex){
                switch(columnIndex){
                    case 0 : return list.get(rowIndex).getFileName();
                    case 1 : return list.get(rowIndex).getFileSize();
                    default: return "";
                }
            }
            @Override
            public String getColumnName(int column){
                switch(column){
                    case 0 : return "NAMA BARANG";
                    case 1 : return "JUMLAH";
                    default: return"";
                }
            }
            
            public void set(int i, Inventaris n){
                list.set(i, n);
                fireTableDataChanged();
            }
            public void remove(int row){
                list.remove(row);
                fireTableRowsDeleted(row, row);
            }
            
            public Inventaris get(int row){
                return (Inventaris) list.get(row);
            }   
}
