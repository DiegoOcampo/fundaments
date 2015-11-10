package GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

/**
 * Clase PanelReporteAutoridades, hereda de JPanel, es el panel que contiene el
 * JTextArea para la creación de un reporte.
 *
 * @author Juan Diego Ocampo
 * @version 2014/05/06
 */
public class PanelReporteAutoridades extends JPanel {

    private JTextArea txtReporte;

    /**
     * En el constructor se da la especificación del área de texto del reporte.
     *
     * @param panelInformacion, crea una relación con
     * PenelInformacionAutoridades.
     */
    public PanelReporteAutoridades(PanelInformacionAutoridades panelInformacion) {
        TitledBorder border = BorderFactory.createTitledBorder("Reporte");
        this.setBorder(border);
        setLayout(null);
        txtReporte = new JTextArea();
        txtReporte.setBounds(100, 20, 200, 100);
        txtReporte.setLineWrap(true);
        add(txtReporte);
    }

    /**
     * Este método borra la información que está en el JTextArea txtInforme.
     */
    public void limpiar() {
        txtReporte.setText("");
    }
    /**
     * Se obtiene la información que fue ingresada en el campo de reporte.
     * @return lo que el usuario ingreso en el campo de reporte.
     */
    public String ObtenerReporte(){
        return txtReporte.getText();
    }
    /**
     * Crea un reporte nuevo, verificando que los datos necesarios si sean
     * diligenciados. Dependiendo de los resultados de verificación, muestra un
     * mensaje diferente.
     */
    public boolean crearReporte() {
        String informe = txtReporte.getText();
        boolean res = false;
        if (informe.equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese el reporte");
        } else {
            JOptionPane.showMessageDialog(null, "El reporte: \n" + informe + "\n Ha sido creado");
            this.limpiar();
            res = true;
        }
        return res;
    }

}
