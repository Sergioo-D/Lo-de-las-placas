
package com.mycompany.placas_solares;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

// Se crea la clase Casa y todos sus atributos privados y metodos
public class Casa {

    private String nif;
    private String nomClient;
    private int superficieTeulada;
    private boolean interruptorCasa;
    private ArrayList<Placas> PlacaSolar;
    private ArrayList<Aparell_electronic> Aparell;

// Este es el constructor de la clase Casa
    public Casa(String nif, String nomClient, int superficieTeulada) {
        this.nif = nif;
        this.nomClient = nomClient;
        this.superficieTeulada = superficieTeulada;
        interruptorCasa = false;
        PlacaSolar = new ArrayList<>();
        Aparell = new ArrayList<>();
    }
//recorre la lista de aparatos electrónicos de una casa y calcula la suma de su consumo eléctrico, 
    //devolviendo la potencia total en vatios consumida por los aparatos de la casa.
    public int potenciaTotalAparells() {
        int potenciaTotal = 0;
        for (Aparell_electronic a : Aparell) {
            potenciaTotal += a.getPotenciaGasta();
        }
        return potenciaTotal;
    }
//recorre la lista de objetos de tipo Placas, obtiene la potencia de energía de cada uno de ellos y la suma a una 
//variable potenciaTotal, para luego retornarla como la potencia total generada por todas las placas solares instaladas en la casa.
    public int potenciaTotal() {
        int potenciaTotal = 0;
        for (Placas a : PlacaSolar) {
            potenciaTotal += a.getPotenciaEnergia();
        }
        return potenciaTotal;
    }
//devuelve el coste total de las placas solares instaladas en una casa. Itera a través de cada objeto 
    //Placas en la lista PlacaSolar y suma el precio de cada placa al inversioTotal.
    public double inversionTotal() {
        double inversioTotal = 0.0;
        for (Placas a : PlacaSolar) {
            inversioTotal += a.getPreu();
        }
        return inversioTotal;
    }
    // Un metodo que te devuelve un entero de todos los objetos en la ArrayList Aparell

    public int getAparells() {
        return Aparell.size();
    }// Un metodo que te devuelve un entero de todos los objetos en la ArrayList PlacaSolar

    public int getPlacaSolar() {
        return PlacaSolar.size();
    } // te devuelve la superficie de la teulada

    public int getTeulada() {
        return superficieTeulada;
    }

    // te devuelve el nif 
    public String getNif() {
        return nif;
    }// te devuelve el nombre del cliente

    public String nomClient() {
        return nomClient;
    } // metodo que agrega el objeto nuevaPlaca a su ArrayList

    public void agregaPlacas(Placas nuevaPlaca) {
        PlacaSolar.add(nuevaPlaca);
    }
    
//Este método calcula la superficie disponible en la teulada de la casa restando la superficie de las placas solares instaladas.
    public int SuperficieDisponible() {
        int superficieTotal = this.superficieTeulada;

        for (Placas placa : PlacaSolar) {
            superficieTotal -= placa.getSuperficie();
        }

        return superficieTotal;
    }
    // Metodo que agrega un nuevo aparell a su arrayList de Aparells

    public void agregaAparell(Aparell_electronic nuevoAparato) {
        Aparell.add(nuevoAparato);
    }
    // Metodo que cambia la casa de apagada a encendida

    public void encenderCasa() {
        this.interruptorCasa = true;
    }
    // Metodo que cambia la casa de encendida a apagada

    public void apagarCasa() {
        this.interruptorCasa = false;
    } // metodo que devuelve el interruptor de la casa si esta apagada o encendida

    public boolean getInterruptorCasa() {
        return interruptorCasa;
    }
//Método para buscar un aparato electrónico por su descripción.
    public Aparell_electronic buscarAparell(String descripcio) {
        for (Aparell_electronic ape : Aparell) {
            if (ape.getDescripcion().equalsIgnoreCase(descripcio)) {
                return ape;
            }
        }
        return null;
    }
//verifica si la potencia total consumida por los aparatos eléctricos de la casa supera la potencia máxima generada por las placas solares instaladas.
    public void verificarPotencia() {
        int potenciaTotal = 0;
        for (Aparell_electronic ape : Aparell) {
            if (ape.isEncendido()) {
                potenciaTotal += ape.getPotenciaGasta();
            }
        }

        int potenciaMaxima = 0;
        for (Placas placa : PlacaSolar) {
            potenciaMaxima += placa.getPotenciaEnergia();
        }

        if (potenciaTotal > potenciaMaxima) {
            interruptorCasa = false;
            for (Aparell_electronic ape : Aparell) {
                if (ape.isEncendido()) {
                    ape.setOff();
                }
            }
            throw new RuntimeException("ERROR: Han saltat els ploms. La casa ha quedat completament apagada.");
        }
    }
}
  
      
        

