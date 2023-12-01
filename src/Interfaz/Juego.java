
package Interfaz;

import javax.swing.border.Border;

/**
 *
 * @author jomel
 */
public class Juego extends javax.swing.JFrame implements java.awt.event.MouseListener{
    private javax.swing.JLabel turno;
    public javax.swing.JLabel casilla[][] = new javax.swing.JLabel[3][3];
    private String X0 = "X";
    private String Ingreso2;
    
    public Juego(String Jugador2){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        Ingreso2 = Jugador2;
        turno = new javax.swing.JLabel("Turno:" + Comienzo.Ingreso);
        turno.setFont(new java.awt.Font("Helvetica",1,30));
        turno.setBounds(0,10,200,30);
        add(turno);
        
        for(int fila = 0; fila < 3; fila++){
            for(int col =0; col <3; col++){
                casilla[fila][col] = new javax.swing.JLabel("");
                casilla[fila][col].setFont(new java.awt.Font("Helvetica",1,30));
                casilla[fila][col].setBounds(90*col,50+90*fila, 90,90);
                casilla[fila][col].setHorizontalAlignment(javax.swing.JLabel.CENTER);
                casilla[fila][col].setVerticalAlignment(javax.swing.JLabel.CENTER);
                Border border = new javax.swing.border.LineBorder
                (new java.awt.Color(0,0,0,255), 1);
                casilla[fila][col].setBorder(border);
                casilla[fila][col].addMouseListener(this);
                add(casilla[fila][col]);
            }
        }
        
    }
    
    public void mouseClicked(java.awt.event.MouseEvent evt){
        for(int fila = 0; fila < 3; fila++){
            for(int col =0; col <3; col++){
                if(evt.getSource() == casilla[fila][col]){
                    if(casilla[fila][col].getText().isEmpty()){
                        agregador(fila,col);
                    }else{
                        javax.swing.JOptionPane.showMessageDialog(null, "ERROR: Ese espacio ya esta seleccionado.",
                    "", javax.swing.JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }
    public void mouseEntered(java.awt.event.MouseEvent evt){
    //Por obligacion esta
    }
    public void mouseExited(java.awt.event.MouseEvent evt){
    //Por obligacion esta
    }
    public void mousePressed(java.awt.event.MouseEvent evt){
    //Por obligacion esta
    }
    public void mouseReleased(java.awt.event.MouseEvent evt){
    //Por obligacion esta
    }
    
    public void agregador(int fila, int col){
        casilla[fila][col].setText(X0);
        terminajuego();
        if(X0.equals("X")){
            turno.setText("Turno: " + Ingreso2);
            X0 = "0";
        }else{
            turno.setText("Turno: " + Comienzo.Ingreso);
            X0 = "X";
        }
    }
    
    public void terminajuego(){
        if(casillasvacia() == false){
            this.dispose();
        }
        if(ganaX() == true){
            javax.swing.JOptionPane.showMessageDialog(null, "GANADOR: " + Comienzo.Ingreso,
                    "GANADOR", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            Menu inicio = new Menu();
            inicio.setBounds(0,0,400,300);
            inicio.setVisible(true);
            inicio.setLocationRelativeTo(null);
            this.dispose();
        }
        if(gana0() == true){
            javax.swing.JOptionPane.showMessageDialog(null, "GANADOR: " + Ingreso2,
                    "GANADOR", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            Menu inicio = new Menu();
            inicio.setBounds(0,0,400,300);
            inicio.setVisible(true);
            inicio.setLocationRelativeTo(null);
            this.dispose();
        }
    }
    
    public boolean ganaX(){
        if(casilla[0][0].getText().equals("X") && casilla[1][1].getText().equals("X") && casilla[2][2].getText().equals("X")){
           //Diagonal izquierda derecha
            return true;
        }else if(casilla[0][2].getText().equals("X") && casilla[1][1].getText().equals("X") && casilla[2][0].getText().equals("X")){
            //Diagonal der izq
            return true;
        }else if(casilla[0][0].getText().equals("X") && casilla[0][1].getText().equals("X") && casilla[0][2].getText().equals("X")){
            //Fila 0
            return true;
        }else if(casilla[1][0].getText().equals("X") && casilla[1][1].getText().equals("X") && casilla[1][2].getText().equals("X")){
            //Fila 1
            return true;
        }else if(casilla[2][0].getText().equals("X") && casilla[2][1].getText().equals("X") && casilla[2][2].getText().equals("X")){
            //Fila 2
            return true;
        }else if(casilla[0][0].getText().equals("X") && casilla[1][0].getText().equals("X") && casilla[2][0].getText().equals("X")){
            //Columna 0 
            return true;
        }else if(casilla[0][1].getText().equals("X") && casilla[1][1].getText().equals("X") && casilla[2][1].getText().equals("X")){
            //Columna 1
            return true;
        }else if(casilla[0][2].getText().equals("X") && casilla[1][2].getText().equals("X") && casilla[2][2].getText().equals("X")){
            //Columna 2
            return true;
        }
        return false;
    }
    
    public boolean gana0(){
        if(casilla[0][0].getText().equals("0") && casilla[1][1].getText().equals("0") && casilla[2][2].getText().equals("0")){
           //Diagonal izquierda derecha
            return true;
        }else if(casilla[0][2].getText().equals("0") && casilla[1][1].getText().equals("0") && casilla[2][0].getText().equals("0")){
            //Diagonal der izq
            return true;
        }else if(casilla[0][0].getText().equals("0") && casilla[0][1].getText().equals("0") && casilla[0][2].getText().equals("0")){
            //Fila 0
            return true;
        }else if(casilla[1][0].getText().equals("0") && casilla[1][1].getText().equals("0") && casilla[1][2].getText().equals("0")){
            //Fila 1
            return true;
        }else if(casilla[2][0].getText().equals("0") && casilla[2][1].getText().equals("0") && casilla[2][2].getText().equals("0")){
            //Fila 2
            return true;
        }else if(casilla[0][0].getText().equals("0") && casilla[1][0].getText().equals("0") && casilla[2][0].getText().equals("0")){
            //Columna 0 
            return true;
        }else if(casilla[0][1].getText().equals("0") && casilla[1][1].getText().equals("0") && casilla[2][1].getText().equals("0")){
            //Columna 1
            return true;
        }else if(casilla[0][2].getText().equals("0") && casilla[1][2].getText().equals("0") && casilla[2][2].getText().equals("0")){
            //Columna 2
            return true;
        }
        return false;
    }
    
    public boolean casillasvacia(){
        for(int fila = 0; fila < 3; fila++){
            for(int col =0; col <3; col++){
                if(casilla[fila][col].getText().isEmpty())
                    return true;
            }
        }
        javax.swing.JOptionPane.showMessageDialog(null, "EMPATE",
                    "EMPATE", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        return false;
    }
}
