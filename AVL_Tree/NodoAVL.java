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

public class NodoAVL <T extends Comparable<T>> {
    T elem;
    NodoAVL<T> izq;
    NodoAVL<T> der;
    NodoAVL<T> papa;
    int fe;
    
    public NodoAVL(T elem) {
        this.elem = elem;
        izq = null;
        der = null;
        papa = null;
        fe = 0;
    }
    
    public T getElem() {
        return elem;
    }

    public NodoAVL<T> getIzq() {
        return izq;
    }

    public NodoAVL<T> getDer() {
        return der;
    }

    public void setIzq(NodoAVL<T> izq) {
        this.izq = izq;
    }

    public void setDer(NodoAVL<T> der) {
        this.der = der;
    }

    public void setElem(T elem) {
        this.elem = elem;
    }

    public void setPapa(NodoAVL<T> papa) {
        this.papa = papa;
    }

    public NodoAVL<T> getPapa() {
        return papa;
    }
    
    public void incrementarFe() {
        fe++;
    }
    
    public void decrementarFe() {
        fe--;
    }
    
    public int getFe() {
        return fe;
    }

    @Override
    public String toString() {
        return elem + " ";
    }

    public void setFe(int fe) {
        this.fe = fe;
    }
    
    public void cuelga(NodoAVL<T> actual){
        if (actual==null){
            return;
        }
        if(actual.getElem().compareTo(elem)<=0){
            izq=actual;
        }else{
            der=actual; 
        }
        actual.setPapa(this);
    }
    
    public void cuelgaDer(NodoAVL<T> hijo){
        if(hijo==null){
            der=null;
            return;
	}
        der=hijo;
        hijo.setPapa(this);
    }
    public void cuelgaIzq(NodoAVL<T> hijo){
	if(hijo==null){
            izq=null;
            return;
        }
	izq=hijo;
	hijo.setPapa(this);
    }
    
}
