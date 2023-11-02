/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author AUDITOR FAMILY
 */
public class General {
    public static DefaultTableModel model;
    private static  TableRowSorter sorter;
    public static void filterSearch(String query, JTable table){
          model = (DefaultTableModel)table.getModel();
          sorter = new TableRowSorter<>(model);
          table.setRowSorter(sorter);
          if(query.isEmpty()){
              sorter.setRowFilter(null);
          }else{
              RowFilter<TableModel, Object> filter = RowFilter.regexFilter(query, 1); // Adjust the column index as needed
              sorter.setRowFilter(filter);
          }
    }
}
    