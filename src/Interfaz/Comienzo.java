
package Interfaz;

//Creado Por Johnny Melgar (22311166)

public class Comienzo {
    public static Registro registro = new Registro();
    public static String Ingreso = "";
    public static void main(String[] args) {
        
        MenuInicial inicio = new MenuInicial();
        inicio.setBounds(0,0,400,300);
        inicio.setVisible(true);
        inicio.setLocationRelativeTo(null);
    }
    
}
