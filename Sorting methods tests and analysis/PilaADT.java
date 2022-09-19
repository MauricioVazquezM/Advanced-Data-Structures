/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Homework_1;

import java.util.ArrayList;

/**
 *Mauricio Vazquez Moran
 * 000191686
 * 17/02/2002
 * PILAS
 */
public interface PilaADT <T> {
    
    public void push(T dato);
    
    public T pop();
    
    public boolean isEmpty();
    
    public T peek();
    
    public void multiPop(int n);
    
    public ArrayList<T> enArreglo(PilaADT<T> a, PilaADT<T> b);
    
}
