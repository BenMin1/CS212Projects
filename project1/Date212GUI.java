
import javax.swing.*;
import java.awt.*;

public class Date212GUI{

    //This method takes two lists and intializes a gui with a (1 by 2) GridLayout displaying each list on their respective column
    public static void init(Date212 list1[], Date212 list2[]) {
        JFrame myGUIdates=new JFrame();

        myGUIdates.setSize(400, 200);
        myGUIdates.setLocation(100, 100);
        myGUIdates.setTitle("Dates_Interface");
        myGUIdates.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myGUIdates.setLayout(new GridLayout(1,2));

        Container myContentPane = myGUIdates.getContentPane();
        TextArea myTextArea = new TextArea();
        TextArea mySubscripts = new TextArea();

        //create two panes, one for each side
        myContentPane.add(myTextArea);
        myContentPane.add(mySubscripts);

        String entry = "";

        //add each entry of the first list on a new line
        for(int i=0; i< list1.length; i++){
            entry = list1[i] + "\n";
            myTextArea.append(entry);
        }
        
        //add each entry of the second list on a new line
        for(int i=0; i< list2.length; i++){
            entry = list2[i] + "\n";
            mySubscripts.append(entry);
        }

        myGUIdates.setVisible(true);
    }//init
}
