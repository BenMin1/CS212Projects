/*
 * This class takes an input of a date in format string "yyyymmdd" and seperates the day month and years into three seperate integers
 * Note: Year must be in A.D, future possible dates are valid
 */

public class Date212 {

    private int day;
    private int month;
    private int year;

    //Constructor
    public Date212(String rawInput){

        //Only use substring on the right length input
        if(rawInput.length() == 8){
            this.day = Integer.parseInt(rawInput.substring(6,8));
            this.month = Integer.parseInt(rawInput.substring(4,6));
            this.year = Integer.parseInt(rawInput.substring(0,4));
            
            //If the date is invalid set all values to 0
            if(!checkValid(this.day, this.month, this.year)){
                this.day = 0;
                this.month = 0;
                this.year = 0;
            }//if checkValid

        }//if rawInputLength

        //If the date is invalid print that and set values to 0
        else{
            System.out.println("date entered is invalid");
            this.day = 0;
            this.month = 0;
            this.year = 0;
        }//else
    }//constructor

    //Method that checks if the Date212 variable is a valid date
    private boolean checkValid(int day, int month, int year){

        //Int array to reference length of the months
        int[] monthLengths = {31,28,31,30,31,30,31,31,30,31,30,31};
        boolean dateValid = true;

        //Check if year is valid
        if(year < 1) dateValid = false;

        //Set days of february depending on if it is a leap year
        if(month == 2 && year % 4 == 0) monthLengths[1] = 29;
        else monthLengths[1] = 28;

        //Check that month is valid
        if(month < 1 || month > 12) dateValid = false;

        //Check that day is in the month
        else if(day < 1 ||day > monthLengths[month-1]) dateValid = false;
   
        //Print if invalid
        if(dateValid == false){
            System.out.println("date entered is invalid");
        }

        return dateValid;
    }//checkValid

    //Returns a string mm/dd/yyyy from a Date212
    @Override 
    public String toString() {

        //String array to add /'s and 0's to the printing
        String[] seperator = {"", "/", "/"};

        if(month < 10) seperator[0] = "0";
        if(day < 10) seperator[1] = "/0";
        if(year < 1000) seperator[2] = "/0";
        if(year < 100) seperator[2] = "/00";
        if(year < 10) seperator[2] = "/000";

        String reformat = seperator[0] + month + seperator[1] + day + seperator[2] + year;
        return(reformat);
    }//toString

    //returns true if x and y are the same date
    public boolean checkEqual(Date212 x, Date212 y){

        if(x.year == y.year && x.month == y.month && x.day == y.day)
            return true;

        return false;
    }//checkEqual

    //returns true if x is an earlier date than y
    public boolean earlierThan(Date212 x, Date212 y){

        boolean i = false;

        if (x.year < y.year ) 
            i = true;

        if (x.year == y.year && x.month < y.month) 
            i = true;  

        if (x.year == y.year && x.month == y.month && x.day < y.day) 
            i = true; 

        return i;
    }//earlierThan

}
