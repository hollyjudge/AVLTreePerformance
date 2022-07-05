/**
*represents a student with a name and ID
*/

public class Students implements Comparable<Students>
{
    
    String student_ID; 
    String student_Name;            

    /**
    * creates a student object taking in both student ID and name
    */
    
   public Students(String studentID, String studentName)
   {
     student_ID=studentID; 
     student_Name=studentName;
   }
   
   /**
   * creates a student object using only studentID 
   * this constructor is needed in AccessAVLApp in the printStudent method
   */
   
   public Students(String studentID)
   {
     student_ID=studentID;
   }
  
   
   /**
   * returns student ID and name string
   */
      
   public String toString()
   {
     return student_ID + " " +student_Name;
       
   }
   
   public String getStudentName()
   {
       return student_Name;
   }
   
   public String getStudentID()
   {
      return student_ID;
   }
   
   /**
   * compares two student ID's
   * needed for the AVL tree to insert and find
   */
   
    public int compareTo(Students other)
    {
          return String.valueOf(this.student_ID).compareTo(String.valueOf(other.student_ID));
    }
} 





















