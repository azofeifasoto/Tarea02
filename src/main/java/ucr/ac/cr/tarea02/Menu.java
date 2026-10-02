/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tarea02;

import javax.swing.JOptionPane;

/**
 *
 * @author Maria Jose
 */
public class Menu {
    private SistemasPrestamos sistema;
    
    public Menu(){
        sistema = new SistemasPrestamos();
    }
     public void iniciar(){
         int opcion = 0;
         
          String respuesta;
         
         do{
             respuesta = JOptionPane.showInputDialog("SISTEMA DE PRÉSTAMO\n\n"
                     + "1. Consultar catálogo\n"
                     + "2. Prestar equipo\n"
                     + "3. Devolver equipo\n"
                     + "4. Consultar multas\n"
                     + "5. Mostrar resumen\n"
                     + "6. Salir\n\n"
                     + "Digite una opción: ");
             
             if(respuesta == null){
                 
                 opcion = 6;
             }else{
                 opcion = 0;
                 
                 if(respuesta.equals("1")){
                     opcion = 1;
                 }
                 if(respuesta.equals("2")){
                     opcion = 2;
                 }
                 if(respuesta.equals("3")){
                     opcion = 3;
                 }
                 if(respuesta.equals("4")){
                     opcion = 4;
                 }
                 if(respuesta.equals("5")){
                     opcion = 5;
                 }
                 if(respuesta.equals("6")){
                     opcion = 6;
                 }
             }
             
             switch(opcion){
                 case 1: 
                     JOptionPane.showMessageDialog(null, sistema.consultarCatalogo());
                     
                 break;
                 
                 case 2:
                     Integer posicion = solicitarEntero("Digite la posición del equipo (1-5):");
                     if (posicion != null){
                         String resultado = sistema.prestarEquipo(posicion);
                         JOptionPane.showMessageDialog(null, resultado);
                     }
                     
                 break;
                 
                 case 3:
                     Integer posicionDevolver = solicitarEntero("Digite la posición del equipo (1-5):");
                     if(posicionDevolver !=null){
                         Integer dias = solicitarEntero("Digite los días de atraso:");
                         if(dias !=null){
                                String resultado = sistema.devolverEquipo(posicionDevolver, dias);
                                JOptionPane.showMessageDialog(null, resultado);
                         }
                     }
                     
                     break;
                 case 4:
                 JOptionPane.showMessageDialog(null, sistema.consultarMultas());
                 
                 break;
                 
                 case 5:
                     JOptionPane.showMessageDialog(null, sistema.mostrarResumen());
                 break;
                 
                 case 6:
                     JOptionPane.showMessageDialog(null, "Gracias por utilizar el sistema.");
                     
                 break;
                 
                 default:
                     
                     JOptionPane.showMessageDialog(null, "Opción inválida.");
                     
                 break;
             }
         }while (opcion !=6);
     }
    private Integer solicitarEntero(String mensaje){
        String respuesta = JOptionPane.showInputDialog(null, mensaje);
        if(respuesta == null){
            return null;
        }
        
        if(respuesta.equals("")){
            JOptionPane.showMessageDialog(null, "Debe ingresar un número.");
            
            return null;
        }
        return Integer.parseInt(respuesta);
    }
}
    
    

