/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tarea02;

/**
 *
 * @author Maria Jose
 */
public class Equipo {
    //atributos
    private String codigo;
    private String nombre;
    private String tipo;
    private boolean disponible;
    private int tarifaMulta;

    public Equipo(String codigo, String nombre, String tipo, boolean disponible, int tarifaMulta) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.disponible = true;
        this.tarifaMulta = tarifaMulta;
    }

    public Equipo() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getTarifaMulta() {
        return tarifaMulta;
    }//fin del getTarifaMulta

    //permite actualizar la tarifa de multa
    //solo acepta valores mayores o iguales a cero.
    public void setTarifaMulta(int tarifaMulta) {
        if(tarifaMulta >=0){   
        
        this.tarifaMulta = tarifaMulta;
        }//fin del if
    }//fin del setTarifaMulta
    
    public void prestar(){
        disponible = false;
    }//fin del metodo prestar
    
    //Metodo devolver, que funciona cuando
    //el estudiante devuelve el equipo
    public void devolver(){
        disponible = true;
        
    }//fin del metodo devolver
    
    public String obtenerInformacion(){
        String estado;
        if(disponible){
            estado = "Disponible";
        }else{
            estado = "Prestado";
        }
    return "Codigo: " + codigo
        +"\nNombre: " + nombre
        +"\nTipo: " + tipo
        +"\nEstado: " + estado;
    
}

    public String obtenerInformacion(boolean mostrarTarifa) {

    String informacion = obtenerInformacion();

    if (mostrarTarifa) {
        informacion += "\nMulta diaria: " + tarifaMulta;
        }

    return informacion;
    }

    public int calcularMulta(int diasAtraso) {

    if (diasAtraso < 0) {
        return 0;
    }

    int multa = diasAtraso * tarifaMulta;

    return multa;
    }//fin de calcularMulta   

}//fin de la clase
