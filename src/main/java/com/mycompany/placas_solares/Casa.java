
package com.mycompany.placas_solares;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Casa {
    private String nif;
    private String nom_client;
    private int superficieTeulada;
    private boolean interruptor_casa;
    private ArrayList<String> PlacaSolar;
    private ArrayList<String> Aparell;
    
    

    public Casa(String nif,String nom_client,int superficie_m2,boolean interruptor_c,int superficie){
        this.nif = nif;
        this.nom_client = nom_client;
        this.superficieTeulada = superficieTeulada;
        this.interruptor_casa = interruptor_casa;
        
    }
}