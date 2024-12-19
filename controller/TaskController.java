package controller;

import model.Task;
import view.TaskView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TaskController {
    private List<Task> tasks;
    private TaskView view;

    public TaskController(TaskView view) {
        this.view = view;
        this.tasks = new ArrayList<>();

        // Add event listeners
        this.view.addAddTaskListener(new AddTaskListener());
        this.view.addMarkCompletedListener(new MarkCompletedListener());
    }

    private class AddTaskListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String taskName = view.getTaskInput();
            if (!taskName.isEmpty()) {
                Task task = new Task(taskName);
                tasks.add(task);
                view.addTaskToList(task.toString());
                view.clearTaskInput();
            } else {
                JOptionPane.showMessageDialog(view, "Task name cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class MarkCompletedListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedIndex = view.getSelectedTaskIndex();
            if (selectedIndex >= 0 && selectedIndex < tasks.size()) {
                Task task = tasks.get(selectedIndex);
                task.setCompleted(true);
                view.updateTaskInList(selectedIndex, task.toString());
            } else {
                JOptionPane.showMessageDialog(view, "Please select a task!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
