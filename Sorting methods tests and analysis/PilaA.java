/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Homework_1;

import java.util.ArrayList;

/**
 *Mauricio Vazquez Moran
 * 000191686
 * 17/02/2002
 * PILAS
 */
public class PilaA <T> implements PilaADT<T>{
    private T[] pila;
    protected int tope;
    private final int MAX=20;

    public PilaA() {
        pila = (T[]) new Object[MAX];
        tope = -1;
    }
    
    public boolean isEmpty(){
        return tope==-1; //La maquina compara el valor de toope para darnos el resultado
    }
    
    public void push (T dato){
        if(tope==pila.length-1){
            expande ();
        }
        tope++;
        pila[tope] = dato;
    }
    
    //Metodo auxiliar para generar una pila mas grande que la actual
    private void expande(){
        T [] nuevo;
        
        nuevo = (T[])new Object[pila.length*2];
        for(int i=0; i<=tope; i++){
            nuevo[i]=pila[i];
        }
        pila = nuevo;
    }
    
    public T peek(){
        if(this.isEmpty()){
            throw new ColeccionVaciaExcepcion("PILA VACIA");
        }
        return pila[tope];
    }
    
    public T pop(){
        T resultado;
        
        if(this.isEmpty()){
            throw new ColeccionVaciaExcepcion("PILA VACIA");
        }
        resultado= pila[tope];
        pila[tope] = null;
        tope--;
        return resultado;
    }
    
    public String toString(){
        StringBuilder cad;
        
        cad= new StringBuilder();
        for(int i=0; i<=tope; i++){
            cad.append(pila[i]).append("\n");
        }
        return cad.toString();
    }
    
    public void multiPop(int n){
        
        if(isEmpty()){
            throw new ColeccionVaciaExcepcion("PILA VACIA");
        }else{
            if(tope>=n-1){
                for(int i =0; i<n; i++){
                    pila[tope]=null;
                    tope--;
                }
            }
        }
    }
    
    public ArrayList<T> enArreglo(PilaADT<T> a, PilaADT<T> b){
        ArrayList<T> res;
        int posF;
        
        posF=0;
        res=new ArrayList<>();
        while(!a.isEmpty()){
            res.add(a.pop());
            posF++;
        }
        while(!b.isEmpty()){
            res.add(posF, b.pop());
            posF++;
        }
        return res;
    }
    
    private void copiaPila(PilaADT p1, PilaADT p2){
        
    }
    
    public boolean equals(Object otro){
        boolean res=false;
        PilaA a;
        PilaA aux=new PilaA();
        PilaA aux2=new PilaA();
        
        if(otro.getClass().equals(this.getClass())){
            a=(PilaA)otro;
            if(this.tope==a.tope){
                res=true;
                T x;
                while(!this.isEmpty() && res){
                    x=this.pop();
                    aux.push(x);
                    if(!x.equals(a.peek())){
                        res=false;
                        aux2.push(a.pop());
                    }
                    aux2.push(a.pop());
                }
                copiaPila(aux,this);
                copiaPila(this,aux2);
            }
        }
        return res;
    }
    
    public boolean equals2(Object otro){
        boolean res=false;
        int i=0;
        PilaA cad;
        
        if(otro.getClass().equals(this.getClass())){
            cad=(PilaA) otro;
            res=true;
            while(i<=tope && res){
                res=pila[i].equals(cad.pila[i]);
                i++;
            }
        }
        return res;
    }
    
   
    
    
}
