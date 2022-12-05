/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 *
 * @author SENA
 */
public class Encritar {
    public static String getMD5(String input) {
           try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] encBytes = md.digest(input.getBytes());
                BigInteger numero = new BigInteger(1, encBytes);
                String encString = numero.toString(16);
                while (encString.length() < 32) {
                    encString = "0" + encString;
                }
                return encString;
                    } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
}
