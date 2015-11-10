package Datos;

import java.util.ArrayList;

/**
 * La clase que representa a un usuario y su información.
 *
 * @author Juan Diego Ocampo
 * @version 16/05/2014
 */
public class Usuario {
    //PanelInformacionInicio panelInformacion;

    private String usuario = "";
    private int codigo = 0;
    private long cedula;
    private String nombre;
    private ArrayList<String> reportes;

    /**
     * El constructor de la clase que se encarga de inicializar el nombre de
     * usuario y código del usuario.
     *
     * @param usuario, el nombre de usuario del usuario
     * @param codigo, el código del usuario
     */
    public Usuario(String usuario, int codigo) {
        this.usuario = usuario;
        this.codigo = codigo;
        reportes = new ArrayList<String>();
    }
    /**
     * Se encarga de agregar a un ArrayList el reporte creado por el usuario activo.
     * @param reporte, es el reporte que envia el usuario.
     */
    public void AgregarReporte(String reporte) {
        this.reportes.add(reporte);
    }

    /**
     * Es el metodo que retorna los reportes que un usuario especifico ha creado
     *
     * @return reportes, son los reportes que este usuario ha creado
     */
    public ArrayList<String> getReporte() {
        return this.reportes;
    }

    /**
     * Se sobrescribe el método equals de la clase Object, se encarga de
     * comparar un usuario y lo hace por medio del nombre de usuario y el
     * código.
     *
     * @param ob, es del tipo objeto, con el cual se hace un casteo (casting)
     * para convertirlo al tipo Usuarios.
     * @return un valor booleano que es verdadero cuando se encuentra que el
     * usuario qu esta intentando ingresar es igual a este.
     */
    @Override
    public boolean equals(Object ob) {
        Usuario user = (Usuario) ob;
        if (this.getUsuario().equals(user.getUsuario())) {
            if (this.getCodigo() == user.getCodigo()) {
                return true;
            }
        }
        return false;
    }

    /**
     * devuelve el nombre de usuario que ha sido asiganado para este usuario.
     *
     * @return usuario, el nombre de usuario del usuario.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Obtiene el código del usuario actual.
     * 
     * @return codigo, el código del usuario.
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Establece un nuevo valor al nombre de usuario.
     * 
     * @param usuario, establece un nuevo valor para el nombre de usuario.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Establece un nuevo código para el actual usuario.
     * 
     * @param codigo,establece un nuevo valor para el código del usuario.
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Se obtiene la cedula del usuario que esta en el sistema.
     * 
     * @return cedula, la cedula del usuario.
     */
    public long getCedula() {
        return cedula;
    }

    /**
     * Establece un nuevo valor para la cedula del usuario.
     * 
     * @param cedula, establece un nuevo valor para la cedula del usuario.
     */
    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    /**
     * Se obtiene el nombre del usuario.
     * 
     * @return nombre, el nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Se establece un nuevo valor para el nombre del usuario.
     * 
     * @param nombre, establece un nuevo valor para el nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
