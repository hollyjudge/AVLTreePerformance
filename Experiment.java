/**
* class used to carry out the experiment phase of assignment
* determines the min, max and average counts for find operations
* gets these numbers by calling printStudent from AccessAVLApp
* this retrieves the find counter from AVLTree
* executed in GUI.py where the user can input desired subset
* outputs best, worst and average number of operations for find AND insert
*/

import java.io.*; 

public class Experiment   
{    
    public static void main (String [] args) throws Exception
    {
      int count=0; 
      double average=0; 
      int minFind=0;
      int maxFind=0; 
       
      AccessAVLApp AVLApp= new AccessAVLApp();       
      AVLApp.initializeAVL(); 
      
      if (args.length>0)
      {
            AVLApp.printStudent(args[0]); 
            count=AVLApp.countFind; 
            minFind=count;
            maxFind=count;  
            average+=count; 

         for (int i=1; i<args.length-1; i++)
         { 
            AVLApp.printStudent(args[i]); 
            count=AVLApp.countFind;
            average+=count; 

            if (count>maxFind)
              maxFind=count;
            if (count<minFind)
              minFind=count;
        }

      }
        
        average= average/args.length;
        System.out.println("\n" + "Best insert case: " + AVLApp.minInsert + "\n" + "Worst insert case: " + AVLApp.maxInsert + "\n" + "Average insert case: " + AVLApp.countAverageInsert + "\n");
        System.out.println("Best find case: " + minFind + "\n" + "Worst find case: "  + maxFind + "\n" + "Average find case: " + average);  
        
    } 
  
}