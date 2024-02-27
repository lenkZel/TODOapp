package todolist;

import javax.swing.*;
import java.awt.*;

//BIELY list
public class List extends JPanel {
    public List(){
        GridLayout Layout = new GridLayout(10,1);
        Layout.setVgap(5);                                      //nastavenie vertikálnej medzery medzi jednotlivými taskami
        this.setLayout(Layout);
        this.setBackground(new Color(255,255,255));
    }
    public void indexnum(){
        Component[] listcomp = this.getComponents();
        for (int i = 0; i < listcomp.length; i++) {
            if(listcomp[i] instanceof Task){
                ((Task) listcomp[i]).writeindexjl(i+1);
            }
        }
    }
}
