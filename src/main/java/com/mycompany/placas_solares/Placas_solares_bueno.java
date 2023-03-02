
package com.mycompany.placas_solares;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Placas_solares_bueno {

    public static void main(String[] args) throws IOException {
     ArrayList<Casa> LasCasas = new ArrayList<Casa>();
     BufferedReader terminal = new BufferedReader(new InputStreamReader(System.in));
     String comanda = "";
     
     do{
         System.out.print("> ");
         comanda = terminal.readLine();
         String[]dades = comanda.split(" ");
                 
         switch (dades[0].toLowerCase()){
             case "addcasa":

                 int num = Integer.parseInt(dades[3]);
                 Casa uno = new Casa(dades[1],dades[2], num);
                 int superficieTeulada = uno.getTeulada();
                 if (superficieTeulada < 10){
                     System.out.println("Superficie incorrecta. Ha de ser més gran de 10.");
                 } else {
                     LasCasas.add(uno);
                     System.out.println("Se ha añadido la casa");
                 }
                 break;
             default:
                 System.out.println("Comando incorrecto");
         }
     } while (!comanda.equalsIgnoreCase("quit"));










    }
    }   