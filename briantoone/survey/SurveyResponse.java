/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.briantoone.survey;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 *
 * @author kartoone
 */
public class SurveyResponse {
    // Attributes
    protected Answer[] answers;
    protected int numanswers;
    
    public SurveyResponse(int size) {
        this.numanswers = 0;
        this.answers = new Answer[size];
    }

    /**
     * Record the answer into our answers array.
     * @param answer 
     */
    void addAnswer(Answer answer) {
        answers[numanswers++] = answer;
    }

    void save(String filename) throws FileNotFoundException {
        File f = new File(filename);
        PrintWriter out = new PrintWriter(f);
    }
    
}
