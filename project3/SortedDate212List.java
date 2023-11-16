
import java.util.ArrayList;

public class SortedDate212List extends Date212List{
    
    //Constructor
    public SortedDate212List(){

        //New empty list
        Date212Node ln = new Date212Node(null);
        first = ln;
        last = ln;
        length = 0;

    }//constructor

    //this method will add the date into the ordered position in the list
    public void add(Date212 addition){

        Date212Node p = new Date212Node(addition);
        Date212Node prev = new Date212Node(addition);
        Date212Node n = new Date212Node(addition);

        //if the list is not empty set p to the first entry
        if(first.next!=null){
            p = first.next;
            prev = first.next;
        }

        //if the addition comes before the first entry, add it accordingly
        if(addition.earlierThan(addition,p.data) || addition.checkEqual(addition, p.data)){

            //for an empty list, n.next should be null
            if(first.next!=null)
                n.next = p;

            //set n as the first entry
            first.next = n;
            length++;
        }
        
        //if the addition does not happen before the first entry
        else{

            int i = 0;

            while (p != null && i == 0){

                //at the point where the addition comes after prev and before p
                if(addition.earlierThan(addition, p.data)){
                    n.next = p;
                    prev.next = n;
                    length++;
                    //end the while loop
                    i = 1;
                }

                //increment p and prev
                prev = p;
                p = p.next;
            }

            //if the addition comes after the last entry add it accordingly
            if(addition.earlierThan(prev.data, addition)){
                prev.next = n;
                length++;
            }//if
        }//else
    }//add

    //super method to print the list
    public void printer(){
        super.printList();
    }//printer

    //super method to return list as Date212 array list
    public ArrayList<Date212> returner(){
        return super.returnList();
    }//returner

}
