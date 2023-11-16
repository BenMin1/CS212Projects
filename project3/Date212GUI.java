
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Date212GUI extends JFrame{
    //This method takes two array lists and intializes a gui with a (1 by 2) GridLayout displaying each list on their respective column
    public static void init(ArrayList<Date212> list1, ArrayList<Date212> list2) {
        JFrame myGUIdates = new JFrame();

        myGUIdates.setSize(400, 200);
        myGUIdates.setLocation(100, 100);
        myGUIdates.setTitle("Dates_Interface");
        myGUIdates.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myGUIdates.setLayout(new GridLayout(1,2));
        createMenu(myGUIdates);

        Container myContentPane = myGUIdates.getContentPane();
        TextArea myTextArea = new TextArea();
        TextArea mySubscripts = new TextArea();

        //create two panes, one for each side
        myContentPane.add(myTextArea);
        myContentPane.add(mySubscripts);

        String entry = "";

        //add each entry of the first list on a new line
        for(Date212 element : list1){
            entry = element + "\n";
            myTextArea.append(entry);
        }
        
        //add each entry of the second list on a new line
        for(Date212 element : list2){
            entry = element + "\n";
            mySubscripts.append(entry);
        }
        
        myGUIdates.setVisible(true);
    }//init

    public static void createMenu(JFrame frame) {
        JMenuBar menuBar  = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem item;
        FileMenuHandler fmh = new FileMenuHandler(frame);

        item = new JMenuItem("Open"); //open...
        item.addActionListener(fmh);
        fileMenu.add(item);

        fileMenu.addSeparator(); //add horizontal line

        item = new JMenuItem("Quit"); //quit
        item.addActionListener(fmh);
        fileMenu.add(item);

        frame.setJMenuBar(menuBar);
        menuBar.add(fileMenu);
     } //createMenu

}
