/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AVL_Tree;

import static java.lang.Integer.max;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *Mauricio Vazquez Moran
 *Estructuras de datos avanzadas
 * 10 07 2022
 */

public class ArbolAVL <T extends Comparable<T>> {
    private NodoAVL<T> raiz;
    private int cont;
    
    public ArbolAVL(){
        raiz=null;
        cont=0;
    }
    
    public void Inserta( T elemento){
        NodoAVL<T> actual = raiz;
        NodoAVL<T> nuevo = new NodoAVL(elemento);
        NodoAVL<T> papa = null;
        
        if(raiz == null){
            raiz = nuevo;
        }else{
            papa = actual;
            boolean encontre=false;
            while(actual!=null && !encontre){
                papa = actual;
                if(nuevo.getElem().compareTo(actual.getElem())<0){
                    actual = actual.getIzq();
                }else{
                    if(nuevo.getElem().compareTo(actual.getElem())==0){
                        encontre = true;
                    }else{
                        actual = actual.getDer();
                    }
                }
            }
            if(!encontre){
                actual = papa;
                actual.cuelga(nuevo);
            }
            actual=nuevo;
            boolean termine = false;
            while(!termine){
                if(actual == raiz){
                    termine=true;
                }else{
                    papa = actual.getPapa();
                    if(actual == papa.getIzq()){
                        papa.fe--;
                    }else{
                        papa.fe++;
                    }
                    if(papa.fe == 2 || papa.fe == -2){
                        rotar(papa);
                        termine = true;
                    }
                    if(papa.fe == 0){
                        termine = true;
                    }
                    actual = papa;
                }
            }
        }
        cont++;
    }
    
    public void Borra(T elemento){
        NodoAVL<T> actual = elimina(elemento);
        NodoAVL<T> papa = null;
        
        if(actual == null){
            return;
        }
        boolean termine = false;
        while(!termine){
            papa = actual.getPapa();
            if(actual == raiz){
                //System.out.println("gay");
                termine = true;
            }else{
                if(papa.getElem().compareTo(actual.getElem())>0){
                    papa.setFe(papa.getFe()+1);
                    //System.out.println("hola");
                }else{
                    //System.out.println("Nana");
                    papa.setFe(papa.getFe()-1);
                }
                if(papa.getFe() == 2 || papa.getFe() == -2){
                    System.out.println("x");
                    papa = rotar(papa);
                }
                if(papa.getFe() == 1 || papa.getFe() == -1){
                    //System.out.println("nono");
                    termine = true;
                }
            }
            actual = papa;
        }
    }
    
    private NodoAVL<T> elimina(T elem){
        NodoAVL<T> nodo = Busca(elem);
        NodoAVL<T> aux = nodo;
        
        if(nodo == null){
            return aux;
        }
        cont--;
        //Primer caso: 
        if(nodo.getIzq() == null && nodo.getDer() == null){
            if(nodo == raiz){
                raiz=null;
            }else{
                if(nodo == nodo.papa.getDer()){
                    nodo.papa.setDer(null);
                }else{
                    nodo.papa.setIzq(null);
                }
            }
        }else{
            //Segundo caso: 
            if(nodo.getIzq() == null || nodo.getDer() == null){
                if(nodo==raiz){
                    if(nodo.getIzq()!= null){
                        raiz = nodo.getIzq();
                    }else{
                        raiz = nodo.getDer();
                    }
                }else{
                    if(nodo.getIzq()!= null){
                        nodo.papa.cuelga(nodo.getIzq());
                    }else{
                        nodo.papa.cuelga(nodo.getDer());
                    }
                }
            }else{
                //Tercer caso: tiene dos hijos
                NodoAVL<T> actual = nodo.getDer();
                while(actual.getIzq()!= null){
                    actual = actual.getIzq();
                }
                nodo.setElem(actual.getElem());
                if(actual != nodo.getDer()){
                    actual.papa.setIzq(actual.getDer());
                }else{
                    actual.papa.setDer(actual.getDer());
                }
                aux=actual;
            }
        }
        return aux;
    }
    
    public NodoAVL<T> Busca(T elem){
        return busca(raiz, elem);
    }
    
    private NodoAVL<T> busca(NodoAVL<T> arbolito, T elementito){
        if(arbolito == null)
            return arbolito;
        if(arbolito.getElem().compareTo(elementito)<0){
            return busca(arbolito.getDer(), elementito);
        }
        if(arbolito.getElem().compareTo(elementito)>0){
            return busca(arbolito.getIzq(), elementito);
        }
        return arbolito;
    }
    
