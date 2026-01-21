/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basededatos_Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import Modelo_clases.bicicleta;
import Modelo_clases.coche;
import Modelo_clases.moto;
import Modelo_clases.patin;



/**
 * 
 * @author USUARIO
 */
public class Conexion {
    
    /**
     * Objeto de la clase Connection
     */
    public static Connection conn;
    
    /**
     * Método donde se establecen los parámetros de conexión con la base de datos.
     * Se llamará a este método previa realización de actividades en base de datos
     * 
     * @return
     */
    public static Connection conectar() {
        try {
            //Identificación del driver
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection(
                    "jdbc:mysql://145.14.151.51/u812167471_registro_vehic", //SERVIDOR Y BBDD
                    "u812167471_registro_vehic", //USUARIO AUTORIZADO
                    "AlquilerVehic-2024"); //CONTRASEÑA
                         
        } catch (ClassNotFoundException | SQLException ex) {
            System.getLogger(Conexion.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }               
       return conn; 
    }
    
    /**
     * Clase la cual permitirá cerras la conexión con la base de datos
     */
    public static void cerrarConexion() {
            
        try {
            conn.close();
        } catch (SQLException ex) {
            System.getLogger(Conexion.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    /**
     * Clase para poder elegir un proveedor de los posibles vehiculos
     * @param combo
     */
    public static void cargasComboProveedores (JComboBox combo){
        try {
            String consulta = "SELECT proveedor FROM proveedores";
            
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            while(rs.next()){
                combo.addItem(rs.getString("proveedor"));
            }
            
        } catch (SQLException ex) {
            System.getLogger(Conexion.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    /**
     * Clase para poder elegir un estado del vehiculo
     * @param combo
     */
    public static void cargasComboEstados (JComboBox combo){
        try {
            String consulta = "SELECT estado FROM estados";
            
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            while(rs.next()){
                combo.addItem(rs.getString("estado"));
            }
            
        } catch (SQLException ex) {
            System.getLogger(Conexion.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    /**
     * Clase para registrar el Patin
     * @param cli
     * @return
     */
    public static boolean registrarPatin (patin cli){
        try{
            String consultaInsert ="INSERT INTO patin_electrico" 
                    + "(codigoInterno, marca, proveedor, "
                    + "anyo_compra, estado, numero_licencia, "
                    + "potencia, velocidad_maxima, autonomia_bateria) "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement st= (PreparedStatement)conn.prepareStatement(consultaInsert);
            st.setString(1, cli.getCii());
            st.setString(2, cli.getMarca());
            st.setString(3, cli.getProveedor());
            st.setInt(4, cli.getAnyoCompra());
            st.setString(5, cli.getEstado());
            st.setInt(6, cli.getNumerolicencia());
            st.setDouble(7, cli.getPotencia());
            st.setDouble(8, cli.getVelocidadmaxima());
            st.setDouble(9, cli.getBateria());
            
            st.execute();
            
            return true;
        }catch (SQLException ex) {
            System.getLogger(Conexion.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        return false;
    }
    
    /**
     * Clase para registrar la Moto
     * @param cli
     * @return
     */
    public static boolean registrarMoto (moto cli){
        try{
            String consultaInsert ="INSERT INTO moto_electrica"
                    + "(codigoInterno, marca, proveedor, "
                    + "anyo_compra, estado, anoDeCompra, "
                    + "autonomiaBateria, matricula) "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement st= (PreparedStatement)conn.prepareStatement(consultaInsert);
            st.setString(1, cli.getCii());
            st.setString(2, cli.getMarca());
            st.setString(3, cli.getProveedor());
            st.setInt(4, cli.getAnyoCompra());
            st.setString(5, cli.getEstado());
            st.setInt(6, cli.getRevision());
            st.setDouble(7, cli.getBateria());
            st.setString(8, cli.getMatricula());
            
            st.execute();
            
            return true;
        }catch (SQLException ex){
            System.getLogger(Conexion.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }        
        return false;        
    }
    
    /**
     * Clase para registrar el Coche
     * @param cli
     * @return
     */
    public static boolean registrarCoche (coche cli){
        try{
            String consultaInsert ="INSERT INTO coche_electrico"
                    + "(codigoInterno, marca, proveedor, "
                    + "anyo_compra, estado, autonomiaBateria, "
                    + "matricula, codigoMunicipal) "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement st= (PreparedStatement)conn.prepareStatement(consultaInsert);
            st.setString(1, cli.getCii());
            st.setString(2, cli.getMarca());
            st.setString(3, cli.getProveedor());
            st.setInt(4, cli.getAnyoCompra());
            st.setString(5, cli.getEstado());
            st.setDouble(6, cli.getBateria());
            st.setString(7, cli.getMatricula());
            st.setString(8, cli.getCodigoIdentificacion());
            
            st.execute();
            
            return true;
        }catch (SQLException ex){
            System.getLogger(Conexion.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return false;
    }
    
    /**
     * Clase para registrar la Bicicleta
     * @param cli
     * @return
     */
    public static boolean registrarBicicleta (bicicleta cli){
        try{
            String consultaInsert ="INSERT INTO bicicleta_electrica"
                    + "(codigoInterno, marca, proveedor, "
                    + "anyo_compra, estado, anyo_caducidad_bateria, "
                    + "autonomia_bateria) "
                    + "values (?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement st= (PreparedStatement)conn.prepareStatement(consultaInsert);
            st.setString(1, cli.getCii());
            st.setString(2, cli.getMarca());
            st.setString(3, cli.getProveedor());
            st.setInt(4, cli.getAnyoCompra());
            st.setString(5, cli.getEstado());
            st.setInt(6, cli.getCaducidadLlantas());
            st.setDouble(7, cli.getBateria());
            
            st.execute();
            
            return true;
        }catch (SQLException ex){
            System.getLogger(Conexion.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return false;
    }
}