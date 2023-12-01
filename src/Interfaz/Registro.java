package Interfaz;

import java.util.ArrayList;

/**
 *
 * @author jomel
 */
public class Registro {
    public static ArrayList<Usuario> Usuarios;
    
    public static boolean buscaUsuario(String Nombre, String Contra){
        for(Usuario user: Usuarios){
            if(user.getNombre() != null && user.getNombre().equals(Nombre) 
                    && user.getContra().equals(Contra)){
                return true;
            }
        }    
        return false;
    }
    public static boolean validarUsuario(String Nombre, String Contra){
        for(Usuario user: Usuarios){
            if(user.getNombre() != null && user.getNombre().equals(Nombre)){
                return false;
            }
        }    
        agregarUsuario(Nombre, Contra);
        return true;
    }
    
    public static void agregarUsuario(String Nombre, String Contra){
        Usuarios.add(new Usuario(Nombre, Contra));
    }
    
    public Registro(){
        Usuarios = new ArrayList();
    }
}
