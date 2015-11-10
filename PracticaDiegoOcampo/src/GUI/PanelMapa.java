/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Esta clase es un panel, el cual contiene la imagen de un mapa.
 * 
 * @author Juan Diego Ocampo
 * @version 23/05/2014
 */
public class PanelMapa extends JPanel {
    PanelTabla panelTabla;
    
    /**
     * En este constructor solo se establece el layout que será utilizado y se inicializa la variable panelTabla.
     * 
     * @param panelTabla, se encatga de establecer la relación con el panel donde se encuentra ubicada la taba de los reportes. 
     */
    public PanelMapa(PanelTabla panelTabla){ 
        setLayout(new BorderLayout());
        this.panelTabla=panelTabla;
    }
    /**
     * Se sobrescribe el método paint, y lo que hace en este caso es "dibujar" una imagen
     * de un mapa y unos puntos sobre esta los cuales representan la ubicación actual
     * de los drones.
     * 
     * @param g es con el elemento que dibujamos las diferentes figuras.
     */
    @Override
    public void paint(Graphics g){
        ImageIcon mapa = new ImageIcon(getClass().getResource("/Imagenes/mapa.png")); 
        g.drawImage(mapa.getImage(), 20, 20, null);
        int x=30;
        int y=40;
        for(int i=0;i<panelTabla.obtenerNumeroFilas();i++){
            g.fillOval(x, y, 5, 5);
            x+=(int)(Math.random()*85+1);
            y+=(int)(Math.random()*40+1);
        }
    }

    
}
