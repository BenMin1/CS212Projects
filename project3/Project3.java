/*
 * This application reads an input file of dates of strings in the form yyyymmdd .
 * It uses a string tokenizer to seperate between the dates finding ","s.
 * It stores the valid dates in two abstract linked lists with one ordered as read and the other sorted by date
 * It retrieves the information from the linked lists and stores it in an array list 
 * It displays the dates in a 1x2 GUI with the left side ordered as read and the right side ordered by date.
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Project3 {

   public static StringTokenizer myTokens;
   public static String[] lineList;
   public static Date212 first;

   //This methods reads the chosenFile and displays valid dates in a GUI
   public static void tokenizeRead(String chosenFile) throws IOException {

      String line = " ";

      //abstract linked lists to add valid dates to 
      SortedDate212List sortList = new SortedDate212List();
      UnsortedDate212List unsortList = new UnsortedDate212List();

      FileInputStream fis = new FileInputStream(chosenFile);
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
            * Add only valid dates to the linked lists
            */
            for (int j=0;j<lineList.length;j++){

               //change raw input into a date
               first = new Date212(lineList[j]);

               //relpace yyyymmdd with mm/dd/yyyy
               lineList[j] = first.toString();

               //if valid, add to linked lists
               if(!(lineList[j].equals("00/00/0000"))){
                  sortList.add(first);
                  unsortList.add(first);
               }

            }//for j

         }//if

      }//while line not null

      br.close();

      //create two Date212 array lists of the correct size
      ArrayList<Date212> unsortArrayList = new ArrayList<>();
      ArrayList<Date212> sortArrayList = new ArrayList<>();
      
      //fill array lists from their respective abstract linked list
      unsortArrayList = sortList.returner();
      sortArrayList = unsortList.returner();

      //initialize GUI with lists
      Date212GUI.init(unsortArrayList, sortArrayList);
   }//tokenizeRead

   public static void main(String[] args){

      //create two empty array lists
      ArrayList<Date212> a = new ArrayList<>();
      ArrayList<Date212> b = new ArrayList<>();
      
      //initialize an empty GUI
      Date212GUI.init(a,b);
  }//main

}
