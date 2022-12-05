/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.Random;

/**
 *
 * @author SENA
 */
public class GenerarClave {

    char[][] arraBidi = new char[4][];

    /* ============ GRUPOS DE CARACTERES ============ */
 /* Array de caracteres para numeros [0-9]. */
    char[] numeros = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
    /* Array de caracteres para las letras minusculas [a-z]. */
    char[] letras_minusculas = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    /* Array de caracteres para las letras mayusculas [A-Z]. */
    char[] letras_mayusculas = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'C', 'W', 'X', 'Y', 'Z'};
    /* Array de caracteres especiales. */
    char[] caracteres_especiales = {'!', '@', '#', '$', '^', '&', '(', ')', '_', '=', '+', '-', '*', '/', '%', '<', '>', '?', '[', ']', '{', '}'};

    public GenerarClave() {
        arraBidi[0] = numeros;
        arraBidi[1] = letras_minusculas;
        arraBidi[2] = letras_mayusculas;
        arraBidi[3] = caracteres_especiales;
        crearPassword();
    }


    public char rngCaracter() {
        Random rng = new Random();
        int i = rng.nextInt(arraBidi.length);
        int j = rng.nextInt(arraBidi[i].length);
        return arraBidi[i][j];
    }

    public String crearPassword() {
        char[] caractreres = new char[8];

        for (int i = 0; i < caractreres.length; i++) {
            caractreres[i] = rngCaracter();
        }
        System.out.println(String.valueOf(caractreres));
        return String.valueOf(caractreres);
        
    }
    
    public static void main(String[] args) {
        
       new GenerarClave();
        
    }

}
