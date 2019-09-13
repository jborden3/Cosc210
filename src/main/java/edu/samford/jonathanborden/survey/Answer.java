package edu.samford.jonathanborden.survey;

import java.util.Scanner;

/**
 * Represents the answer to a survey question.
 * @author kartoone
 */
public class Answer {
    // Attributes
    protected Question q;                   // reference to the question being answered
    protected int scaleResponse;            // user selected response ... should be within q's range
    protected String additionalResponse;    // user comments
    
    /**
     * Convenience constructor that provides some meaningful defaults
     */
    public Answer(Question q) {
        this.q = q;
        this.scaleResponse = q.minscale;
        this.additionalResponse = "N/A";
    }
    public Answer(Question q, int scsleResponse,String additionalResponse){
        this.q =q;
        this.scaleResponse = scaleResponse;
        this.additionalResponse =additionalResponse;
    }
    /**
     * Retrieve the answer to the scale question from stdin (i.e., the keyboard)
     * and store that answer in the scaleResponse attribute.
     * @param stdin 
     */
    public void getScaleResponse(Scanner stdin) {
        // 1. Get the user response (for the scale prompt)
        // 2. Check the response to make sure it is within the question's range
        // 3. If not, display error message and go back to step 1
        do {
            scaleResponse = Integer.parseInt(stdin.nextLine());
            // don't do this:
            // if (scaleResponse<q.minscale || scaleResponse>q.maxscale)
            if (!q.checkResponse(scaleResponse)) {
                System.out.println("Please try again. Outside valid range.");
            }
        } while (!q.checkResponse(scaleResponse));
    }
    
    /**
     * Stores the second response in the additionalResponse attribute.
     * @param stdin 
     */
    public void getSecondResponse(Scanner stdin) {
        additionalResponse = stdin.nextLine();
    }
}