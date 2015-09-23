package DAL;

import javax.swing.table.DefaultTableModel;

public class TModel extends DefaultTableModel {
	  Class[] types = new Class [] {
              java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
          };
  boolean[] canEdit = new boolean [] {
              false, true, false, false
          };
  
  public TModel(){
      //unos valores por default :)
       super( new Object[][] { { "Producto A", 23, 21, (23+21) }, 
                               { "Producto B", 112, 2, (112+2) },
                               { "Producto C", 22, 1, (22+1) },
                               { "Producto D", 544, 2, (544+2) },
                               { "Producto E", 12, 3, (12+3) }
                             },
       new String[] { "Producto", "Valor editable", "Valor Fijo","Total" });         
     
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
