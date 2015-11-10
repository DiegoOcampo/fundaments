package GUI;

import Datos.Usuario;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Clase InicioSesion, hereda de JFrame, es la ventana principal, donde se
 * encuentra el ingreso al sistema.
 *
 * @author Juan Diego Ocampo
 * @version 2014/05/10
 */
public class InicioSesion extends JFrame {

    PanelInformacionInicio panelInformacionInicio;
    PanelBotonesInicio panelBotonesInicio;
    public final static int LIMITE=5;
    /**
     * Es el constructor de la clase, se distribuyen los paneles que esta clase
     * va a contener y se inicializa todo lo necesario para el Frame
     */
    public InicioSesion() {
        setSize(500, 400);
        setLayout(null);
        setTitle("Inicio de sesión");
        setLocationRelativeTo(this);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        panelInformacionInicio = new PanelInformacionInicio(this);
        panelInformacionInicio.setBounds(0, 0, 500, 180);
        add(panelInformacionInicio);
        panelBotonesInicio = new PanelBotonesInicio(panelInformacionInicio, this);
        panelBotonesInicio.setBounds(0, 180, 500, 220);
        add(panelBotonesInicio);
    }

    /**
     * método principal, para instanciar un nuevo objeto, este es el primero que
     * se ejecuta.
     *
     * @param args
     */
    public static void main(String[] args) {
        InicioSesion inicio = new InicioSesion();
        inicio.setVisible(true);

    }
}