    //Rotaciones
    private NodoAVL<T> rotar(NodoAVL<T> actual) {
        NodoAVL<T> papa,alfa,beta,gamma,A,B,C,D;
        A = null; B = null; C = null; D = null;
        if (actual.getFe()==-2 && actual.getIzq().getFe()==1){//rotacion izq -der}
            alfa=actual;
            papa=alfa.getPapa();
            beta=alfa.getIzq();
            gamma=beta.getDer();
            A=beta.getIzq();
            if(gamma != null) {
                B=gamma.getIzq();
                C=gamma.getDer();
            }
            D=alfa.getDer();
  
            beta.cuelgaIzq(A);
            beta.cuelgaDer(B);
            alfa.cuelgaIzq(C);
            alfa.cuelgaDer(D);
            
            if(gamma != null) {
            gamma.cuelgaIzq(beta);
            gamma.cuelgaDer(alfa);
            }
            if(papa==null) {
                setRaiz(gamma);
                gamma.setPapa(null);
            } else
                papa.cuelga(gamma);

        //para cuando el fe de gamma es -1???
        if(gamma.getFe()==-1){ 
         beta.setFe(0);
         alfa.setFe(1);
         gamma.setFe(0);
        }else if(gamma.getFe()==1){
           beta.setFe(-1);
           alfa.setFe(0);
           gamma.setFe(0);
        }else{//es cero
           beta.setFe(0);
           alfa.setFe(0);
           gamma.setFe(0);
        }
         return gamma;
        } else if (actual.getFe() == -2 && (actual.getIzq().getFe() == -1 || actual.getIzq().getFe() == 0)) { //izq - izq
            alfa = actual;
            papa = alfa.getPapa();
            beta = alfa.getIzq();
            gamma = beta.getIzq();
            if(gamma != null) {
                A = gamma.getIzq();
                B = gamma.getDer();
            }
            C = beta.getDer();
            D = alfa.getDer();
            
            if(gamma != null) {
            gamma.cuelgaDer(B);
            gamma.cuelgaIzq(A);
            }
            alfa.cuelgaDer(D);
            alfa.cuelgaIzq(C);
            beta.cuelgaDer(alfa);
            beta.cuelgaIzq(gamma);
            
            if(papa==null) {
                setRaiz(beta);
                beta.setPapa(null);
            } else
                papa.cuelga(beta);
            
            if(beta.getFe() == -1) {
                beta.setFe(0);
                alfa.setFe(0);
            } else if(beta.getFe() == 0) {
                alfa.setFe(-1);
                beta.setFe(1);
            }
            return beta; 
        } else if(actual.getFe() == 2 && actual.getDer().getFe() == -1) { //Der - Izq
            alfa = actual;
            papa = actual.getPapa();
            beta = alfa.getDer();
            gamma = beta.getIzq();
            A = alfa.getIzq();
            B = gamma.getIzq();
            C = gamma.getDer();
            D = beta.getDer();
            
            alfa.cuelgaIzq(A);
            alfa.cuelgaDer(B);
            beta.cuelgaIzq(C);
            beta.cuelgaDer(D);
            gamma.cuelgaIzq(alfa);
            gamma.cuelgaDer(beta);
            
            if(papa==null) {
                setRaiz(gamma);
                gamma.setPapa(null);
            } else{
                papa.cuelga(gamma);
            }
            if(gamma.getFe() == 0) {
                alfa.setFe(0);
                beta.setFe(0);
                gamma.setFe(0);
            } else if(gamma.getFe() == -1) {
                alfa.setFe(-1);
                beta.setFe(0);
                gamma.setFe(0);
            } else if(gamma.getFe() == 1) {
                alfa.setFe(-1);
                beta.setFe(0);
                gamma.setFe(0);
            }
            return gamma;
        } else if(actual.getFe() == 2 && (actual.getDer().getFe() == 1 || actual.getDer().getFe() == 0)) { //der - der
            alfa = actual;
            papa = alfa.getPapa();
            beta = alfa.getDer();
            gamma = beta.getDer();
            A = alfa.getIzq();
            B = beta.getIzq();
            if(gamma != null) {
                C = gamma.getIzq();
                D = gamma.getDer();
            }
            
            alfa.cuelgaIzq(A);
            alfa.cuelgaDer(B);
            if(gamma != null) {
                gamma.cuelgaIzq(C);
                gamma.cuelgaDer(D);
            } 
            beta.cuelgaIzq(alfa);
            beta.cuelgaDer(gamma);
            
            if(papa==null) {
                setRaiz(beta);
                beta.setPapa(null);
            } else
                papa.cuelga(beta);
            
            if(beta.getFe() == 1) {
                alfa.setFe(0);
                beta.setFe(0);
            } else if (beta.getFe() == 0) {
                alfa.setFe(1);
                beta.setFe(-1);
            }
            
            return beta;
        }
        
        return actual;
    }
    
    public int altura(){
        return altura(raiz,0);
    }
    
    private int altura(NodoAVL<T>actual, int cont){
        if(actual==null)
            return cont;
        
        int res1 = altura(actual.getIzq(),cont+1);
        int res2 = altura(actual.getDer(),cont+1);
        
        return max(res1,res2);
    }
    
    public void setRaiz(NodoAVL<T> raiz) {
        this.raiz = raiz;
    }
    
    public void porNivel() {
        ArrayList<T> lista = new ArrayList<>();
        ArrayList<Integer> lista2 = new ArrayList<>();
        porNivel(raiz, lista, lista2);
        for(int i =0 ; i<lista.size(); i++){
            System.out.println(lista.get(i) + " fe " + lista2.get(i));
        }
    }
    
    private void porNivel(NodoAVL<T> actual, ArrayList<T> lista, ArrayList<Integer> lista2) {
        Queue<NodoAVL<T>> cola = new LinkedList<>();
        cola.add(raiz);
        while(!cola.isEmpty()) {
            actual = cola.remove();
            lista.add(actual.getElem());
            lista2.add(actual.getFe());
            if(actual.getIzq() != null){
                cola.add(actual.getIzq());
            }
            if(actual.getDer() != null){
                cola.add(actual.getDer());
            }
        }
    }
    
}
