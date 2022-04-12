package solucionJuego;
import java.sql.*;
public class ConexionBD {
	 Connection cn;
	    Statement st;
	    public Connection conexion() {
	        try{
	    Class.forName("com.mysql.jdbc.Driver");
	    cn =DriverManager.getConnection("jdbc:mysql://localhost/sofka","root","");
	    System.out.println("conexion exitosa");
	    }catch(Exception e){
	        System.out.println(e.getMessage());
	        System.out.println("Base de datos no encontrada");
	}return cn;       
	}
	  Statement createStatement(){
	  throw new UnsupportedOperationException("no conectado");
	  }  
}
