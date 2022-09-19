/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Homework_1;

import Sorth_Algorithms.*;

/**
 *Mauricio Vazquez Moran
 * 000191686
 * 26/08/2022
 * Clase conjunta de los Sorting Methods analizados
 * 
 */
public class Sorting_Methods <T extends Comparable<T>>{
    private int nc=0;
    
    public void Selection_Sort(T[] data){
        
        for(int i=0; i<data.length;i++){
            int min=i;
            for(int j=i+1; j<data.length; j++){
                nc++;
                if(data[j].compareTo(data[min])<0){
                    min=j;
                }
            }
            T temp=data[i];
            data[i]=data[min];
            data[min]=temp;
        }
    }
    
    public void Bubble_Sort(T[] datos){
        T temp;
        
        for(int i=0; i<datos.length-1; i++){
            for(int j=0;j<datos.length-i-1; j++){
                nc++;
                if((datos[j].compareTo(datos[j+1]))>0){
                    temp=datos[j];
                    datos[j]=datos[j+1];
                    datos[j+1]=temp;
                }
            }
        }
    }
    
    public  void Insertion_Sort(T[] array){
       T aux;
       boolean flag; 
       
       for(int i=1;i<array.length;i++){
            int j=i;
            flag=false;
            
            while(j>0 && !flag){
                nc++;
                if((array[j].compareTo(array[j-1]))<0){
                    flag=true;
                }else{
                    aux=array[j];
                array[j]=array[j-1];
                array[j-1]=aux;
                j--;
                }
            }
        }
    }
  
    public void Quick_Sort(T[] array){
        quickSort(array,0,array.length);
    }
    
    private void quickSort(T[] array, int begin, int end) {
        if (end <= begin){
            return;
        }
        int pivot = particion(array, begin, end);
        quickSort(array, begin, pivot-1);
        quickSort(array, pivot+1, end);
    }
    
    private int particion(T [] array, int min, int max){
        
        //min es inclusivo, max es exclusivo...
        int pivote=min;
        int donde_deje_mayor=max-1;
        while(pivote<donde_deje_mayor){
            nc++;
            if((array[pivote+1].compareTo(array[pivote]))>0){
                swap(array,donde_deje_mayor,pivote+1);
                donde_deje_mayor-=1;
            }else{
                swap(array,pivote+1,pivote);
                pivote+=1;
            }
        }
        return pivote;
    }
    
    private void swap(T [] a, int p, int k) {
	T aux;
		
	aux=a[p];
	a[p]=a[k];
	a[k]=aux;
    }
    
    public void Merge_Sort(T[] datos) { 
        mergeSort(datos, 0, datos.length-1); 
    }

    private void mergeSort(T[] datos, int min, int max){
        if(min==max){
          return;
        }
        int pivote=(min+max)/2;
        mergeSort(datos, min, pivote);
        mergeSort(datos, pivote+1,max);
        mezcla(datos, min, pivote, pivote+1, max);
    }
  
    private void mezcla(T[] datos, int min1,int fin1, int min2, int fin2){
        int i=min1, j=min2,k=0;
        T[] aux=(T[]) new Comparable[fin2-min1+1];
        while(i<=fin1 && j<=fin2){
            boolean flag1=false;
            boolean flag2=false;
            while(i<=fin1 && !flag1){
                nc++;
                if(datos[i].compareTo(datos[j])<=0){
                    flag1=true;
                }else{
                    aux[k++]=datos[i++];
                }
            }
            while(i<=fin1 && j<=fin2 && !flag2){
                nc++;
                if(datos[j].compareTo(datos[i])<=0){
                    flag2=true;
                }else{
                    aux[k++]=datos[j++];
                }
            }
        }
        while(i<=fin1){
          aux[k++]=datos[i++];
        }
        while(j<=fin2){
          aux[k++]=datos[j++];
        }
        for(int m=0; m< aux.length; m++){
          datos[min1+m]=aux[m];
        }
    }

    public int getNc() {
        return nc;
    }

    public void setNc(int nc) {
        this.nc = nc;
    }
    
    

    
    
    
    
    
    
    
}
