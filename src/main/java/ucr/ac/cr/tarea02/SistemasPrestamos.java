/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tarea02;

/**
 *
 * @author Maria Jose
 */
public class SistemasPrestamos {
    
    private Equipo[] equipos = new Equipo[5];
    
    //el segundo arreglo guarda los días de retraso
    //registrados en la última devolución de cada equipo.
    private int[] diasAtraso = new int[5];

    public SistemasPrestamos() {
        
        equipos[0] = new Equipo("EQ01", "Cámara DSLR", "Cámara",true, 500);
        equipos[1] = new Equipo("EQ02", "Trípode", "Soporte", true, 500);
        equipos[2] = new Equipo("EQ03", "Micrófono", "Audio", true, 500);
        equipos[3] = new Equipo("EQ04", "Tableta gráfica", "Diseño", true, 500);
        equipos[4] = new Equipo("EQ05", "Kit de iluminación", "Iluminación", true, 800);
        
   
    }//fin del constructor
    
    public String consultarCatalogo(){
        //hay que crear una variable para acumular el texto
        String catalogo = "CATÁLOGO DE EQUIPOS\n\n";
        
        for(int i = 0; i < equipos.length; i++){
            
            if(equipos[i] != null){
                catalogo += "POSICIÓN: " + (i + 1) + "\n";
                catalogo += equipos[i].obtenerInformacion(true); 
                catalogo += "\n\n"; //hay que dejar espacio entre los equipos
            }
        }
        
        return catalogo;
    }
    
    public String prestarEquipo(int posicion){
        if(posicion < 1){
            return "Error: Posición inválida";
        }
        if(posicion > equipos.length){
            return "Error: posición inválida";
        }
        int indice = posicion - 1;
        
        if(equipos[indice] == null){
            return "No existe un equipo en esta posición.";
           
        }
        if(equipos[indice].isDisponible() == false){
            return "El equipo ya está prestado.";
        }
        equipos[indice].prestar();
        return "Préstamo realizado correctamente\n"
                +"Equipo. " + equipos[indice].getNombre();
    }
    
    public String devolverEquipo(int posicion, int dias){
        if(posicion < 1){
            return "Error: posición inválida.";
        }
        if(posicion > equipos.length){
            return "Error: posición inválida.";
        }
        
        int indice = posicion - 1;
        
        if(equipos[indice] == null){
            return "No existe un equipo en esta posición.";
        }
        
        if(equipos[indice].isDisponible()){
            return "Este equipo no está prestado.";
            
        }
            if(dias < 0){
                return "Error: los días no purfrn ser negativos.";
            }
            diasAtraso[indice] = dias;
            
            int multa = equipos[indice].calcularMulta(dias);
            equipos[indice].devolver();
            return "Devolución realizada correctamente.\n\n"
                    + "Equipo: "+equipos[indice].getNombre()
                    + "\nDías de atraso: " + dias
                    + "\nMulta: " + multa;
            
        }


        
        public String consultarMultas(){
            String resultado = "MULTAS REGISTRADAS\n\n";
            
            for(int i = 0; i < equipos.length; i++){
                if(equipos[i] != null){
                    int dias = diasAtraso[i];
                    int multa = equipos[i].calcularMulta(dias);
                    
                    resultado += "Equipo: " + equipos[i].getNombre() +"\n";
                    resultado += "Días de atraso: " + dias + "\n";
                    resultado += "Multa: " + multa + "\n\n";
                    
                }
            }
            
            return resultado;
        }
        
        public String mostrarResumen(){
            int disponibles = 0;
            int prestados = 0;
            int totalDias = 0;
            int totalMultas = 0;
            
            for(int i = 0; i < equipos.length; i++){
                if(equipos[i] != null){
                    if(equipos[i].isDisponible()){
                        disponibles++;
                    }else{
                        prestados++;
                    }
                    totalDias = totalDias + diasAtraso[i];
                    int multa = equipos[i].calcularMulta(diasAtraso[i]);
                    totalMultas = totalMultas + multa;
                        
                }
            }
            
            String resumen = "RESUMEN DEL SISTEMA\n\n";

        resumen += "Equipos disponibles: "
                + disponibles + "\n";

        resumen += "Equipos prestados: "
                + prestados + "\n";

        resumen += "Total de días de atraso: "
                + totalDias + "\n";

        resumen += "Total de multas: ₡"
                + totalMultas;

        return resumen;
                    
        }
       
}

