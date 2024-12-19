package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TaskView extends JFrame {
    private JTextField taskInputField;
    private JButton addTaskButton;
    private JButton markCompletedButton;
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;

    public TaskView() {
        // Frame setup
        setTitle("Task Manager");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Task input panel
        JPanel inputPanel = new JPanel(new FlowLayout());
        taskInputField = new JTextField(20);
        addTaskButton = new JButton("Add Task");
        inputPanel.add(taskInputField);
        inputPanel.add(addTaskButton);

        // Task list panel
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Mark completed button
        markCompletedButton = new JButton("Mark Completed");

        // Add components to frame
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(markCompletedButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    public String getTaskInput() {
        return taskInputField.getText();
    }

    public void clearTaskInput() {
        taskInputField.setText("");
    }

    public int getSelectedTaskIndex() {
        return taskList.getSelectedIndex();
    }

    public void addTaskToList(String task) {
        taskListModel.addElement(task);
    }

    public void updateTaskInList(int index, String task) {
        taskListModel.set(index, task);
    }

    public void addAddTaskListener(ActionListener listener) {
        addTaskButton.addActionListener(listener);
    }

    public void addMarkCompletedListener(ActionListener listener) {
        markCompletedButton.addActionListener(listener);
    }
}
