package Interfaz;

/**
 *
 * @author jomel
 */
public class Usuario {
    
    private String Nombre;

    public String getNombre() {
        return Nombre;
    }

    public String getContra() {
        return Contra;
    }
    private String Contra;
    public Usuario(String Nombre, String Contra){
        this.Nombre = Nombre;
        this.Contra= Contra;
    }
}
