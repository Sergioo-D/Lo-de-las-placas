
package com.mycompany.placas_solares;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Casa {
    private String nif;
    private String nom_client;
    private int superficieTeulada;
    private boolean interruptor_casa;
    private ArrayList<Placas> PlacaSolar;
    private ArrayList<Aparell_electronic> Aparell;
    
    

    public Casa(String nif,String nom_client,int superficieTeulada){
        this.nif = nif;
        this.nom_client = nom_client;
        this.superficieTeulada = superficieTeulada;
        interruptor_casa = true;
        PlacaSolar = new ArrayList<>();
        Aparell = new ArrayList<>();
    }
    
    public int getTeulada(){
        return superficieTeulada;
    }
}