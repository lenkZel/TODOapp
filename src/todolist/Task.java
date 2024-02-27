package todolist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Task extends JPanel implements FocusListener {
    private JLabel index;
    private JTextField taskname;
    private JButton done;
    private JButton remove;

    public Task(String initialText) {
        GridLayout Layouttask = new GridLayout(1, 3);
        Layouttask.setHgap(5);
        this.setPreferredSize(new Dimension(400, 20));
        this.setBackground(new Color(255, 255, 255));
        this.setLayout(Layouttask);

        index = new JLabel("");
        index.setPreferredSize(new Dimension(10, 20));
        index.setHorizontalAlignment(JLabel.LEFT);
        index.setBackground(new Color(192, 192, 192));
        this.add(this.index);

        taskname = new JTextField(initialText);
        taskname.addFocusListener(this);
        taskname.setPreferredSize(new Dimension(10, 20));
        taskname.setBorder(BorderFactory.createEmptyBorder());
        taskname.setBackground(new Color(255, 255, 255));
        this.add(this.taskname);

        done = new JButton("Done");
        done.setPreferredSize(new Dimension(10, 20));
        done.setBackground(new Color(255, 153, 204));
        this.add(this.done);

        remove = new JButton("Remove");
        remove.setPreferredSize(new Dimension(10, 20));
        remove.setBackground(new Color(255, 153, 204));
        this.add(this.remove);
    }

    public void writeindexjl(int n) {
        this.index.setText(String.valueOf(n));
        this.revalidate();
    }

    public JButton getdonej() {
        return this.done;
    }

    public JButton getremovej() {
        return this.remove;
    }

    public void donestatus() {
        this.taskname.setBackground(Color.LIGHT_GRAY);
        this.index.setBackground(Color.LIGHT_GRAY);
        this.remove.setBackground(Color.LIGHT_GRAY);
        this.done.setBackground(Color.LIGHT_GRAY);
        this.setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (taskname.getText().equals("enter task")) {
            taskname.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {

    }

    public String getTaskname() {
        return taskname.getText();
    }

    public boolean isDone() {
        return taskname.getBackground() == Color.LIGHT_GRAY;
    }
}

