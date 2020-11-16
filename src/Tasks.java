import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tasks {
    static String name;

    public static void createAndShowTasksWindow() {
        // Task Frame
        JFrame taskFrame = new JFrame("Add & Modify Tasks");

        // Labels
        JLabel taskName = new JLabel("Task Name");
        JLabel tskDescription = new JLabel("Task Description");
        JLabel tskCategory = new JLabel("Task Category");

        // Panel
        JPanel tskPanel = new JPanel(new MigLayout());
        tskPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Add or remove tasks here"));


        // JTextFields
        JTextField tskNameField = new JTextField();
        JTextField tskCategoryField = new JTextField();
        tskNameField.setPreferredSize(new Dimension(200, 24));
        tskCategoryField.setPreferredSize(new Dimension(200, 24));

        // JTextAreas
        JTextArea tskDescriptionArea = new JTextArea();
        tskDescriptionArea.setPreferredSize(new Dimension(200, 150));

        // JButton
        JButton addTaskButton = new JButton("Add task");
        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = tskNameField.getText();
            }
        });

        // Adding components to panels
        tskPanel.add(taskName, "span");
        tskPanel.add(tskNameField, "span");
        tskPanel.add(tskCategory, "span");
        tskPanel.add(tskCategoryField, "span");
        tskPanel.add(tskDescription, ", span");
        tskPanel.add(tskDescriptionArea, "span");
        tskPanel.add(addTaskButton, "dock south");


        // Setting frame
        taskFrame.add(tskPanel);
        taskFrame.setSize(new Dimension(1920, 1080));
        taskFrame.pack();
        taskFrame.setVisible(true);
    }
}
