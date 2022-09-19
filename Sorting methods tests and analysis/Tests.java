/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Homework_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *Mauricio Vazquez Moran
 * 000191686
 * 13/09/2022
 */

public class Tests {
    
    private static <T> void shuffle(T[] arr){
        Random rand = new Random();
		
	for (int i = 0; i < arr.length; i++) {
            int randomIndexToSwap = rand.nextInt(arr.length);
            T temp = arr[randomIndexToSwap];
            arr[randomIndexToSwap] = arr[i];
            arr[i] = temp;
	}
    }
    
    private static <T> void invierteOrden(T[] arr){
        PilaA<T> aux = new PilaA<T>();
        
        int i=0;
        while(i<arr.length){
            aux.push(arr[i]);
            i++;
        }
        int k=0;
        while(!aux.isEmpty()){
            arr[k]=aux.pop();
            k++;
        }
    }
    
    public static void main(String[] args) {
        
        //Data reading
        
        File ent=new File("C:\\Users\\mauva\\Documents\\ITAM\\5to Semestre\\EDA\\EDA\\movie_titles2.txt");
        String nom;
        int anho;
        int id;
        Movie []arr= new Movie[500];
        Movie []arr2= new Movie[1500];
        Movie []arr3= new Movie[3000];
        Movie []arr4= new Movie[6000];
        Movie []arr5= new Movie[11000];
        try(Scanner lec=new Scanner(ent)){
            int i=0;
            while(lec.hasNext()) {
                String[]palabra=lec.nextLine().split(",");
                id=Integer.parseInt(palabra[0]);
                anho=Integer.parseInt(palabra[1]);
                nom=palabra[2];
                Movie pel=new Movie(id,anho,nom);
                if(i<500)
                    arr[i]=pel;
                if(i<1500)
                    arr2[i]=pel;
                if(i<3000)
                    arr3[i]=pel;
                if(i<6000)
                    arr4[i]=pel;
                if(i<11000)
                    arr5[i]=pel;
                i++;
            }
            lec.close();
        }
        catch(FileNotFoundException fnfe) {
            System.err.println("File not found..."+fnfe);
            System.exit(-1);
        }
        
        
        // SORT METHODS TIME TESTING 
        Sorting_Methods<Movie> sm = new Sorting_Methods<Movie>();

        
        // ORDERED ARRAYS
        
//        sm.Selection_Sort(arr);
//        sm.Selection_Sort(arr2);
//        sm.Selection_Sort(arr3);
//        sm.Selection_Sort(arr4);
//        sm.Selection_Sort(arr5);

//        System.out.println("\n Ordered arrays testing times: ");
//        System.out.println("\n");
//        
//        //with n=500
//        long inicio = System.nanoTime();
//        sm.Merge_Sort(arr);
//        long lapTime=System.nanoTime()-inicio;
//        System.out.println("Time "+lapTime/1000000);
//        System.out.println("");
//        
//        //with n=1500
//        long inicio2 = System.nanoTime();
//        sm.Merge_Sort(arr2);
//        long lapTime2=System.nanoTime()-inicio;
//        System.out.println("Time "+lapTime2/1000000);
//        System.out.println("");
//        
//        //n=3000
//        long inicio3 = System.nanoTime();
//        sm.Merge_Sort(arr3);
//        long lapTime3=System.nanoTime()-inicio;
//        System.out.println("Time "+lapTime3/1000000);
//        System.out.println("");
//        
//        //n=6000
//        long inicio4 = System.nanoTime();
//        sm.Merge_Sort(arr4);
//        long lapTime4=System.nanoTime()-inicio;
//        System.out.println("Time "+lapTime4/1000000);
//        System.out.println("");
//        
//        //n=11000
//        long inicio5 = System.nanoTime();
//        sm.Merge_Sort(arr5);
//        long lapTime5=System.nanoTime()-inicio;
//        System.out.println("Time "+lapTime5/1000000);
//        System.out.println("");
        
        
        // RANDOM ORDERED ARRAYS
        
//        shuffle(arr);
//        shuffle(arr2);
//        shuffle(arr3);
//        shuffle(arr4);
//        shuffle(arr5);
//        
//        System.out.println("\n Random ordered arrays testing times: ");
//        System.out.println("\n");
//        
//        //with n=500
//        long inicio = System.nanoTime();
//        sm.Merge_Sort(arr);
//        long lapTime=System.nanoTime()-inicio;
//        System.out.println("Time "+lapTime/1000000);
//        System.out.println("");
//        
//        //with n=1500
//        long inicio2 = System.nanoTime();
//        sm.Merge_Sort(arr2);
//        long lapTime2=System.nanoTime()-inicio;
//        System.out.println("Time "+lapTime2/1000000);
//        System.out.println("");
//        
//        //n=3000
//        long inicio3 = System.nanoTime();
//        sm.Merge_Sort(arr3);
//        long lapTime3=System.nanoTime()-inicio;
//        System.out.println("Time "+lapTime3/1000000);
//        System.out.println("");
//        
//        //n=6000
//        long inicio4 = System.nanoTime();
//        sm.Merge_Sort(arr4);
//        long lapTime4=System.nanoTime()-inicio;
//        System.out.println("Time "+lapTime4/1000000);
//        System.out.println("");
//        
//        //n=11000
//        long inicio5 = System.nanoTime();
//        sm.Merge_Sort(arr5);
//        long lapTime5=System.nanoTime()-inicio;
//        System.out.println("Time "+lapTime5/1000000);
//        System.out.println("");
        
        
        // INVERSE ORDER ARRAY
        
//        sm.Selection_Sort(arr);
//        sm.Selection_Sort(arr2);
//        sm.Selection_Sort(arr3);
//        sm.Selection_Sort(arr4);
//        sm.Selection_Sort(arr5);
//        
//        invierteOrden(arr);
//        invierteOrden(arr2);
//        invierteOrden(arr3);
//        invierteOrden(arr4);
//        invierteOrden(arr5);
//        
//        System.out.println("\n Inverse Ordered arrays testing times: ");
//        System.out.println("\n");
//        
//        //with n=500
//        long inicio = System.nanoTime();
//        sm.Merge_Sort(arr);
//        long lapTime=System.nanoTime()-inicio;
//        System.out.println("Time "+lapTime/1000000);
//        System.out.println("");
//        
//        //with n=1500
//        long inicio2 = System.nanoTime();
//        sm.Merge_Sort(arr2);
//        long lapTime2=System.nanoTime()-inicio;
//        System.out.println("Time "+lapTime2/1000000);
//        System.out.println("");
//        
//        //n=3000
//        long inicio3 = System.nanoTime();
//        sm.Merge_Sort(arr3);
//        long lapTime3=System.nanoTime()-inicio;
//        System.out.println("Time "+lapTime3/1000000);
//        System.out.println("");
//        
//        //n=6000
//        long inicio4 = System.nanoTime();
//        sm.Merge_Sort(arr4);
//        long lapTime4=System.nanoTime()-inicio;
//        System.out.println("Time "+lapTime4/1000000);
//        System.out.println("");
//        
//        //n=11000
//        long inicio5 = System.nanoTime();
//        sm.Merge_Sort(arr5);
//        long lapTime5=System.nanoTime()-inicio;
//        System.out.println("Time "+lapTime5/1000000);
//        System.out.println("");
        

        // SORT METHODS COMPARISONS NUMBER TESTING 
        Sorting_Methods<Movie> sm2 = new Sorting_Methods<Movie>();
        
        
        // ORDERED ARRAYS
        
//        sm2.Selection_Sort(arr);
//        sm2.Selection_Sort(arr2);
//        sm2.Selection_Sort(arr3);
//        sm2.Selection_Sort(arr4);
//        sm2.Selection_Sort(arr5);
//
//        System.out.println("\n Ordered arrays comparisons number: ");
//        System.out.println("\n");
//        
//        //with n=500
//        sm2.setNc(0);
//        sm2.Merge_Sort(arr);
//        System.out.println("Comparisons number "+sm2.getNc());
//        System.out.println("");
//        
//        //with n=1500
//        sm2.setNc(0);
//        sm2.Merge_Sort(arr2);
//        System.out.println("Comparisons number "+sm2.getNc());
//        System.out.println("");
//        
//        //n=3000
//        sm2.setNc(0);
//        sm2.Merge_Sort(arr3);
//        System.out.println("Comparisons number "+sm2.getNc());
//        System.out.println("");
//        
//        //n=6000
//        sm2.setNc(0);
//        sm2.Merge_Sort(arr4);
//        System.out.println("Comparisons number "+sm2.getNc());
//        System.out.println("");
//        
//        //n=11000
//        sm2.setNc(0);
//        sm2.Merge_Sort(arr5);
//        System.out.println("Comparisons number "+sm2.getNc());
//        System.out.println("");
        
        
        // RANDOM ORDERED ARRAYS
        
//        shuffle(arr);
//        shuffle(arr2);
//        shuffle(arr3);
//        shuffle(arr4);
//        shuffle(arr5);
//        
//        System.out.println("\n Random ordered arrays comparisons number: ");
//        System.out.println("\n");
//        
//        //with n=500
//        sm2.setNc(0);
//        sm2.Merge_Sort(arr);
//        System.out.println("Comparisons number "+sm2.getNc());
//        System.out.println("");
//        
//        //with n=1500
//        sm2.setNc(0);
//        sm2.Merge_Sort(arr2);
//        System.out.println("Comparisons number "+sm2.getNc());
//        System.out.println("");
//        
//        //n=3000
//        sm2.setNc(0);
//        sm2.Merge_Sort(arr3);
//        System.out.println("Comparisons number "+sm2.getNc());
//        System.out.println("");
//        
//        //n=6000
//        sm2.setNc(0);
//        sm2.Merge_Sort(arr4);
//        System.out.println("Comparisons number "+sm2.getNc());
//        System.out.println("");
//        
//        //n=11000
//        sm2.setNc(0);
//        sm2.Merge_Sort(arr5);
//        System.out.println("Comparisons number "+sm2.getNc());
//        System.out.println("");
        
        
        // INVERSE ORDER ARRAY
        
        sm2.Selection_Sort(arr);
        sm2.Selection_Sort(arr2);
        sm2.Selection_Sort(arr3);
        sm2.Selection_Sort(arr4);
        sm2.Selection_Sort(arr5);
        
        invierteOrden(arr);
        invierteOrden(arr2);
        invierteOrden(arr3);
        invierteOrden(arr4);
        invierteOrden(arr5);
        
        System.out.println("\n Inverse Ordered arrays comparisons number: ");
        System.out.println("\n");
      
        //with n=500
        sm2.setNc(0);
        sm2.Insertion_Sort(arr);
        System.out.println("Comparisons number "+sm2.getNc());
        System.out.println("");
        
        //with n=1500
        sm2.setNc(0);
        sm2.Insertion_Sort(arr2);
        System.out.println("Comparisons number "+sm2.getNc());
        System.out.println("");
        
        //n=3000
        sm2.setNc(0);
        sm2.Insertion_Sort(arr3);
        System.out.println("Comparisons number "+sm2.getNc());
        System.out.println("");
        
        //n=6000
        sm2.setNc(0);
        sm2.Insertion_Sort(arr4);
        System.out.println("Comparisons number "+sm2.getNc());
        System.out.println("");
        
        //n=11000
        sm2.setNc(0);
        sm2.Insertion_Sort(arr5);
        System.out.println("Comparisons number "+sm2.getNc());
        System.out.println("");
        
        
        
    }
    
    
}
