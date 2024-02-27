package todolist;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

//SLABORUZOVY spodný panel
public class BtnPanel extends JPanel {
    private JButton addtask;
    private JButton clear;

    Border emptyborder = BorderFactory.createEmptyBorder();

    public BtnPanel(){
        this.setPreferredSize(new Dimension(400,80));
        this.setBackground(new Color(255,204,204));

        addtask = new JButton("Add Task");
        addtask.setBorder(emptyborder);
        addtask.setFont(new Font("San-serif", Font.PLAIN, 20));
        addtask.setBackground(new Color(255,204,204));
        this.add(addtask);

        this.add(Box.createHorizontalStrut(20));  //vytvorenie priestoru pre tasky, ktore sa budu postupne pridavat do listu

        clear = new JButton("Clear All Task");
        clear.setBorder(emptyborder);
        clear.setFont(new Font("San-serif", Font.PLAIN, 20));
        clear.setBackground(new Color(255,204,204));
        this.add(clear);
    }

    public JButton getaddtaskbtn(){
        return addtask;
    }
    public JButton getclearbtn(){
        return clear;
    }
}
