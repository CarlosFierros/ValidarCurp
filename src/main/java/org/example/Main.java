package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

    public class Main {
        public static void main(String[] args) {
            String rutaArchivo = "CURPS EJEMPLO.txt";
            leerYValidarCurps(rutaArchivo);
        }

        public static final String CURP_REGEX = "^[A-Z]{4}\\d{6}[HM][A-Z]{2}[A-Z]{3}[A-Z\\d]\\d$";

        public static boolean esCurpValida(String curp) {
            return curp.matches(CURP_REGEX);
        }

        public static void leerYValidarCurps(String rutaArchivo) {
            String linea;
            int numeroDeLinea = 1;

            try {
                BufferedReader leer = new BufferedReader(new FileReader(rutaArchivo));

                while ((linea = leer.readLine()) != null) {
                    linea = linea.trim();

                    if (esCurpValida(linea)) {
                        System.out.println("CURP válida: " + linea + " en la línea " + numeroDeLinea);
                    } else {
                        System.out.println("CURP inválida: " + linea + " en la línea " + numeroDeLinea);
                    }
                    numeroDeLinea++;
                }
                leer.close();

            } catch (IOException e) {
                System.out.println("Error en el archivo: " + e.getMessage());
            }
        }
    }