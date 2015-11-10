
package GUI;

import Datos.Sistema;
import Datos.Usuario;
import java.awt.Dimension;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Es el panel donde se encuantra la tabla de usuarios y reportes. 
 * @author Juan Diego Ocampo
 * @version 23/05/2014
 */
public class PanelTabla extends JPanel {
    JTable tabla;
    Vector<Usuario> usuarios;
    Sistema sis;
    private int numeroFilas;
    /**
     * En el constructor damos los titulos que van a tener las columnas de la tabla,
     * y asignamos los diferentes valores que va a contener la tabla,
     * los cuales pueden variar dependiendo de lo ingresado por el usuario.
     */
    public PanelTabla(){
        usuarios = Sistema.ObtenerSistema().getUsuarios();
        numeroFilas = 0 ;
        for (Usuario user : usuarios) {
            numeroFilas += user.getReporte().size();
        }
        String  [][]reporte = new String[numeroFilas][2];
        int fila = 0 ;
        //recorre el arreglo de usuarios
        for (Usuario user : usuarios){
            //Pregunta cuantos resportes genero el usuario
            for(int i  = 0;i < user.getReporte().size(); i++){
                reporte[fila][0] = user.getUsuario();
                reporte[fila][1] = user.getReporte().get(i);
                fila++;
            }
        }
        String nombreColumnas[]={"Usuario","Reporte"};        
        DefaultTableModel model=new DefaultTableModel(reporte, nombreColumnas);
        tabla=new JTable(model);
        tabla.setPreferredScrollableViewportSize(new Dimension(280,120));
        JScrollPane scrollPane=new JScrollPane(tabla);
        tabla.setPreferredScrollableViewportSize(new Dimension(280,120));
        add(scrollPane);
    }
    
    /**
     * Con este método obtenemos el número de filas que posee la tabla.
     * 
     * @return el número de filas de la tabla. 
     */
    public int obtenerNumeroFilas(){
        return numeroFilas;
    }
}