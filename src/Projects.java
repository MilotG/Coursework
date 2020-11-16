import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class Projects {
    public static void createAndShowProjectWindow() {
        // Task Frame
        JFrame teamFrame = new JFrame("Create & Remove Projects");

        // Main Panel
        JPanel mainPanel = new JPanel(new MigLayout());


        // Create Panel
        JPanel createPojectPanel = new JPanel(new MigLayout());
        createPojectPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Create new Project"));

        // Delete Panel
        JPanel removePojectsPanel = new JPanel(new MigLayout());
        removePojectsPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Remove Projects"));

        // Jlabel:- Create
        JLabel createProjectLabel = new JLabel("Project Name");

        // JLabel:- Delete
        JLabel removeProjectLabel = new JLabel("Remove Project");


        // Adding components to Create Panel
        createPojectPanel.add(createProjectLabel);


        // Adding components to Remove Panel
        removePojectsPanel.add(removeProjectLabel, "span");


        // Setting Up Panels
        mainPanel.add(createPojectPanel);
        mainPanel.add(removePojectsPanel);

        // Setting frame
        teamFrame.add(mainPanel);
        teamFrame.setSize(new Dimension(1920, 1080));
        teamFrame.pack();
        teamFrame.setVisible(true);
    }
}
