
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
 * Es un panel donde solo se coloca un botón.
 * 
 * @author Juan Diego Ocampo 
 * @version 23/05/2014
 */
public class PanelSalirReporte extends JPanel implements ActionListener{
    JButton btnSalir;
    Reporte reporte;
    /**
     * Se da toda la información necesaria para la agregación de este botón salir.
     * @param reporte, recibe este parametro para crear la relación con la clase Reporte.
     */
    public PanelSalirReporte(Reporte reporte){
        setLayout(new FlowLayout(FlowLayout.CENTER));
        Icon iconoAtras=new ImageIcon("/Imagenes/atras.png");
        btnSalir=new JButton("Atras",iconoAtras);
        btnSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/atras.png")));
        btnSalir.addActionListener(this);
        btnSalir.setPreferredSize(new Dimension(100,30));
        add(btnSalir);
        this.reporte=reporte;
    }
    /**
     * Se sobrescribe el método actionPerformed, se usa para dar funcionalidad al botón btnSalir, 
     * el cual se encarga de devolverse a la interfaz gráfica de las autoridades  públicas.
     * 
     * @param e, es el evento que recibe por parte del usuario. 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnSalir){
            AutoridadesPublicas autoridades=new AutoridadesPublicas();
            autoridades.setVisible(true);
            reporte.dispose();
        }
    }
}
