package com.mycompany.placas_solares;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Placas_solares {

    public static void main(String[] args) throws IOException {
        ArrayList<Casa> LasCasas = new ArrayList<Casa>();
        BufferedReader terminal = new BufferedReader(new InputStreamReader(System.in));  //lee la entrada del usuario desde la consola del sistema.
        String comanda = "";

        do {  // bucle que se ejecuta por lo menos una vez y deja una '>' para escribir la comanda
            System.out.print("> ");
            comanda = terminal.readLine();
            String[] dades = comanda.split(" ");

            switch (dades[0].toLowerCase()) {
                case "addcasa":  // añade una casa a la arraylist de casas 
                    if (dades.length != 4) { // comprueba cuantos argumentos has escrito y si es diferente a 4 da error
                        System.out.println("ERROR: Número de paràmetres incorrecte.\nÚs: addCasa [nif] [nom] [superficie]");
                    } else {
                        int num = Integer.parseInt(dades[3]);
                        Casa uno = new Casa(dades[1], dades[2], num);
                        int superficieTeulada = uno.getTeulada();
                        if (superficieTeulada < 10) {
                            System.out.println("Superficie incorrecta. Ha de ser més gran de 10.");
                        } else {
                            boolean comprobarExistencia = buscarCasaRepetida(LasCasas, dades[1]);
                            if (comprobarExistencia == true) {
                                System.out.println("La casa que intenta registar ya existe");
                            } else {
                                LasCasas.add(uno);
                                System.out.println("OK: Casa registrada");

                            }
                        }
                    }

                    break;

                case "addplaca": // añade una placa a la casa
                    if (dades.length != 5) {
                        System.out.println("ERROR: Número de paràmetres incorrecte.\nÚs: addPlaca [nif] [superficie] [preu] [potència]");
                    } else {
                        Casa casaBuscada = buscarCasaPorNif(LasCasas, dades[1]);
                        if (casaBuscada != null) {
                            int superficie = Integer.parseInt(dades[2]);
                            float precio = Float.parseFloat(dades[3]);
                            int p_energia = Integer.parseInt(dades[4]);

                            if (superficie < 1 || precio < 1 || p_energia < 1) {
                                System.out.println("ERROR: Superfície incorrecta. Ha de ser més gran de 0.");
                            } else {
                                int superficieDisponible = casaBuscada.SuperficieDisponible();
                                if (superficieDisponible < superficie) {
                                    System.out.println("ERROR: No hi ha espai disponible per a instal·lar aquesta placa.");
                                } else {
                                    Placas nuevaPlaca = new Placas(superficie, precio, p_energia);
                                    casaBuscada.agregaPlacas(nuevaPlaca);
                                    System.out.println("OK: Placa afegida a la casa.");

                                }
                            }
                        } else {
                            System.out.println("ERROR: No hi ha cap casa registrada amb aquest nif.");
                        }
                    }
                    break;
                case "addaparell": // añade un aparell a la casa
                    if (dades.length != 4) {
                        System.out.println("ERROR: Número de paràmetres incorrecte.\nÚs: addAparell [nif] [descripció] [potència]");
                    } else {
                        Casa casaBuscada = buscarCasaPorNif(LasCasas, dades[1]);
                        if (casaBuscada != null) {
                            String descripcio = dades[2];
                            int potenciaGasta = Integer.parseInt(dades[3]);

                            if (potenciaGasta < 1) {
                                System.out.println("ERROR: Potència incorrecte. Ha de ser més gran de 0.");
                            } else {
                                Aparell_electronic nuevoAparato = new Aparell_electronic(descripcio, potenciaGasta);
                                nuevoAparato.setOff();
                                casaBuscada.agregaAparell(nuevoAparato);
                                System.out.println("OK: Aparell afegit a la casa.");

                            }
                        }
                    }
                    break;

                case "oncasa": // enciende los plomos de la casa para que haya luz/electricidad
                    if (dades.length != 2) {
                        System.out.println("ERROR: Número de paràmetres incorrecte.\nÚs: onCasa [nif]");
                    } else {
                        Casa casaBuscada = buscarCasaPorNif(LasCasas, dades[1]);
                        if (casaBuscada != null) {
                            if (casaBuscada.getInterruptorCasa()) {
                                System.out.println("ERROR: La casa ja té l'interruptor encès.");
                            } else {
                                casaBuscada.encenderCasa();
                                System.out.println("OK: Interruptor general activat.");
                            }
                        } else {
                            System.out.println("ERROR: No hi ha cap casa registrada amb aquest nif.");
                        }
                    }
                    break;
                case "onaparell": // enciende el aparell selecionado si la casa tiene los plomos subidos
                    if (dades.length != 3) {
                        System.out.println("ERROR: Número de paràmetres incorrecte \nÚs: onAparell [nif] [descripció aparell]");
                    } else {
                        Casa casaBuscada = buscarCasaPorNif(LasCasas, dades[1]);
                        String descripcio = dades[2];
                        if (casaBuscada != null) {
                            Aparell_electronic aparatoBuscado = casaBuscada.buscarAparell(descripcio);
                            if (aparatoBuscado != null) {
                                if (aparatoBuscado.isEncendido()) {
                                    System.out.println("ERROR: L'aparell ja està encès.");
                                } else if (casaBuscada.getInterruptorCasa()) {
                                    aparatoBuscado.setOn();
                                    System.out.println("OK: Aparell encès.");
                                } else {
                                    System.out.println("ERROR: No es pot encendre l'aparell. L'interruptor general està apagat.");
                                }
                            } else {
                                System.out.println("ERROR: No hi ha cap aparell registrat amb aquesta descripció a la casa indicada.");
                            }
                        } else {
                            System.out.println("ERROR: No hi ha cap casa registrada amb aquest nif.");
                        }
                    }
                    break;
                case "offaparell": // apaga el aparell seleccionado
                    if (dades.length != 3) {
                        System.out.println("ERROR: Número de paràmetres incorrecte \nÚs: offAparell [nif] [descripció aparell]");
                    } else {
                        Casa casaBuscada = buscarCasaPorNif(LasCasas, dades[1]);
                        String descripcio = dades[2];
                        if (casaBuscada != null) {
                            Aparell_electronic aparatoBuscado = casaBuscada.buscarAparell(descripcio);
                            if (aparatoBuscado != null) {
                                if (!aparatoBuscado.isEncendido()) {
                                    System.out.println("ERROR: L'aparell ja està apagat.");
                                } else {
                                    aparatoBuscado.setOff();
                                    System.out.println("OK: Aparell apagat.");
                                }
                            } else {
                                System.out.println("ERROR: No hi ha cap aparell registrat amb aquesta descripció a la casa indicada.");
                            }
                        } else {
                            System.out.println("ERROR: No hi ha cap casa registrada amb aquest nif.");
                        }
                    }
                    break;

                case "quit": // para salir del bucle y programa
                    if (dades.length != 1) {
                        System.out.println("ERROR: Número de paràmetres incorrecte.\\nÚs: quit");
                    }
                    break;

                case "list": // una lista con datos sobre placas y aparells del cliente
                    if (dades.length != 1) {
                        System.out.println("ERROR: Número de paràmetres incorrecte.\nÚs: list");
                    } else {
                        System.out.println("--- Endolls Solars, S.L. ---");
                        int numeroCasas = LasCasas.size();
                        System.out.println("Cases enregistrades: " + numeroCasas);
                        for (int i = 0; i < LasCasas.size(); i++) {
                            Casa casaActual = LasCasas.get(i);
                            System.out.println("Casa" + " " + (i + 1));
                            System.out.println("Client: " + casaActual.getNif() + " - " + casaActual.nomClient());
                            System.out.println("Superfície de teulada:" + " " + casaActual.getTeulada());
                            System.out.println("Superfície disponible:" + " " + casaActual.SuperficieDisponible());
                            if (casaActual.getInterruptorCasa()) {
                                System.out.println("Interruptor general: encès");
                            } else {
                                System.out.println("Interruptor general: apagat");
                            }
                            if (casaActual.getPlacaSolar() > 0) {
                                System.out.println("Plaques solars instal·lades: " + casaActual.getPlacaSolar());
                            } else {
                                System.out.println("No té plaques solars instal·lades.");
                            }
                            if (casaActual.getAparells() > 0) {
                                System.out.println("Aparells registrats: " + casaActual.getAparells());
                            } else {
                                System.out.println("No té cap aparell elèctric registrat.");
                            }
                        }
                        break;
                    }
                case "info":  // A traves de un nif para identificar la casa da datos sobre esta 
                    if (dades.length != 2) {
                        System.out.println("ERROR: Número de paràmetres incorrecte.\nÚs: info [nif]");
                    } else {
                        String nif = dades[1];
                        boolean casaTrobada = false;
                        for (int i = 0; i < LasCasas.size(); i++) {
                            Casa casaActual = LasCasas.get(i);
                            if (casaActual.getNif().equals(nif)) {
                                casaTrobada = true;
                                System.out.println("Client: " + casaActual.getNif() + " - " + casaActual.nomClient());
                                if (casaActual.getPlacaSolar() > 0) {
                                    System.out.println("Plaques solars instal·lades: " + casaActual.getPlacaSolar());
                                    System.out.println("Potència total: " + casaActual.potenciaTotal() + "W");
                                    System.out.println("Inversió total: " + casaActual.inversionTotal() + "€");
                                }
                                if (casaActual.getAparells() > 0) {
                                    System.out.println("Aparells registrats: " + casaActual.getAparells());
                                    System.out.println("Consum actual: " + casaActual.potenciaTotalAparells() + "W");
                                } else {
                                    System.out.println("No té cap aparell elèctric registrat.");
                                }
                                break;
                            }
                        }
                        if (!casaTrobada) {
                            System.out.println("ERROR: No hi ha cap casa registrada amb aquest nif.");
                        }
                    }
                    break;
                default:
                    System.out.println("Comando incorrecto");

            }
        } while (!comanda.equalsIgnoreCase("quit"));

    }
            // buscas la casa en su arraylist y si existe te la devuelve
    public static Casa buscarCasaPorNif(ArrayList<Casa> LasCasas, String nif) {
        for (Casa casa : LasCasas) {
            if (casa.getNif().equals(nif)) {
                return casa;
            }
        }
        return null;
    }
// El método "buscarCasaRepetida" recorre una lista de objetos "Casa" y verifica si alguno de ellos tiene el mismo NIF (identificador) que el proporcionado 
    //como argumento. Si lo encuentra, devuelve "true", de lo contrario devuelve "false".
    public static boolean buscarCasaRepetida(ArrayList<Casa> LasCasas, String nif) {
        for (Casa nifEnLista : LasCasas) {
            if (nifEnLista.getNif().equals(nif)) {
                return true;
            }
        }
        return false;
    }

}
