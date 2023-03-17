
package com.mycompany.placas_solares;

// Clase placas con sus atributos y metodos
public class Placas {

    private int superficiePlaques;
    private float preu;
    private int potencia_energia;

    public Placas(int superficiePlaques, float preu, int potencia_energia) {
        this.superficiePlaques = superficiePlaques;
        this.preu = preu;
        this.potencia_energia = potencia_energia;
    }
  // metodo devuelve superficie de la placa
   
 // metodo devuelve el precio
    public float getPreu() {
        return preu;
    }
  //metodo devuelve la potencia energetica
    public int getPotenciaEnergia() {
        return potencia_energia;
    }

//    public boolean comprobarSuperficie(int superficiePlacas) {
//        if (superficiePlacas < 0 ) {
//        return false;
//        }    
//    return true;
    
    // metodo devuelve superficie de la placa
    public int getSuperficie() {
        return superficiePlaques;
    }

}
