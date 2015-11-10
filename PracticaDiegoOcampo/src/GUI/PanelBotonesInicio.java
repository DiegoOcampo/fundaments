package GUI;

import Datos.Sistema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Clase PanelBotonesInicio, hereda de JPanel, es un panel que contiene los
 * botones que se pondrán en el Frame InicioSesion.
 *
 * @author Juan Diego Ocampo
 * @version 15/05/2014
 */
public class PanelBotonesInicio extends JPanel implements ActionListener {

    private JButton btnIngresar, btnRegistrar;
    private PanelInformacionInicio panelInformacionInicio;
    private InicioSesion inicio;

    /**
     * El constructor de la clase donde se da toda la información necesaria a
     * los botones.
     *
     * @param panelInformacionInicio es del tipo PanelInformacionInicio
     * @param inicio es del tipo InicioSesion
     */
    public PanelBotonesInicio(PanelInformacionInicio panelInformacionInicio, InicioSesion inicio) {
        setLayout(null);
        Icon iconok = new ImageIcon("/Imagenes/ok.png");
        Icon iconRegistrar = new ImageIcon("/Imagenes/register.png");
        btnIngresar = new JButton("Ingresar", iconok);
        btnRegistrar = new JButton("Registrar", iconRegistrar);
        btnIngresar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ok.png")));
        btnRegistrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/register.png")));
        btnIngresar.setBounds(120, 50, 130, 40);
        btnRegistrar.setBounds(260, 50, 130, 40);
        btnIngresar.setActionCommand("INGRESAR");
        btnIngresar.addActionListener(panelInformacionInicio);
        btnRegistrar.addActionListener(this);
        add(btnIngresar);
        add(btnRegistrar);
        this.panelInformacionInicio = panelInformacionInicio;
        this.inicio = inicio;
    }

    /**
     * Se sobrescribe el método actionPerformed, donde se establece la acción del botón
     * btnRegistrar, el cual se encarga de crear una instancia de la clase Registro
     * para así abrir una nueva ventana y ocultar la que se está usando en dicho momento.
     *
     * @param e es el evento que ocurre
     */
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnRegistrar) {
            Registro registro = new Registro();
            inicio.hide();
            registro.setVisible(true);
        }

    }
}
