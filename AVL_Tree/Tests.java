/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AVL_Tree;

/**
 *Mauricio Vazquez Moran
 *Estructuras de datos avanzadas
 * 10 07 2022
 */

public class Tests {
    
    public static void main(String[] args) {
        ArbolAVL<Integer> a = new ArbolAVL<>();
        
        
        a.Inserta(100);
        a.Inserta(200);
        a.Inserta(300);
        a.Inserta(250);
        a.Inserta(375);
        a.Inserta(280);
        a.Inserta(290);
        a.Inserta(295);
//        a.Inserta(-60);
//        a.Inserta(5);
//        a.Inserta(6);
//        a.Inserta(10);

        
        a.porNivel();
        System.out.println(" ");
        a.Borra(250);
        System.out.println(" ");
        a.porNivel();
        
        System.out.println(" ");
        
        a.porNivel();
        System.out.println(" ");
        a.Borra(280);
        System.out.println(" ");
        a.porNivel();
        
        System.out.println(" ");
        
        a.porNivel();
        System.out.println(" ");
        a.Borra(200);
        System.out.println(" ");
        a.porNivel();
        
        System.out.println(" ");
        
        a.porNivel();
        System.out.println(" ");
        a.Borra(250);
        System.out.println(" ");
        a.porNivel();
        
        System.out.println(" ");
        
        a.porNivel();
        System.out.println(" ");
        a.Borra(100);
        System.out.println(" ");
        a.porNivel();
        
        
        
        
        
    }
}
