package DAL;

import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class TModelListener implements TableModelListener {
	 /**
     * @param e TableModelEvent
     */
    public void ajuste(TableModelEvent e ){
                
        //solo si se edita la tabla
        if ( e.getType() == TableModelEvent.UPDATE ) {
            
            //se obtiene el modelo
            TableModel modelo = ( (TableModel) ( e.getSource() ) );            
            int fila = e.getFirstRow();
            int columna = e.getColumn();
            if ( columna == 3 ) {return;}
             
            if(columna == 4){
            	try {                
            	 	//obtiene valor de celda editable
            	 	int a =  ((Number) modelo.getValueAt(fila,columna)).intValue();
            	 	//obtiene valor de celda no editable
            	 	int b =  ((Number) modelo.getValueAt(fila,columna+1)).intValue();
            	 	
            	 	int c =  ((Number) modelo.getValueAt(fila,columna+2)).intValue();
            	 	//restricción
            	 	//aqui se aumenta la restriccion de nota
                	if( a <= 0 && a <= 100){
                		JOptionPane.showMessageDialog( null , "Error: El valor debe ser entero positivo.");
                		modelo.setValueAt( null , fila, columna); 
                		modelo.setValueAt( null , fila, columna+3); 
                   		return;
                	}
                	                	
                	modelo.setValueAt( (a + b + c)/3, fila, columna+3);
                	
                	modelo.setValueAt( observacion((a + b + c)/3), fila, columna+4);
                	
                	
                
             	} catch (NullPointerException ex) { /*...*/ }
            }
            
            if(columna == 5){
            	try {                
            	 	//obtiene valor de celda editable
            	 	int a =  ((Number) modelo.getValueAt(fila,columna-1)).intValue();
            	 	//obtiene valor de celda no editable
            	 	int b =  ((Number) modelo.getValueAt(fila,columna)).intValue();
            	 	
            	 	int c =  ((Number) modelo.getValueAt(fila,columna+1)).intValue();
            	 	//restricción
            	 	//aqui se aumenta la restriccion de nota
                	if( a <= 0 && b <= 100){
                		JOptionPane.showMessageDialog( null , "Error: El valor debe ser entero positivo.");
                		modelo.setValueAt( null , fila, columna); 
                		modelo.setValueAt( null , fila, columna+2); 
                   		return;
                	}
                
                	modelo.setValueAt((a + b + c)/3, fila, columna+2);
                	modelo.setValueAt( observacion((a + b + c)/3), fila, columna+3);
                
             	} catch (NullPointerException ex) { /*...*/ }
            }
            
            if(columna == 6){
            	try {                
            	 	//obtiene valor de celda editable
            	 	int a =  ((Number) modelo.getValueAt(fila,columna-2)).intValue();
            	 	//obtiene valor de celda no editable
            	 	int b =  ((Number) modelo.getValueAt(fila,columna-1)).intValue();
            	 	
            	 	int c =  ((Number) modelo.getValueAt(fila,columna)).intValue();
            	 	//restricción
            	 	//aqui se aumenta la restriccion de nota
                	if( a <= 0 && c <= 100){
                		JOptionPane.showMessageDialog( null , "Error: El valor debe ser entero positivo.");
                		modelo.setValueAt( null , fila, columna); 
                		modelo.setValueAt( null , fila, columna+1); 
                   		return;
                	}
                
                	modelo.setValueAt( (a + b + c)/3, fila, columna+1);
                	
                	modelo.setValueAt( observacion((a + b + c)/3), fila, columna+2);
                
             	} catch (NullPointerException ex) { /*...*/ }
            }
            
            
        }
    }
    
    private String observacion(int prom){
    	String a = "Reprobado";
    	
    	if(prom >50)
    		a = "Aprobado"; 
    	
    	return a;
    }
    

	@Override
	public void tableChanged(TableModelEvent e) {
		// TODO Auto-generated method stub
		 ajuste(e);
	}

}
