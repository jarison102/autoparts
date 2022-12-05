/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author SENA
 */
public class GenerarContra {
    
    
    /* Array bidimension para almacenar los distintos gupos de caracteres. */
  char[][] arraBidi = new char[4][];

  /* ============ GRUPOS DE CARACTERES ============ */
  /* Array de caracteres para numeros [0-9]. */
  char[] numeros = { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };
  /* Array de caracteres para las letras minusculas [a-z]. */
  char[] letras_minusculas = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
  /* Array de caracteres para las letras mayusculas [A-Z]. */
  char[] letras_mayusculas = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'C', 'W', 'X', 'Y', 'Z' };
  /* Array de caracteres especiales. */
  char[] caracteres_especiales = { '!', '@', '#', '$', '^', '&', '(', ')', '_', '=', '+', '-', '*', '/', '%', '<', '>', '?', '[', ']', '{', '}' };

  /**
   * Constructor principal. Se almacenan los distintos tipos de arrays de
   * caracteres en el array bidimensional.
   */
  public GenerarContra() {
    arraBidi[0] = numeros;
    arraBidi[1] = letras_minusculas;
    arraBidi[2] = letras_mayusculas;
    arraBidi[3] = caracteres_especiales;
  }

  /**
   * Selecciona un caracter aleatorio, primero selecciona un gupo de los grupos de
   * caracteres (numeros[] || letras_minusculas[] || letras_mayusculas[] || caracteres_especiales). 
   * Una vez se selecciona el grupo se elige un caracter de ese grupo, tambien aleatorio.
   *
   * @return un char, el caracteres seleccionado
   */
  public char rngCaracter() {
    Random rng = new Random();
    int i = rng.nextInt(arraBidi.length);
    int j = rng.nextInt(arraBidi[i].length);
    return arraBidi[i][j];
  }

  /**
   * Genera un array de chars, y posteriormente este se convierte en un String, el
   * cual sera la contraseña generada.
   *
   * @return el string, contraseña final generada
   */
  public String crearPassword() {
    char[] caractreres = new char[cantidadCaracteres()];

    for (int i = 0; i < caractreres.length; i++) {
      caractreres[i] = rngCaracter();
    }
    return String.valueOf(caractreres);
  }

  /**
   * Controla la longitud de la contraseña que se va a generar.
   *
   * @return the int
   */
  public int cantidadCaracteres() {
    String msg = JOptionPane.showInputDialog(null, "Introduce la longitud de la contraseña");
    boolean repetir = true;
    int numeroCaracteres = 0;

    do {
      try {
        numeroCaracteres = Integer.parseInt(msg.trim());
        repetir          = false;
      } catch (NumberFormatException e) {
        msg = JOptionPane.showInputDialog(null, "Debes introducir un numero");
      }
    } while (repetir);

    return numeroCaracteres;
  }

  public static void main(String[] args) {
    GenerarContra m = new GenerarContra();

    String password = m.crearPassword();

    JOptionPane.showMessageDialog(null, password, null, -1);
  }
    
}
