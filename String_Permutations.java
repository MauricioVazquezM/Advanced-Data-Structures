/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RECURSIVIDAD;

/**
 *Mauricio Vazquez Moran
 * 000191686
 * 15/08/2022
 * Hacer un metodo recursivo para que dad una cadena de simbolos
 * encuentre todas las permutaciones
 */
public class String_Permutations {
    
    public static void permutation(String cad){
        
    }
    
    private static void permutation(String cad, int i){
        
    }
    
    public static void permuta(String cad, String res){
        Character c;
        String resto;
        if(cad.length()==0)
            System.out.println(res);
        for(int i=0;i<cad.length();i++){
            c=cad.charAt(i);
            resto=cad.substring(0, i)+cad.substring(i+1);
            permuta(resto,c+res);
        }
    }
 
    public static void main(String[] args) {
        String str = "ABC";
        
        permuta(str,"");
        //System.out.println(str.substring(1));
        
        
    }
    
    
    
}
