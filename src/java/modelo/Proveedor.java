/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author berliz
 */
public class Proveedor {
private String proveedor, direccion,telefono,nit;
    private int id_proveedor;

    Conexion cn;
    public Proveedor() {
    }
    public Proveedor(int id_proveedor, String proveedor, String nit, String direccion, String telefono) {
        this.proveedor = proveedor;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nit = nit;
        this.id_proveedor = id_proveedor;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }
    
    public DefaultTableModel leer(){
  DefaultTableModel tabla = new DefaultTableModel();
  try{
   cn = new Conexion();
   cn.abrir_con();
    String query;
    
        query = "SELECT idproveedores,proveedor,nit,direccion,telefono FROM proveedores;";
     ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
      
      String encabezado[] = {"idproveedores","proveedor","nit","direccion","telefono"};
      tabla.setColumnIdentifiers(encabezado);
      
      String datos[]=new String[5];
        
   while(consulta.next()){
      datos[0] = consulta.getString("idproveedores");
      datos[1] = consulta.getString("proveedor");
      datos[2] = consulta.getString("nit");
      datos[3] = consulta.getString("direccion");
      datos[4] = consulta.getString("telefono");
     
      tabla.addRow(datos);
      }
   cn.cerrar_con();
    
      
  }catch(SQLException ex){
      cn.cerrar_con();
      System.out.println("Error: " + ex.getMessage() );
  
  }
  return tabla;
  }
    

    //Funcion Crear
    public int crear(){
    int retorno=0;
        
        try{
         PreparedStatement parametro;
         cn = new Conexion();
         
         String query;
            query = "INSERT INTO proveedores(proveedor,nit,direccion,telefono) VALUES(?,?,?,?);";
         cn.abrir_con();
            parametro  = (PreparedStatement) cn.conexionBD.prepareStatement(query);
         
         parametro.setString(1, getProveedor());
         parametro.setString(2, getNit());
         parametro.setString(3, getDireccion());
         parametro.setString(4, getTelefono());
      
         
         int executar= parametro.executeUpdate();
         retorno = executar;
         cn.cerrar_con();
     }catch(HeadlessException | SQLException ex){
         System.out.println("Error"+ex.getMessage());
         }
        
        return retorno;
    }
    
    //Funcion Modificar
    public int modificar(){
    int retorno=0;
        
        try{
         PreparedStatement parametro;
         cn = new Conexion();
         cn.abrir_con();
         String query;
            query = "UPDATE proveedores SET proveedor=?,nit=?,direccion=?,telefono=? WHERE idproveedores=?;";
         parametro  = (PreparedStatement) cn.conexionBD.prepareStatement(query);
         
        
         parametro.setString(1, getProveedor());
         parametro.setString(2, getNit());
         parametro.setString(3, getDireccion());
         parametro.setString(4, getTelefono());
         parametro.setInt(5, this.getId_proveedor());
         
         int executar= parametro.executeUpdate();
         
         retorno = executar;
         cn.cerrar_con();
             }catch(HeadlessException | SQLException ex){
         System.out.println("Error"+ex.getMessage());
         }
        
        return retorno;
    }
    
    //Funcion Eliminar
    public int eliminar(){
    int retorno=0;
        
        try{
         PreparedStatement parametro;
         cn = new Conexion();
         cn.abrir_con();
         String query;
            query = "delete from proveedores where idproveedores=?;";
         parametro  = (PreparedStatement) cn.conexionBD.prepareStatement(query);
         parametro.setInt(1, getId_proveedor());
         int executar= parametro.executeUpdate();
         retorno = executar;
         cn.cerrar_con();
        }catch(HeadlessException | SQLException ex){
         System.out.println("Error"+ex.getMessage());
         }
        
        return retorno;
    }    
}
