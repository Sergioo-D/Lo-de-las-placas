
package com.mycompany.placas_solares;


public class Aparell_electronic {
    private String descripcio;
    private int PotenciaGasta;
    private boolean interruptor;
    
    public Aparell_electronic(String descripcio,int Potencia_gasta,boolean interruptor){
        this.descripcio = descripcio;
        this.PotenciaGasta = PotenciaGasta;
        this.interruptor = interruptor;
    }   
}
