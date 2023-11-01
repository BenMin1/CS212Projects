
public class UnsortedDate212List extends Date212List{

    //Constructor
    public UnsortedDate212List(){

        //New empty list
        Date212Node ln = new Date212Node(null);
        first = ln;
        last = ln;
        length = 0;

    }//constructor

    //super method to append new entries
    public void add(Date212 addition){
        super.append(addition);
    }

    //super method to print all entries
    public void printer(){
        super.printList();
    }

    //super methos to return all entries as a Date212[]
    public Date212[] returner(){
        return super.returnList();
    }
}
