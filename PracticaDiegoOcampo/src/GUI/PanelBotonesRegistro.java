package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Hereda de JPanel, donde están ubicados los dos botones que contiene la
 * ventana de registro.
 *
 * @author Juan Diego Ocampo
 * @version 16/05/2014
 */
public class PanelBotonesRegistro extends JPanel implements ActionListener {

    private JButton btnAceptar, btnSalir;
    private Registro registro;

    /**
     * Se inicializan y agregan los botones en este panel.
     *
     * @param registro, establece la relación con la clase Registro
     * @param informacionRegistro , establece una relación con el
     * PanelInformacionRegistro.
     */
    public PanelBotonesRegistro(Registro registro, PanelInformacionRegistro informacionRegistro) {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        Icon iconAceptar = new ImageIcon("/Imagenes/ok.png");
        Dimension dboton = new Dimension(130, 40);
        btnAceptar = new JButton("Aceptar", iconAceptar);
        btnAceptar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ok.png")));
        btnAceptar.setPreferredSize(dboton);
        btnAceptar.setActionCommand("ACEPTAR");
        btnAceptar.addActionListener(informacionRegistro);
        add(btnAceptar);

        Icon iconSalir = new ImageIcon("/Imagenes/salir.png");
        btnSalir = new JButton("Salir", iconSalir);
        btnSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/salir.png")));
        btnSalir.setPreferredSize(dboton);
        btnSalir.addActionListener(this);
        add(btnSalir);
        this.registro = registro;
    }

    /**
     * Se sobrescribe el método actionPerformed, se encarga de capturar un
     * evento que se hace con los botones, en este caso solo con el botón
     * btnSalir, que se encarga de retroceder a la ventana anterior(Inicio de Sesión).
     *
     * @param e, es la variable que recibe el evento.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSalir) {
            registro.Salir();
        }
    }
}
