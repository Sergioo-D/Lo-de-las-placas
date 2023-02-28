
package com.mycompany.placas_solares;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Placas_solares {

    public static void main(String[] args) throws IOException {
     ArrayList<Casa> LasCasas = new ArrayList<Casa>();
     BufferedReader terminal = new BufferedReader(new InputStreamReader(System.in));
     public void addCasa(String nif, String nom, double superficie) {
    if (superficie <= 10) {
        System.out.println("Error: la superfície ha de ser més gran que 10.");
        return;
    }
    
    Casa novaCasa = new Casa(nif, nom, superficie);
    novaCasa.activarInterruptorGeneral();
    
    // Afegir nova casa a l'empresa
    empresa.registrarCasa(novaCasa);
}
     String comanda = "";
     do{
         System.out.print("> ");
         comanda = terminal.readLine();
     } while (!comanda.equalsIgnoreCase("quit"));
     
     

     
     
     
     
   
    
    
    }
    }   
    
