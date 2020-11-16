import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class Teams {
    public static void createAndShowTeamWindow() {
        // Task Frame
        JFrame teamFrame = new JFrame("Add or remove teams");

        // Labels
        JLabel teamName = new JLabel("Team Name");
        JLabel teamLeader = new JLabel("Team Leader");
        JLabel teamRole = new JLabel("Team Role");
        JLabel teamMembers = new JLabel("Number of Members");

        // Panel
        JPanel teamPanel = new JPanel(new MigLayout());
        teamPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Add or remove teams"));

        // JTextFields
        JTextField teamNameField = new JTextField();
        JTextField teamLeaderField = new JTextField();
        JTextField teamRoleField = new JTextField();
        //JTextField teamMembersField = new JTextField();
        teamNameField.setPreferredSize(new Dimension(200, 24));
        teamLeaderField.setPreferredSize(new Dimension(200, 24));
        teamRoleField.setPreferredSize(new Dimension(200, 24));
        //teamMembersField.setPreferredSize(new Dimension(200, 24));

        // JComboBox
        String[] numberOfTeamMembers = {"1", "2", "3", "4", "5", ">6"};
        Object[] items;
        JComboBox teamMemberComboBox = new JComboBox(numberOfTeamMembers);
        teamMemberComboBox.setSelectedIndex(0);

        // JButton
        JButton addTeamButton = new JButton("Add team");


        // Adding components to panels
        teamPanel.add(teamName, "span");
        teamPanel.add(teamNameField, "span");
        teamPanel.add(teamLeader, "span");
        teamPanel.add(teamLeaderField, "span");
        teamPanel.add(teamRole, "span");
        teamPanel.add(teamRoleField, "span");
        teamPanel.add(teamMembers, "span");
        teamPanel.add(teamMemberComboBox, "span");
        teamPanel.add(addTeamButton, "dock south");

        // Setting frame
        teamFrame.add(teamPanel);
        teamFrame.setSize(new Dimension(1920, 1080));
        teamFrame.pack();
        teamFrame.setVisible(true);
    }
}
