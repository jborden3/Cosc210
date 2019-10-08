/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.briantoone.survey;

/**
 * Represents a question in our survey.
 * @author kartoone
 */
public class Question {
    // Attributes
    protected String prompt;
    protected int minscale;
    protected int maxscale;
    protected String secondPrompt;
    
    // Constructors
    public Question() {
        prompt = "Please enter something:";
        minscale = 1;
        maxscale = 10;
        secondPrompt = "Additional comments:";
    }
    
    // convenience constructor - uses all defaults EXCEPT the actual prompt
    public Question(String prompt) {
        this();  // calls the default constructor that takes no params
        this.prompt = prompt;
    }
    
    // fully specified constructor
    public Question(String prompt, int minscale, int maxscale, String secondPrompt) {
        this.prompt = prompt;
        this.minscale = minscale;
        this.maxscale = maxscale;
        this.secondPrompt = secondPrompt;
    }
    
    /**
     * Displays the question prompt and the scale hint
     */
    public void display() {
        System.out.println(prompt + "[" + minscale + "-" + maxscale + "]:");
    }
    
    public void displaySecond() {
        System.out.println(secondPrompt);
    }

    /**
     * Returns true if the given response is within the range.
     * @param scaleResponse - the user supplied response
     * @return true if scaleResponse between min and max 
     */
    public boolean checkResponse(int scaleResponse) {
        return scaleResponse>=minscale && scaleResponse<=maxscale;
    }
}
