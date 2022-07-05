import java.io.*; 
import java.util.Scanner;

/**
* creates AVL tree from textfile
* populates it with student objects from student class
* method to print all nodes from tree   
* method to retrive a node and its content given a student ID
* method toString is called on node and string manipulation to get name
* number of insert operations counted as items inserted
*/
     
public class AccessAVLApp
{
      Scanner scan;           
      static AVLTree<Students> studentAVL= new AVLTree<Students> (); 
      double countAverageInsert; 
      int minInsert=0;
      int maxInsert=0;
      int numStudents=0;
      int countFind; 
      
      /**
      * uses insert method from AVLTree class to populate an AVL
      * string manipulation to seperate the student from the student ID
      * a student object is created and inserted into aN AVL 
      * student object has a  ID and a student name
      * when AVLTree insert method is called AVLTree var counterInsert increments
      * average, max and min is calculated
      * resetInsert method is to set counterInsert to 0
      * catch if file does not exist 
      */
                 
      public void initializeAVL()
      {
         File file=new File("../data/oklist.txt");
         
          try
         {
           scan= new Scanner(file);
           String nextLine;
           String name;
           String ID;
           int count=0;
           
           //first loop to get starting max and min
           
           nextLine=scan.nextLine();
           name= nextLine.substring(nextLine.indexOf(" ")+1); 
           ID= nextLine.substring(0, nextLine.indexOf(" "));
           studentAVL.insert(new Students(ID, name));
           count= studentAVL.counterInsert;
           studentAVL.resetInsert();
           maxInsert=count;
           minInsert=count; 
           countAverageInsert=countAverageInsert+count;
           numStudents++; 

           while (scan.hasNextLine())
           {
             nextLine=scan.nextLine();
             name= nextLine.substring(nextLine.indexOf(" ")+1); 
             ID= nextLine.substring(0, nextLine.indexOf(" "));
             studentAVL.insert(new Students(ID, name));
             count= studentAVL.counterInsert;
             studentAVL.resetInsert(); 
             countAverageInsert= countAverageInsert+count;
             numStudents++; 
                          
             if (count>maxInsert)
                maxInsert=count; 
             if (count<minInsert)
                minInsert=count;
                 
           }
          
           countAverageInsert=(countAverageInsert/numStudents-1); 

         }
          catch (Exception e)
         { 
         }

      }
            
      /**
      * invokes treeOrder method from AVLTree class that traverses tree
      * returns all values of tree
      */
      public void printAllStudents()
      {
        studentAVL.treeOrder(); 
      }

     /**
     * returns student associated with student ID else "access denied"
     * invokes find method from AVLTree class and uses a
     * new student object with studentID as a parameter
     * returns student name only if found
     * counterFind is incremented in AVLTree class when find method called
     * value captured in countFind
     + counterFind is reset to 0
     */

    public void printStudent(String studentID)
    { 
       String name;
       
       try
       {
         name=(studentAVL.find(new Students(studentID)).data.toString());
         System.out.println(name.substring(name.indexOf(" ")+1));           
         countFind= studentAVL.counterFind; 
       }
       
       catch (Exception e)
       {
         System.out.println("Access Denied!"); 
       }
       
     studentAVL.resetFind(); 
    }
    
    /** 
    * instantiates AccessAVLApp class in order to be able to call methods
    * checks how many arguments are being passed through
    * if none prints all elements of AV;
    * if one invokes printStudent method
    * and prints student name associated with ID given
    */
    
    
    public static void main (String[] args)
    {             
 
       AccessAVLApp AVLApp= new AccessAVLApp();  
       AVLApp.initializeAVL(); 
                      
       if (args.length==0)
        AVLApp.printAllStudents();
       else if (args.length>0)
         AVLApp.printStudent(args[0]);
             
    }
}
