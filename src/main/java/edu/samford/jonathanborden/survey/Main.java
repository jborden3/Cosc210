/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.jonathanborden.survey;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author kartoone
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Welcome to COSC 210!");
        Survey survey = new Survey(9);
        survey.addQuestion("How familiar are you with Netbeans?");
        survey.addQuestion("How well do you understand the differences between classes, objects, and types?");
        survey.addQuestion("How well do you understand creating and using methods?");
        survey.addQuestion("How well can you formulate mathematical or logical expressions (e.g., if statements)?");
        survey.addQuestion("How familiar are you with control flow statements such as if, while, for, switch, etc...");
        survey.addQuestion("How familiar are you with arrays?");
        survey.addQuestion("How good are you at reading from / writing to files?");
        survey.addQuestion("How familiar are you with the concept of packages?");
        survey.addQuestion("How comfortable are you with designing, coding, testing, and debugging a complete program?");

        SurveyResponse response = survey.conduct();
        LocalDate date = LocalDate.now();
        LocalTime time= LocalTime.now();
        String filename = date + time.toString().replace(':', '_')+".txt";
        response.save(filename);
        
    }
    
}