package Datos;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 * Es la clase donde se administran los diferentes usuarios y su información.
 *
 * @author Juan Diego Ocampo
 * @version 23/05/2014
 */
public class Sistema {

    ArrayList<Usuario> usuarios;
    static Sistema sistema;
    Usuario usuarioActivo;

    /**
     * En esta ocasión el constructor es privado para no crear varias instancias
     * de esta clase, ya que solo se puede hacer en una oportunidad, tambien se
     * inicializan los tres primeros usuarios que tendran acceso al sistema.
     */
    private Sistema() {
        usuarios = new ArrayList();
        usuarios.add(new Usuario("Pol45", 123));
        usuarios.add(new Usuario("Tra65", 432));
        usuarios.add(new Usuario("Bomb67", 876));
    }

    /**
     * Se encarga de la verificación del sistema, es decir, ver que esta clase no haya
     * sido instanciado anteriormente, y si ya lo fue no permite instanciarla de nuevo.
     *
     * @return sistema, si no se ha creado una instancia de esta clase
     * anteriormente esta se crea, de lo contrario se retorna elmismo sistema.
     */
    public static Sistema ObtenerSistema() {
        if (sistema == null) {
            sistema = new Sistema();
        }
        return sistema;
    }

    /**
     * Es el método que se encarga de controlar y validar el ingreso al sistema de un usuario.
     *
     * @param usuario, es el usuario que está intentando ingresar al sistema.
     * @param codigo, es el código que representa al usuario que está intentando
     * ingresar al sistema.
     * @return res,el valor es verdadero cuando la información es correcta y el
     * usuario puede acceder al sistema, y falso en caso de que el usuario no
     * este en el sistema, por lo cual no puede ingresar.
     */
    public boolean ValidarEntrada(String usuario, int codigo) {
        boolean res = false;
        for (Usuario user : usuarios) {
            if (user.equals(new Usuario(usuario, codigo))) {
                usuarioActivo = user;
                res = true;
            }
        }
        return res;
    }

    /**
     * Se encarga de buscar la identificación del usuario que ingreso en el
     * sistema y asi la obtiene para su posterior uso.
     *
     * @return usuarioActivo, una variable del tipo Usuarios, donde esta la
     * información del usuario que esta haciedno uso de la aplicación en dicho
     * momento.
     */
    public Usuario obtenerUsuarioActivo() {
        return this.usuarioActivo;
    }

    /**
     * Verifica que no exista otro usuario con el mismo nombre de usuario, 
     * ya que si este existe, no se puede registrar a este usuario.
     *
     * @param user, el usuario que intenta registrarse en la aplicación.
     * @return res, este vaor es verdadero cuando existe otro usuario con el
     * mismo nombre de usuario, de lo contrario retorna falso.
     */
    public boolean encontrarUsuarioPorUser(String user) {
        boolean res = false;
        for (Usuario us : usuarios) {
            if (us.getUsuario().equals(user)) {
                res = true;
            }
        }
        return res;
    }

    /**
     * Se encarga de registrar los nuevos usuarios.
     *
     * @param nombre, el nombre del usuario.
     * @param cedula, el número de cédula del usuario.
     * @param usuario, el nombre de usuario.
     * @param codigo, el código del usuario.
     * @return res, el valor es verdadero cuando el nuevo usuario es agregado,
     * de lo contrario retorna falso.
     */
    public boolean agregarUsuario(String nombre, long cedula, String usuario, int codigo) {
        boolean res = false;
        Usuario us = new Usuario(usuario, codigo);
        if (encontrarUsuarioPorUser(usuario)) {
            JOptionPane.showMessageDialog(null, "El usuario ya existe.");
        } else {
            us.setNombre(nombre);
            us.setCedula(cedula);
            usuarios.add(us);
            res = true;
        }
        return res;
    }

    /**
     * Valida que todos los campos requeridos para el registro sean ingresados.
     *
     * @param nombre, el nombre del usuario que se está registrando.
     * @param cedula, el número de cédula del usuario que se está registrando.
     * @param usuario, el nombre de usuario del usuario que se está registrando.
     * @param codigo, el código del usuario que se está registrando.
     * @return res, este valor es verdadero cuando todos los datos fueron
     * diligenciados, y en caso de que por lo menos un dato haya sido pasado por
     * alto, retorna falso.
     */
    public boolean ValidarRegistro(String nombre, long cedula, String usuario, int codigo) {
        boolean res = true;
        if (nombre.equals("") || cedula == 0 || usuario.equals("") || codigo == 0) {
            res = false;
        }
        return res;
    }

    /**
     * Se encarga de buscar información de un usuario especifico dentro de los
     * usuarios existentes
     *
     * @return users, son los diferentes usuarios con la información
     * suministrada.
     */
    public Vector<Usuario> getUsuarios() {
        Vector<Usuario> users = new Vector<Usuario>();
        for (Usuario usuario : usuarios) {
            users.add(usuario);
        }
        return users;
    }
}
