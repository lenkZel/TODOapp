package todolist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AppFrame extends JFrame{
    private JButton addtask;
    private JButton clear;
    private Database database;

    private JTextField novyText;

    TitleBar title = new TitleBar();
    BtnPanel btnpanel = new BtnPanel();
    List list = new List();

    public AppFrame() throws SQLException {
        this.setTitle("TODOapp");
        this.setSize(400, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(this.title, BorderLayout.NORTH);
        this.add(this.btnpanel, BorderLayout.SOUTH);
        this.add(this.list, BorderLayout.CENTER);

        addtask = btnpanel.getaddtaskbtn();
        clear = btnpanel.getclearbtn();
        novyText = new JTextField();
        addlistener();

        database = new Database();
    }
    public void addlistener() {
        addtask.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Task task = new Task(novyText.getText());
                list.add(task);
                list.indexnum();
                revalidate();                               //prepočítanie rozmerov komponent

                addTaskToDatabase(task);

                JButton done = task.getdonej();
                done.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        task.donestatus();
                        revalidate();
                    }
                });
                JButton remove = task.getremovej();
                remove.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        list.remove(task);
                        list.indexnum();
                        revalidate();
                        repaint();
                    }
                });
            }
        });
        clear.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Component[] tasklist = list.getComponents();
                for (int i = 0; i < tasklist.length; i++) {
                    if (tasklist[i] instanceof Task) {
                        list.remove((Task) tasklist[i]);
                    }
                }
                revalidate();
                repaint();
            }
        });

    }
    public void addTaskToDatabase(Task task) {
        String taskName = task.getTaskname();
        boolean isDone = task.isDone();

        String query = "INSERT INTO tasks (task_name, is_done) VALUES (?,?)";
        try {
            PreparedStatement statement = database.getConnection().prepareStatement(query);
            statement.setString(1, taskName);
            statement.setBoolean(2, isDone);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Query: " + query);
        System.out.println("Task Name: " + taskName);
        System.out.println("Is Done: " + isDone);
    }
}
