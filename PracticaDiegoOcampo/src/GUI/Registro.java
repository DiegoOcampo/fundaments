package GUI;

import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 * La clase registro, hereda de JFrame y es la ventana de registro para un nuevo
 * usuario.
 *
 * @author Juan Diego Ocampo
 * @version 16/05/2014
 */
public class Registro extends JFrame {

    PanelInformacionRegistro informacionRegistro;
    PanelBotonesRegistro botonesRegistro;

    /**
     * En este constructor se ubican los paneles de la información y botones de
     * registro
     */
    public Registro() {
        setLayout(new GridLayout(2, 1));
        setSize(400, 300);
        setTitle("Registro");
        setLocationRelativeTo(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        informacionRegistro = new PanelInformacionRegistro();
        add(informacionRegistro);
        botonesRegistro = new PanelBotonesRegistro(this, informacionRegistro);
        add(botonesRegistro);
    }

    /**
     * Este método se encarga de ocultar el la instancia de esta clase y de
     * crear una del InicioSesion.
     */
    public void Salir() {
        InicioSesion inicio = new InicioSesion();
        inicio.setVisible(true);
        this.dispose();
    }
}
