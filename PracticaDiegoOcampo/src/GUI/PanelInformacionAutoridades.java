package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * ClasePanelInformacionAutoridades, hereda de JPanel, este panel contiene toda
 * la información acerca de las personas que ingresan al sistema los cuales
 * pertenecen a las autoridades públicas.
 *
 * @author Juan Diego Ocampo
 * @version 12/05/2014
 */
public class PanelInformacionAutoridades extends JPanel {

    static JTextField txtCedula, txtNombre, txtDireccion, txtTipodeProblema, txtDrone;
    JLabel lblCedula, lblNombre, lblDireccion, lblTipodeProblema, lblDrone;
    PanelInformacionInicio panelInformacionInicio;
    PanelReporteAutoridades panelReporte;

    /**
     * Crea todo lo que este panel contiene y le da sus especificaciones.
     *
     * @param panelReporte, crea una relación con el PanelReporteAutoridades
     * @param panelInformacion , crea una relación con el panelInformacionInicio
     */
    public PanelInformacionAutoridades(PanelReporteAutoridades panelReporte, PanelInformacionInicio panelInformacion) {
        setLayout(new GridLayout(5, 2, 2, 2));

        TitledBorder border = BorderFactory.createTitledBorder("Información");
        this.setBorder(border);

        Dimension dimensiontxt = new Dimension(120, 25);

        this.panelReporte = panelReporte;
        this.panelInformacionInicio = panelInformacionInicio;

        if (InformacionJTextField() == 0) {
            txtCedula = new JTextField("70675675");
            txtNombre = new JTextField("Andres");
            txtDireccion = new JTextField("Cr 28 N° 87 AA 22");
            txtDrone = new JTextField("XS89-00");
            txtTipodeProblema = new JTextField("Choque");
        } else if (InformacionJTextField() == 1) {
            txtCedula = new JTextField("2014983");
            txtNombre = new JTextField("Sebastian");
            txtDireccion = new JTextField("Cr 12 N° 87 norte");
            txtDrone = new JTextField("W84 -25");
            txtTipodeProblema = new JTextField("Robo");
        } else if (InformacionJTextField() == 2) {
            txtCedula = new JTextField("87764702");
            txtNombre = new JTextField("Freddy");
            txtDireccion = new JTextField("Cr 34 Calle 87 BB 12 sur");
            txtDrone = new JTextField("X87-R34");
            txtTipodeProblema = new JTextField("Desorden ");

        } else {
            txtCedula = new JTextField("87764702");
            txtNombre = new JTextField("Alejandra");
            txtDireccion = new JTextField("Cr 34 Calle 87 BB 12 sur");
            txtDrone = new JTextField("X87-R34");
            txtTipodeProblema = new JTextField("Robo");

        }

        txtCedula.setEnabled(false);
        txtNombre.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtDrone.setEnabled(false);
        txtTipodeProblema.setEnabled(false);

        txtCedula.setPreferredSize(dimensiontxt);
        txtNombre.setPreferredSize(dimensiontxt);
        txtDireccion.setPreferredSize(dimensiontxt);

        lblCedula = new JLabel("Cedula");
        lblNombre = new JLabel("Nombre");
        lblDireccion = new JLabel("Dirección");
        lblDrone = new JLabel("Drone");
        lblTipodeProblema = new JLabel("Tipo de problema");

        lblCedula.setPreferredSize(dimensiontxt);
        lblNombre.setPreferredSize(dimensiontxt);
        lblDireccion.setPreferredSize(dimensiontxt);

        add(lblCedula);
        add(txtCedula);
        add(lblNombre);
        add(txtNombre);
        add(lblDireccion);
        add(txtDireccion);
        add(lblDrone);
        add(txtDrone);
        add(lblTipodeProblema);
        add(txtTipodeProblema);

    }

    /**
     * Se encarga de buscar un número al azar entre el 0 y 3, que será utilizado
     * para ingresar la información de los JTextField que están en esta clase.
     *
     * @return numero, un número en el rango 0-3.
     */
    public int InformacionJTextField() {
        int numero = (int) (Math.random() * 3 + 1);
        return numero;
    }

    /**
     * Es el método para solicitar refuerzos, los cuales serán enviados a la
     * dirección que automáticamente diligencio el drone.
     */
    public void SolicitarRefuerzos() {
        JOptionPane.showMessageDialog(null, "Los refuerzos seran enviados a la dirección " + txtDireccion.getText());
    }
}
