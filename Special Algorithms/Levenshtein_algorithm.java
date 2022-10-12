/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RECURSIVIDAD;

/**
 *Mauricio Vazquez Moran
 * 000191686
 * 17/08/2022
 * Hacer un metodo recursivo para que dadas dos cadenas me regrese el numero de 
 * operaciones para que ambas sean iguales (Distancia de Levenshtein
 */

public class Levenshtein_algorithm {
    
    public static int Levenshtein_distance(String s1, String s2, int cont){
        if(s1.length()==0 || s2.length()==0){
            return cont+s1.length()+s2.length();
        }
        if(s1.charAt(0)==s2.charAt(0)){
            return Levenshtein_distance(s1.substring(1), s2.substring(1), cont);
        }
        int sus = Levenshtein_distance(s1.substring(1),s2.substring(1),cont+1);
        int ins = Levenshtein_distance(s1.substring(1),s2,cont+1);
        int bor = Levenshtein_distance(s1,s2.substring(1),cont+1);
        return Math.min(Math.min(sus, ins),bor);
    }
    
    public static void main(String[] args) {
        String str1="giky";
        String str2="geeky";
        
        System.out.println(Levenshtein_distance(str1,str2,0));
    }
    
}
