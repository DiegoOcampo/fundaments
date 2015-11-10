package GUI;

import Datos.Sistema;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Hereda de JPanel y es el lugar donde van ubicados los campos requeridos para
 * registrar un usuario nuevo.
 *
 * @author Juan Diego Ocampo
 * @version 16/05/2014
 */
public class PanelInformacionRegistro extends JPanel implements ActionListener, KeyListener {

    JLabel lblNombre, lblCedula, lblCodigo, lblUsuario;
    JTextField txtNombre, txtCedula, txtCodigo, txtUsuario;

    /**
     * En este constructor se inicializan, distribuyen y ubican los diferentes
     * campos para el registro.
     */
    public PanelInformacionRegistro() {
        setLayout(new GridLayout(4, 4, 5, 5));
        lblNombre = new JLabel("Nombre");
        lblCedula = new JLabel("Cedula");
        lblCodigo = new JLabel("Código");
        lblUsuario = new JLabel("Usuario");
        txtNombre = new JTextField("");
        txtCedula = new JTextField("");
        txtCodigo = new JTextField("");
        txtUsuario = new JTextField("");
        txtNombre.addKeyListener(this);
        txtCedula.addKeyListener(this);
        txtCodigo.addKeyListener(this);
        add(lblNombre);
        add(new JLabel(""));
        add(txtNombre);
        add(new JLabel(""));
        add(lblCedula);
        add(new JLabel(""));
        add(txtCedula);
        add(new JLabel(""));
        add(lblCodigo);
        add(new JLabel(""));
        add(txtCodigo);
        add(new JLabel(""));
        add(lblUsuario);
        add(new JLabel(""));
        add(txtUsuario);
    }

    /**
     * Se obtiene la cadena de texto ingresada en el campo txtNombre
     *
     * @return nombre, donde se almacena la información que se ingresó en el
     * campo txtNombre.
     */
    public String getNombre() {
        String nombre = txtNombre.getText();
        return nombre;
    }

    /**
     * Se obtiene la cadena de texto ingresada en el campo txtUsuario
     *
     * @return donde se almacena la información que se ingresó en el campo
     * txtUsuario.
     */
    public String getUsuario() {
        String usuario = txtUsuario.getText();
        return usuario;
    }

    /**
     * Se obtiene el número que fue ingresado en el campo txtCedula, para esto
     * hay que hacer un casteo a tipo long.
     *
     * @return cedula, la variable de tipo long donde está el número de la
     * cedula.
     */
    public long getCedula() {
        long cedula = Long.parseLong(txtCedula.getText());
        return cedula;
    }

    /**
     * Se obtiene el número que fue ingresado en el campo txtCodigo, para esto
     * hay que hacer un casteo a tipo entero.
     *
     * @return codigo, la variable de tipo int donde está el número del código.
     */
    public int getCodigo() {
        int codigo = Integer.parseInt(txtCodigo.getText());
        return codigo;
    }

    /**
     * Se encarga de borrar la información que ha sido ingresada en los campos
     * de registro.
     */
    public void Limpiar() {
        txtCedula.setText("");
        txtCodigo.setText("");
        txtNombre.setText("");
        txtUsuario.setText("");
    }

    /**
     * Se sobrescribe el método actionPerformed, se hace la validación de la
     * información que fue ingresada en los campos de registro, si esta es
     * correcta se procede a la creación del nuevo usuario, de lo contrario
     * manda un mensaje de error.
     *
     * @param e, es el parámetro que recibe el evento que produce el usuario.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Sistema sis = Sistema.ObtenerSistema();
        String nom = txtNombre.getText();
        String us = txtUsuario.getText();

        long ced = 0;
        int cod = 0;
        try {
            ced = Long.parseLong(txtCedula.getText());
            cod = Integer.parseInt(txtCodigo.getText());

        } catch (NumberFormatException error) {
        }
        if (e.getActionCommand().equals("ACEPTAR") && sis.ValidarRegistro(nom, ced, us, cod)) {
            if (sis.agregarUsuario(nom, ced, us, cod)) {
                JOptionPane.showMessageDialog(null, "El usuario " + us + " fue registrado");
                Limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Datos inválidos");
        }
    }

    /**
     * se sobrescribe el metodo KeyTyped, y se encarga de que los campos
     * txtCodigo y txtCedula solo reciban números, y el campo txtNombre solo
     * letras, además que el campo txtcodigo reciba como maximo 5 caracteres.
     *
     * @param e, el parámetro que recibe el evento producido por el usuario.
     */
    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == txtCodigo) {
            char entrada = e.getKeyChar();
            try {
                int num = Integer.parseInt("" + e.getKeyChar());
            } catch (Exception ev) {
                e.consume();
            }
        }
        if (e.getSource() == txtCedula) {
            char entrada = e.getKeyChar();
            try {
                int num = Integer.parseInt("" + e.getKeyChar());
            } catch (Exception ev) {
                e.consume();
            }
        }
        if (e.getSource() == txtNombre) {
            char entrada = e.getKeyChar();
            try {
                int num = Integer.parseInt("" + e.getKeyChar());
                e.consume();
            } catch (Exception ev) {
            }
        }
        if(txtCodigo.getText().length()==InicioSesion.LIMITE){
            e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
