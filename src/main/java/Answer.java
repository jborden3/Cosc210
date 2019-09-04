/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *Represents the answer to a survey question. 
 * @author borde
 */
public class Answer {
    protected Question q;// reference to the question being answered.
    // Atrtibutes 
    protected int scaleResponse; // user selected response... should
    protected String additionalResponse;// user comments 
    /**
     * Represents a default answer.
     */



public Answer(Question q){
this.q = q;
this.scaleResponse= q.minScale;
this.additionalResponse = "N/A";
}
/**
 * Retrieve the answer to the scale question from stdin(i.e., the keyboard)
 * and store that answer in the scaleResponse attribute.
 * @param stdin 
 */
public void getScaleResponse(Scanner stdin){
//1.Get the user response for the scale propmt
//2.Check the response to make sure it is within the question's range
//3.If not, display error message and go back to step 1 
do{
    this.scaleResponse = Integer.parseInt(stdin.nextLine());
    if (!q.checkResponse(scaleResponse)){
        System.out.println("Please try again. Outside valid range");
    }
}while(!q.checkResponse(scaleResponse));

    }
public void getSecondResponse(Scanner stdin){
    additionalResponse = stdin.nextLine();
}
}
