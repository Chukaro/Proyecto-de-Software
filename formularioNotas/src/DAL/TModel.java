package DAL;

import javax.swing.table.DefaultTableModel;

public class TModel extends DefaultTableModel {
	  Class[] types = new Class [] {
              java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
          };
  boolean[] canEdit = new boolean [] {
              false, true, false, false
          };
  
  public TModel(Object[][] data, Object[] columnNames){
      //unos valores por default :)
	  //TableModelDefault recibe estos parametros
	  //DefaultTableModel(Object[][] data, Object[] columnNames)
       super(data, columnNames);         
  }
  
  @Override
  public Class getColumnClass(int columnIndex) {
              return types [columnIndex];
          }

  @Override
  public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
  }

}
