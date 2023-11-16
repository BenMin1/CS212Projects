import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class FileMenuHandler implements ActionListener {
    JFrame jframe;

    public FileMenuHandler(JFrame jf) {
        jframe = jf;
    }

    public void actionPerformed(ActionEvent event) {
        String  menuName;
        menuName = event.getActionCommand();
        if (menuName.equals("Open"))
            try{
                jframe.dispose();
                openFile();
            }
            catch(IOException b){
                System.out.println("IOException error");
            }
            finally{
            }

        else if(menuName.equals("Quit"))
            System.exit(0);
    } //actionPerformed

    private void openFile() throws IOException{
        JFileChooser chooser;
        int status;
        chooser = new JFileChooser();
        status = chooser.showOpenDialog(null);
        if(status == JFileChooser.APPROVE_OPTION) 
            readSource(chooser.getSelectedFile());
        else 
            JOptionPane.showMessageDialog(null, "Open File dialog canceled");
    } //openFile
  
    private void readSource(File chosenFile) throws IOException {
        String chosenFileName = chosenFile.getAbsolutePath();

        //reads through desired file, arranges into a sorted an unsorted array and initializes a GUI
        Project3.tokenizeRead(chosenFileName);  
    }
}
