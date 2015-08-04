/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clanmcbrien;

import java.util.List;
import java.util.Set;

/**
 *
 * @author NelsonB
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        List<Set<Integer>> rawInput = ClassScheduler.prepareInput(args);
               
        
        //TODO REMOVE!!!
        //for(Set<Integer> i : rawInput){
          //  System.out.println(i.toString());
        //}
        
        
        
        ClassScheduler.findValidTrainingDays(rawInput);
    }
    
}
