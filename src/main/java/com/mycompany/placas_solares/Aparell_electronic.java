
package com.mycompany.placas_solares;

// Clase Aparell con sus metodos y atributos
public class Aparell_electronic {

    private String descripcio;
    private int potenciaGasta;
    private boolean interruptor;

    public Aparell_electronic(String descripcio, int PotenciaGasta) {
        this.descripcio = descripcio;
        this.potenciaGasta = potenciaGasta;
        this.interruptor = interruptor;
    }
  // metodo apaga interruptor
    public void setOff() {
        this.interruptor = false;
    }
 // metodo enciende interruptor
    public void setOn() {
        this.interruptor = true;
    }
    // metodo devuelve la descripcion del aparell
    public String getDescripcion() {
        return this.descripcio;
    }
 // metodo devuelve un valor booleano que indica si el interruptor del aparato está encendido o no.
    public boolean isEncendido() {
        return this.interruptor;
    }
 // devuelve la potencia que gasta los aparatos
    public int getPotenciaGasta() {
        return this.potenciaGasta;
    }

}
