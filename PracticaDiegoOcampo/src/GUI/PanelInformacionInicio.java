package GUI;

import Datos.Sistema;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import Datos.Usuario;

/**
 * Clase PanelInformacionInicio, hereda de JPanel, es un panel que contiene los
 * campos de texto y las etiquetas que estarán en el frame InicioSesion.
 *
 * @author Juan Diego Ocampo.
 * @version 16/05/2014
 */
public class PanelInformacionInicio extends JPanel implements ActionListener, KeyListener {

    private JLabel lblUsuario, lblCodigo, lblInicioSesion;
    private JTextField txtUsuario;
    public JPasswordField txtCodigo;
    private InicioSesion inicio;

    /**
     * En el constructor se inicializan los atributos y se da la ubicación
     * dentro del panel.
     *
     * @param inicio para crear la relación con InicioSesion
     */
    public PanelInformacionInicio(InicioSesion inicio) {
        setLayout(null);
        lblInicioSesion = new JLabel("INICIO DE SESIÓN");
        lblUsuario = new JLabel("Usuario");
        lblCodigo = new JLabel("Código");
        txtUsuario = new JTextField("");
        txtCodigo = new JPasswordField("");
        txtUsuario.addActionListener(this);
        txtCodigo.addActionListener(this);
        txtCodigo.addKeyListener(this);
        lblInicioSesion.setFont(new Font("Arial", 0, 16));
        lblInicioSesion.setBounds(180, 8, 250, 80);
        lblUsuario.setBounds(140, 110, 100, 25);
        lblCodigo.setBounds(140, 140, 100, 25);
        txtUsuario.setBounds(250, 110, 120, 25);
        txtCodigo.setBounds(250, 140, 120, 25);
        add(lblInicioSesion);
        add(lblUsuario);
        add(lblCodigo);
        add(txtUsuario);
        add(txtCodigo);
        this.inicio = inicio;
    }

    /**
     * Se encarga de la instanciación de la clase AutoridadesPublicas, para así obtener una nueva ventana
     * a la cual tienen acceso las personas que tienen acceso al sistema de las fuerzas públicas.
     *
     * @param inicio, parámetro del tipo InicioSesion, en este caso se utiliza
     * para ocultar este objeto en un momento determinado
     */
    public void Entrar(InicioSesion inicio) {
        Sistema sis = Sistema.ObtenerSistema();
        String user = txtUsuario.getText();
        int cod = 0;
        try {
            cod = Integer.parseInt(txtCodigo.getText());
        } catch (NumberFormatException error) {
            //JOptionPane.showMessageDialog(null, "Valor de codigo invalido");
        }
        if (sis.ValidarEntrada(user, cod)) {
            JOptionPane.showMessageDialog(null, "Bienvenido " + user);
            AutoridadesPublicas autoridades = new AutoridadesPublicas();
            inicio.hide();
        } else {
            JOptionPane.showMessageDialog(null, "Datos inválidos");
        }


    }

    /**
     * Se sobrescribe el método actionPerformed, puede crear evento con los campos de texto txtUsuario y txtCodigo, y
     * el botón btnIngresar, que está representado por el comando "INGRESAR"
     * donde se invoca el método Entrar() con el parámetro inicio.
     *
     * @param e, es el parámetro que representa el evento realizado.
     */
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("INGRESAR")) {
            Entrar(inicio);
        }
        if (e.getSource() == txtUsuario) {
            Entrar(inicio);
        }

        if (e.getSource() == txtCodigo) {
            Entrar(inicio);
        }

    }

    /**
     * Se encarga de asegurarse que el JTextField txtCodigo solo reciba números y que su longitud maxima sea de 5.
     *
     * @param e, el parámetro que recibe el evento realizado
     */
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == txtCodigo) {
            char entrada = e.getKeyChar();
            try {
                int num = Integer.parseInt("" + e.getKeyChar());
            } catch (Exception ev) {
                e.consume();
            }
        }
        if(txtCodigo.getText().length()==InicioSesion.LIMITE){
            e.consume();
        }
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }
}
