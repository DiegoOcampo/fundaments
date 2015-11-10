package GUI;

import javax.swing.JFrame;

/**
 * Clase AutoridadesPublicas, hereda de JFrame, aquí se encuentran ubicados tres
 * paneles, además contiene la información y posibles acciones que las
 * autoridades públicas pueden realizar.
 *
 * @author Juan Diego Ocampo
 * @version 13/05/2014
 */
public class AutoridadesPublicas extends JFrame {

    PanelInformacionAutoridades panelInformacionAutoridades;
    PanelBotonesAutoridades panelBotones;
    PanelReporteAutoridades panelReporte;
    PanelInformacionInicio panelInformacionInicio;

    /**
     * EL constructor de la clase, donde se agregan los tres paneles y se da la
     * especificación de las ventanas.
     */
    public AutoridadesPublicas() {
        setSize(400, 500);
        setLayout(null);
        setTitle("Autoridades Públicas");
        setLocationRelativeTo(this);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        panelInformacionAutoridades = new PanelInformacionAutoridades(panelReporte, panelInformacionInicio);
        panelInformacionAutoridades.setBounds(0, 0, 400, 160);
        add(panelInformacionAutoridades);
        panelReporte = new PanelReporteAutoridades(panelInformacionAutoridades);
        panelReporte.setBounds(0, 170, 400, 140);
        add(panelReporte);
        panelBotones = new PanelBotonesAutoridades(panelInformacionAutoridades, panelReporte, this);
        panelBotones.setBounds(0, 280, 400, 220);
        add(panelBotones);
    }

    /**
     * Método que oculta el objeto en uso e instancia uno nuevo de InicioSesion.
     */
    public void Salir() {
        InicioSesion inicio = new InicioSesion();
        inicio.setVisible(true);
        this.dispose();
    }
}
