
package GUI;

import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 *Es la ventana de los reportes que crea el usuario.
 * 
 * @author Juan Diego Ocampo
 * @version 23/05/2014
 */
public class Reporte extends JFrame {
    PanelTabla panelTabla;
    PanelMapa panelMapa;
    PanelSalirReporte panelSalir;
    /**
     * En el constructor se organiza la estructura de la ventana y sa agregan los tres paneles que estaran ubicados en ella.
     */
    public Reporte(){
        setSize(400,550);
        setTitle("Reportes");
        setLayout(new GridLayout(3,1));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(this);
        panelTabla=new PanelTabla();
        add(panelTabla);
        panelMapa=new PanelMapa(panelTabla);
        add(panelMapa);
        panelSalir=new PanelSalirReporte(this);
        add(panelSalir);

    }


}
