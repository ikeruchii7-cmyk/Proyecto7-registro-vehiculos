/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

/**
 *
 * @author ikerr
 */

    import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Utilidades {
   
    public static boolean compruebaCampoVacio(JTextField campo) {
        return "".equals(campo.getText().trim());
    }
   
    public static void lanzaAlertaVacio(JTextField campo) {    
        JOptionPane.showMessageDialog(null,
                "El campo " + campo.getName() + " es obligatorio");
        campo.setBackground(Color.red);
        campo.requestFocus();
    }
   
    public static boolean compruebaComboNoSeleccionado(JComboBox combo) {
        return combo.getSelectedIndex() == 0;          
    }
    
    public static void lanzaAlertaCombo(JComboBox combo) {
        JOptionPane.showMessageDialog(null,
            "Debe seleccionar un elemento en el desplegable " + combo.getName());
    }
    
    static String conprobarDni = "[0-9]{8}[A-Za-z]{1}";

    public static boolean compruebaDni(JTextField campo) {
        return campo.getText().matches(conprobarDni);
    }

    public static void lanzaAlertaDni(JTextField campo) {
        JOptionPane.showMessageDialog(null,
                "El formato de DNI no es valido"
        );
        campo.setBackground(Color.red);

    }
    
    static String patronNombre = "[A-Za-zÁÉÍÓÚáéíóúÑñ\\s]+";
    
    public static boolean NombreValido(String nombre) {
        return nombre.matches(patronNombre);
    }
    
    public static void lanzaAlertaFormatoNombre(JTextField campo) {
        JOptionPane.showMessageDialog(null, 
                "El formato del nombre es incorrecto. Solo se permiten letras y espacios");
        campo.setBackground(Color.red);
        campo.requestFocus();
    }
    
    static String patronTelefono = "[0-9]{9}";
    
    public static boolean TelefonoValido(String telefono) {
        return telefono.matches(patronTelefono);
    }
    
    public static void lanzaAlertaFormatoTelefono(JTextField campo) {
        JOptionPane.showMessageDialog(null, 
                "El formato del teléfono es incorrecto. Debe contener 9 dígitos");
        campo.setBackground(Color.red);
        campo.requestFocus();
    }
    
    public static boolean compruebaEntero(JTextField campo) {
        String numeroTecleado = campo.getText();
        int minumero;
        
        try {
            minumero = Integer.parseInt(numeroTecleado);
            return true;
        } catch (NumberFormatException e) {
            return false;        
        }
    }
      
    public static void lanzaAlertaNumeroNoValido(JTextField campo) {
        JOptionPane.showMessageDialog(null,
                "El campo " + campo.getName() + " debe ser numérico");
    }
    
    public static boolean esNumero(String texto) {
    try {
        Integer.parseInt(texto);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}
}