/*
 * This application reads an input file of dates of strings in the form yyyymmdd .
 * It uses a string tokenizer to seperate between the dates finding ","s.
 * It displays the dates in a 1x2 GUI with the left side ordered as read and the left ordered by date.
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Project1 {

   public static StringTokenizer myTokens;
   public static String[] lineList;
   public static String line = " ";
   public static Date212 first;

   public static void main(String[] args) throws IOException {

      //arraylist to add valid dates to 
      ArrayList<Date212> dateList = new ArrayList<>();

      FileInputStream fis = new FileInputStream("C:\\Users\\sneeky\\Desktop\\project1\\project1input.txt");
      BufferedReader br = new BufferedReader(new InputStreamReader(fis));

      //while there is input to read
      while(line !=null){   
         line = br.readLine();

         if(line != null){
            /*
            * Create a new StringTokenizer, passing the String and the delimeter (",")
            */
            myTokens = new StringTokenizer(line,",");

            //System.out.println("There are "+myTokens.countTokens()+" tokens in the line.");
            /*
            * Declare an array whose size is equal to the number of tokens found
            * using the method countTokens from the StringTokenizer class
            */
            lineList = new String[myTokens.countTokens()];

            /*
            * Get the separated strings one by one from the StringTokenizer and put
            * them in the array   
            */
            int i=0;

            while (myTokens.hasMoreTokens()) {

               lineList[i]=myTokens.nextToken();
               i++;
            }

            /*
            * Add only valid dates to the arraylist
            */
            for (int j=0;j<lineList.length;j++){

               //change raw input into a date
               first = new Date212(lineList[j]);

               //relpace yyyymmdd with mm/dd/yyyy
               lineList[j] = first.toString();

               //if valid add to arraylist
               if(!(lineList[j].equals("00/00/0000")))
                  dateList.add(first);

            }//for j

         }//if line not null

      }//while line not null

      br.close();
      
      //create two string lists of the correct size
      Date212[] unordered = new Date212[dateList.size()];
      Date212[] ordered = new Date212[dateList.size()];

      //fill lists with valid dates
      for (int j=0;j<dateList.size();j++){
         ordered[j] = dateList.get(j);
         unordered[j] = dateList.get(j);
      }

      //use selection sort to sort ordered array
      ordered = Date212.compareTo(ordered);

      //initialize GUI with lists
      Date212GUI.init(unordered, ordered);
   }//main
}
