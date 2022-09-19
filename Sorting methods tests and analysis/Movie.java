/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Homework_1;

/**
 *Mauricio Vazquez Moran
 * 000191686
 * 13/09/2022
 */
public class Movie implements Comparable<Movie>{
    private int id;
    private int year;
    private String name;

    public Movie(int id, int year, String name) {
        this.id = id;
        this.year = year;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }
    
    public int compareTo(Movie otro) {
        int rest=-1;
		
	if(this.id==otro.id){
            rest=0; 
        }
        else{ 
            if(this.id>otro.id){
		rest=123;
            }
        }
	return rest;	
    }
    
}
