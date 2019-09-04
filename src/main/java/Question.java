/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Represents a question in our survey.
 * @author borde
 */
public class Question {
    protected String prompt;
    protected int minScale;
    protected int maxScale;
    protected String secondPrompt;
    
    // Constructors 


public Question(){

this.prompt = prompt;
}

public Question(String prompt, int minscale, int maxscale, String secondPrompt){

this.prompt = prompt;
this.minScale = minScale;
this.maxScale= maxScale;
this.secondPrompt= secondPrompt;
}

    Question(String prompt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
public void display(){
    
}


/**
 * Returns true if the given response is in the range.
 * @param scaleResponse- the user supplied response
 * @return true if scaleResponse between min and max.
 */
    public boolean checkResponse(int scaleResponse) {
     return scaleResponse >= minScale && scaleResponse<=maxScale;
    }
    
}

   