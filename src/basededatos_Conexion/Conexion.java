/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basededatos_Conexion;

import Modelo_clases.bicicleta;
import Modelo_clases.coche;
import Modelo_clases.moto;
import Modelo_clases.patin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import java.sql.PreparedStatement;


/**
 *
 * @author ikerr
 */
public class Conexion {

    public static Connection conn;

    public static Connection conectar() {
        try {

            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(
                    "jdbc:mysql://145.14.151.51/u812167471_registro_vehic", //Servidor y bbdd
                    "u812167471_registro_vehic", //Usuario autorizado
                    "AlquilerVehic-2024"); //Contraseña

        } catch (ClassNotFoundException | SQLException ex) {
            System.getLogger(Conexion.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        return conn;
    }

    public static void cerrarConexion() {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.getLogger(Conexion.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public static void cargasCombosProveedores(JComboBox combo) {

        try {
            String consulta = "SELECT proveedor FROM proveedores";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(consulta);

            while (rs.next()) {

                combo.addItem(rs.getString("proveedor"));
            }

        } catch (SQLException ex) {
            System.getLogger(Conexion.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }

    public static void cargasCombosEstados(JComboBox combo) {

        try {
            String consulta = "SELECT estado FROM estados";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(consulta);

            while (rs.next()) {

                combo.addItem(rs.getString("estado"));
            }

        } catch (SQLException ex) {
            System.getLogger(Conexion.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }

    public static boolean registrarBici(bicicleta cli) {

        try {
            String consultaInsert = "INSERT INTO bicicleta_electrica "
                    + "(codigoInterno, marca, proveedor, anyo_compra, estado, "
                    + "anyo_caducidad_bateria, autonomia_bateria) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement st = conn.prepareStatement(consultaInsert);

            st.setString(1, cli.getCii());
            st.setString(2, cli.getMarca());
            st.setString(3, cli.getProveedor());
            st.setInt(4, cli.getAnyoCompra());
            st.setString(5, cli.getEstado());
            st.setInt(6, cli.getNumCaducidadLlantas());
            st.setDouble(7, cli.getAutonomiaBateria());

            st.execute();
            return true;

        } catch (SQLException ex) {
            System.getLogger(Conexion.class.getName())
                    .log(System.Logger.Level.ERROR, (String) null, ex);
        }

        return false;
    }

    public static boolean registrarMoto(moto cli) {

        try {
            String consultaInsert = "INSERT INTO moto_electrica "
                    + "(codigoInterno, marca, proveedor, anoDeCompra, estado, "
                    + "anoDeRevision, autonomiaBateria, matricula) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement st = conn.prepareStatement(consultaInsert);

            st.setString(1, cli.getCii());
            st.setString(2, cli.getMarca());
            st.setString(3, cli.getProveedor());
            st.setInt(4, cli.getAnyoCompra());
            st.setString(5, cli.getEstado());
            st.setInt(6, cli.getNumRevision());
            st.setDouble(7, cli.getAutonomiaBateria());
            st.setString(8, cli.getMatricula());

            st.execute();
            return true;

        } catch (SQLException ex) {
            System.getLogger(Conexion.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        return false;
    }

    public static boolean registrarCoche(coche cli) {

        try {
            String consultaInsert = "INSERT INTO coche_electrico "
                    + "(codigoInterno, marca, proveedor, anyo_compra, estado, "
                    + "autonomiaBateria, matricula, codigoMunicipal) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement st = conn.prepareStatement(consultaInsert);

            st.setString(1, cli.getCii());
            st.setString(2, cli.getMarca());
            st.setString(3, cli.getProveedor());
            st.setInt(4, cli.getAnyoCompra());
            st.setString(5, cli.getEstado());
            st.setDouble(6, cli.getAutonomiaBateria()); 
            st.setString(7, cli.getMatricula());
            st.setString(8, cli.getCodIdentificacionMunicipal());

            st.execute();
            return true;

        } catch (SQLException ex) {
            System.getLogger(Conexion.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        return false;
    }

    public static boolean registrarPatin(patin cli) {

        try {
            String consultaInsert = "INSERT INTO patin_electrico "
                    + "(codigoInterno, marca, proveedor, anyo_compra, estado, "
                    + "numero_licencia, potencia, velocidad_maxima, autonomia_bateria) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement st = conn.prepareStatement(consultaInsert);

            st.setString(1, cli.getCii());
            st.setString(2, cli.getMarca());
            st.setString(3, cli.getProveedor());
            st.setInt(4, cli.getAnyoCompra());
            st.setString(5, cli.getEstado());
            st.setInt(6, cli.getNumLicencia());
            st.setDouble(7, cli.getPotencia());
            st.setDouble(8, cli.getVelocidadMaxima());
            st.setDouble(9, cli.getAutonomiaBateria());

            st.execute();
            return true;

        } catch (SQLException ex) {
            System.getLogger(Conexion.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return false;
    }
}