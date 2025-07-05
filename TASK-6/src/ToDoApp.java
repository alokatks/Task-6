import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ToDoApp {
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskField;

    public ToDoApp() {
        JFrame frame = new JFrame("To-Do List App");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Input field
        taskField = new JTextField();
        frame.add(taskField, BorderLayout.NORTH);

        // Task list
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        frame.add(new JScrollPane(taskList), BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Task");

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Button actions
        addButton.addActionListener(e -> {
            String task = taskField.getText().trim();
            if (!task.isEmpty()) {
                taskListModel.addElement(task);
                taskField.setText("");
            }
        });

        deleteButton.addActionListener(e -> {
            int selected = taskList.getSelectedIndex();
            if (selected != -1) {
                taskListModel.remove(selected);
            }
        });

        frame.setVisible(true);
    }

   // public static void main(String[] args) {
      //  SwingUtilities.invokeLater(ToDoApp::new);

}
