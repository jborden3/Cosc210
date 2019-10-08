/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.jonathanborden.survey.text;

/**
 *
 * @author borde
 */
public class TextBarChart {
    //Attributes 
    protected String labels[];
    protected double values[];
    protected int numrows[];
    // Constructor 
    /**
     * Displays the chart using the populated labels and values that we need. 
     */
    public void display(){
        
    }
    
    /**
     * Add label/value combo  to our attributes.
     */
    
    public void addRow(String label, float value){
        labels[numrows] = label;
        values[numrows++] = value;
    }
}
