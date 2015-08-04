/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clanmcbrien;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * You are responsible for scheduling a series of training courses for your
 * employees. Each employee will provide you a list of available dates that they
 * can attend. Write a class to return a list of the minimum number of dates
 * needed so that all employees attend once.
 * <p/>
 * Sample Data Set
 * [[1,2,5], [2,3,7], [5,7,9]] -> [2,5]
 */

public class ClassScheduler {
    public static Set<Integer> findValidTrainingDays(List<Set<Integer>> employeeAvailability) {
        /*  Treeset to maintain order -
        performance waived for smaller company < 100 */  
        Set<Integer> toPrint = new TreeSet<>();
        
        
        //Two Lists to compare.
        List<Set<Integer>> firstList = employeeAvailability;
        List<Set<Integer>> secondList = new ArrayList<>();        
        
        //Tidy title
        System.out.println("Inputs:");
        
        //Second list is hard copy
        for(Set<Integer> i : firstList){
            secondList.add(i);
            System.out.println(i);  
        }
        
        //Remove first element of second list
        secondList.remove(0);
                
        //Iterate through each set in firstList
        for(Set<Integer> i : firstList){            
            boolean matchFound = false;
            //Iterate through each integer in current set
            for(Integer ii : i){
                //For each set in secondList
                Iterator<Set<Integer>> iterSL = secondList.iterator();
                while(iterSL.hasNext()){
                    if(iterSL.next().contains(ii)){
                        toPrint.add(ii);                        
                        iterSL.remove();
                        matchFound = true;
                    }                    
                    
                } 
                        
            }
            //If one complete set has not match take first result.=
            if(matchFound == false){
                Iterator first = i.iterator();                
                toPrint.add(Integer.parseInt(first.next().toString()));                
            } 
           
        }            
        
        System.out.println();
        System.out.println();
        System.out.println("Result:");
        System.out.println(toPrint);
        
        return null;
    }
    
    public static List<Set<Integer>> prepareInput(String[] fromArgs) {
        
        List<Set<Integer>> starting = new ArrayList<>();
        
        for(String s : fromArgs) {            
            Set<Integer> set1 = new HashSet<>(); //Reinitialize each time
                        
            s = s.substring(1, s.length()-1); //Remove brackets
                        
            //Start scanner and set delimiter to ","(Comma)
            Scanner scanner = new Scanner(s); 
            scanner.useDelimiter(",");
            
            //Loop through to get all integers
            while (scanner.hasNextInt()) {
                set1.add(scanner.nextInt());
            }
            
            starting.add(set1); //Add to variable "starting"                        
        }
        
        return starting;
    }
    
}
