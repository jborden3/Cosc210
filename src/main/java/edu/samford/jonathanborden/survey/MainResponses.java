/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.jonathanborden.survey;

import java.io.FileNotFoundException;

/**
 *This program depends on the order of the answers being known
 * @author borde
 */
public class MainResponses {
    public static void main(String[] args) throws FileNotFoundException {
        //1. Create the survey and add all the questions in same order as answers
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

        SurveyResults results = new SurveyResults(survey);
        //2. Create an empty SurveyResults object
        //3. Loop through the directory containing all the responses and read each one into their own SurveyResponse Object
             // this is done internally in the SurveyResults class
             results.readResponses("results");
             results.processResponses();
    }
}
