package GUI;

import Datos.Sistema;
import Datos.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Clase PanelBotonesAutoridades, hereda de JPanel, es un panel donde se
 * encuentran todos los botones que estarán ubicados en la clase
 * AutoridadesPublicas.
 *
 * @author Juan Diego Ocampo
 * @version 13/05/2014
 */
public class PanelBotonesAutoridades extends JPanel implements ActionListener {

    private JButton btnRefuerzos, btnReportes, btnSalir, btnVerReporte;
    private PanelInformacionAutoridades panelInformacionAutoridades;
    private PanelReporteAutoridades panelReporte;
    private AutoridadesPublicas autoridades;

    /**
     * Se distribuyen todos los botones que estarán ubicados en el frame
     * AutoridadesPublicas
     *
     * @param panelInformacionAutoridades para crear la relación con el
     * PanelInformacionAutoridades
     * @param panelReporte para crear una relación con el
     * PanelReporteAutoridades
     * @param autoridades para crear una relación con el frame
     * AutoridadesPublicas
     */
    public PanelBotonesAutoridades(PanelInformacionAutoridades panelInformacionAutoridades, PanelReporteAutoridades panelReporte, AutoridadesPublicas autoridades) {
        setLayout(null);
        Icon iconRefuerzos = new ImageIcon("/Imagenes/refuerzos.png");
        Icon iconReporte = new ImageIcon("/Imagenes/reporte.png");
        Icon iconLimpiar = new ImageIcon("/Imagenes/cancelar.png");
        Icon iconSalir = new ImageIcon("/Imagenes/salir.png");
        Icon iconVer = new ImageIcon("/Imagenes/ver.png");
        btnRefuerzos = new JButton("Refuerzos", iconRefuerzos);
        btnReportes = new JButton("Reporte", iconReporte);
        btnSalir = new JButton("Salir", iconSalir);
        btnVerReporte = new JButton("Ver reportes",iconVer);
        btnRefuerzos.setIcon(new ImageIcon(getClass().getResource("/Imagenes/refuerzos.png")));
        btnReportes.setIcon(new ImageIcon(getClass().getResource("/Imagenes/reporte.png")));
        btnSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/salir.png")));
        btnVerReporte.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ver.png")));
        btnRefuerzos.setBounds(50, 40, 140, 40);
        btnReportes.setBounds(200, 40, 130, 40);
        btnSalir.setBounds(200, 90, 130, 40);
        btnVerReporte.setBounds(50, 90, 140, 40);
        btnRefuerzos.addActionListener(this);
        btnReportes.addActionListener(this);
        btnSalir.addActionListener(this);
        btnVerReporte.addActionListener(this);
        add(btnRefuerzos);
        add(btnReportes);
        add(btnSalir);
        add(btnVerReporte);
        this.panelInformacionAutoridades = panelInformacionAutoridades;
        this.panelReporte = panelReporte;
        this.autoridades = autoridades;
    }

    /**
     * Puede crear acciones con los botones: btnVerReporte que crea una nueva instancia de la clase Reporte
     * y asi obtenemos una nueva ventana, btnSalir que se devuelve al inicio de Sesión, btnRefuerzos que hace
     * una simulación de solicitud y muestra un mensaje diciendo que los refuerzos seran enviados a la 
     * dirección suministrada y btnReportes que crea un nuevo reporte del usuario que ingreso en el sistema.
     *
     * @param e, captura el evento realizado por el usuario.
     */
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnVerReporte){
            Reporte reporte=new Reporte();
            reporte.setVisible(true);
            autoridades.hide();
            
        }
        if (e.getSource() == btnSalir) {
            autoridades.Salir();
        }
        if (e.getSource() == btnRefuerzos) {
            panelInformacionAutoridades.SolicitarRefuerzos();
            panelReporte.limpiar();
        }
        if (e.getSource() == btnReportes) {
            Sistema sistema=Sistema.ObtenerSistema();
            Usuario user= sistema.obtenerUsuarioActivo();
            String reporteActual=panelReporte.ObtenerReporte();
            if(reporteActual.equals("")){
                
            }else{
                user.AgregarReporte(reporteActual);
            }
            panelReporte.crearReporte();

        }

    }
}
