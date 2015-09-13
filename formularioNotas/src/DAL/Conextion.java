package DAL;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Conextion {
	public Connection conn;
    public static Conextion instancia;
    private String consulta;
    private ResultSet listaResultado;
    
    //se crea la conexion con la base de datos
     private Conextion() {
        String dbhost= "localhost";
        String dbName = "formularionotas";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "";
        try {
            Class.forName(driver).newInstance();
            this.conn = (Connection)DriverManager.getConnection("jdbc:mysql://"+dbhost+"/"+dbName,userName,password);
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
     
    //si no hay conexion entonces crea una conexion 
    public static synchronized Conextion getConexion() {
        if ( instancia == null ) {
            System.out.println("Creando la instancia");
            instancia = new Conextion();
        }
        else System.out.println("Instancia ya esta creada");
        return instancia;
 
    } 
    
    //creacmo la consulta en un string
    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

    //devolvemos los resultados de la consulta
    public ResultSet getListaResultado() {
        return listaResultado;
    }
    
    //se realiza la consulta y se almacena en la variable listaResultado
    public void consultar(){
        Statement statement;
        try {
            statement = (Statement) instancia.conn.createStatement();
            System.out.println(this.consulta);
            this.listaResultado = statement.executeQuery(this.consulta);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);            
        }  
    }
    
    //realiza insercion borrado y actualizacion de la base da datos
    public boolean ejecutar() {
        Statement statement;
        try {
            statement = (Statement) instancia.conn.createStatement();
            System.out.println(this.consulta);
            statement.execute(this.consulta);
            return true;
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
           return false;
        } 
        
    }


}
