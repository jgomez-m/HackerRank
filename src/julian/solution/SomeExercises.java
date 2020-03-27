package julian.solution;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Julian
 */
public class SomeExercises {

    public double distanciaProm(double[] puntos) {

        double x1 = puntos[0];
        double y1 = puntos[1];
        double x2 = puntos[2];
        double y2 = puntos[3];
        double x3 = puntos[4];
        double y3 = puntos[5];

        double distancia1 = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        double distancia2 = Math.sqrt((x3 - x2) * (x3 - x2) + (y3 - y2) * (y3 - y2));
        double distancia3 = Math.sqrt((x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3));

        return (distancia1 + distancia2 + distancia3) / 3.0d;
    }

    public boolean isCasiPalindromo(String palabra) {
        int length = palabra.length();
        StringBuilder reverse = new StringBuilder(palabra).reverse();
        boolean answ = false;

        if (palabra.equals(reverse.toString())) {
            answ = true;
        } else {
            int count = 0;
            palabra = palabra.replaceAll(" ", "");
            reverse = new StringBuilder(palabra).reverse();
            for (int i = 0; i < palabra.length(); i++) {
                reverse.replace(i, i + 1, "" + palabra.charAt(palabra.length() - i - 1));
                count++;
                if (palabra.equalsIgnoreCase(reverse.toString())) {
                    break;
                }
            }
            if (count < 2) {
                answ = true;
            }
        }
        return answ;
    }

    public int numMasPopular(int[] array) {
        int mayor = 0;
        Map<Integer, Integer> mapa = new HashMap<>();
        
        for (int i = 0; i < array.length; i++) {
            if(!mapa.containsKey(array[i]))
                mapa.put(array[i], 1);
            else{
                int cant = mapa.get(array[i]);
                cant++;
                mapa.put(array[i], cant);
            }
        }
        Entry<Integer, Integer> pareja = null; 
        for (Iterator<Entry<Integer, Integer>> it = mapa.entrySet().iterator(); it.hasNext();) {
            Entry<Integer, Integer> e = it.next();
            System.err.println(e.getKey() +" "+ e.getValue());
            if(mayor < e.getValue()){
                mayor = e.getValue();
                pareja = e;
            }
        }
        return pareja.getKey();
    }
    
    public static void main(String[] args) {
        SomeExercises d = new SomeExercises();
        System.err.println("La moda es: "+ d.numMasPopular(new int[] {1,3,4,5,4,3,3,4}));
        String word = "Anita lava la tina";
        boolean esPalindrome = d.isCasiPalindromo(word);
        System.out.println("La palabra "+word + " es Palindrome?: "+esPalindrome);
    }
           

}
