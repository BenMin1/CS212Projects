/*
 * This class is an abstract linked list for Date212 dates.
 */
import java.util.ArrayList;

public class Date212List {

    protected Date212Node first;
    protected Date212Node last;
    protected int length;

    //Constructor
    public Date212List(){

        //New empty list
        Date212Node ln = new Date212Node(null);
        first = ln;
        last = ln;
        length = 0;

    }//constructor

    //adds the date as a node to the end of the linked list
    public void append(Date212 addition){

        Date212Node n = new Date212Node(addition);
        last.next = n;
        last = n;
        length++;

    }//append

    //prints each element of the list
    public void printList(){

        Date212Node p = first.next;
        int i = 0;

        while(p!= null && i < length){
            System.out.println(p.data);
            p=p.next;
            i++;
        }//while
    }//printList

    //returns all elements of the list as a Date212 array list
    public ArrayList<Date212> returnList(){

        ArrayList<Date212> x = new ArrayList<>();
        Date212Node p = first.next;
        int i = 0;

        //while there are more elements remaining
        while(p!= null && i < length){
            x.add(p.data);
            p=p.next;
            i++;
        }//while

        return x;
    }//returnList
}
