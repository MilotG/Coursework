import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;

public class GUI {
    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Coursework");
        JPanel pnl = new JPanel(new MigLayout());
        JPanel pnl2 = new JPanel(new MigLayout());
        JPanel pnl3 = new JPanel(new MigLayout());
        JPanel pnl4 = new JPanel(new MigLayout());
        MenuBar appMenu = new MenuBar();
        Tasks tsk = new Tasks();
        Teams teams = new Teams();
        Projects projects = new Projects();


        // Setting up JMenu
        appMenu.menuBar.add(appMenu.menu);
        appMenu.menu.add(appMenu.exit);
        frame.setJMenuBar(appMenu.menuBar);
        // Enter app closes when exid button is closed
        appMenu.exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Setting up Team Labels
        TeamLabel currentTeam = new TeamLabel();
        TeamLabel teamLabel  = new TeamLabel();
        pnl.add(currentTeam.currentTeam, "split");
        pnl.add(teamLabel.teamLabel, "wrap");


        // Setting up JTable
        Table table = new Table();
        //model = new DefaultTableModel(table.clm.getColumn(), table.columnName);
        table.tbl.setBounds(50, 50, 500, 1000);
        table.tbl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.tbl.setRowSelectionAllowed(true);
        pnl2.add(new JScrollPane(table.tbl));
        pnl2.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Done"));


        // Setting up JTable
        Table table2 = new Table();
        table2.tbl.setBounds(50, 50, 500, 1000);
        table2.tbl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table2.tbl.setRowSelectionAllowed(true);
        pnl3.add(new JScrollPane(table2.tb2));
        pnl3.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Doing"));

        // Setting up JTable
        Table table3 = new Table();
        table3.tbl.setBounds(50, 50, 500, 1000);
        table3.tbl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table3.tbl.setRowSelectionAllowed(true);
        pnl4.add(new JScrollPane(table3.tbl));
        pnl4.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "To Do"));


        // Setting up Buttons
        JButton newTaskButton = new JButton("Add new task");
        newTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tsk.createAndShowTasksWindow();
            }
        });
        pnl.add(newTaskButton);

        JButton newTeamButton = new JButton("Add new team");
        newTeamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teams.createAndShowTeamWindow();
            }
        });

        pnl.add(newTeamButton, "wrap");


        JButton projectButton = new JButton("Create or Remove Projects");
        projectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                projects.createAndShowProjectWindow();
            }
        });
        pnl.add(projectButton);


        JButton deleteTaskButton = new JButton("Delete");
        deleteTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        pnl.add(deleteTaskButton);


        JButton clearSelectionButton = new JButton("Clear task selection");
        clearSelectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table.tbl.clearSelection();
                table2.tb2.clearSelection();
                table3.tbl.clearSelection();
            }
        });
        pnl.add(clearSelectionButton, "wrap");



        // Adding table panels to main panel
        pnl.add(pnl2);
        pnl.add(pnl3);
        pnl.add(pnl4);



        // Setting up JPanel
        frame.add(pnl);
        // Setting up frame size, closing behaviour and visibility
        frame.setSize(new Dimension(1920, 1080));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}

class MenuBar {
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("File");
    JMenuItem exit = new JMenuItem("Exit");
}

class Table {
    String[] columnName = { "Task name", "Team", "Start date", "Completion data"};
    Table1Data clm  = new Table1Data();
    Table2Data clm2  = new Table2Data();

    JTable tbl = new JTable(clm.getColumn(), columnName);
    JTable tb2 = new JTable(clm2.getColumn(), columnName);
}

class TeamLabel {
    JLabel currentTeam = new JLabel("Current Team:");
    JLabel teamLabel = new JLabel("Team Alpha");
}


class Tasks {
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
        tskPanel.add(tskCategoryField,"span");
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

class Teams {
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
        teamPanel.add(teamLeader,"span");
        teamPanel.add(teamLeaderField, ", span");
        teamPanel.add(teamRole, "span");
        teamPanel.add(teamRoleField, "span");
        teamPanel.add(teamMembers,"span");
        teamPanel.add(teamMemberComboBox,"span");
        teamPanel.add(addTeamButton, "dock south");

        // Setting frame
        teamFrame.add(teamPanel);
        teamFrame.setSize(new Dimension(1920, 1080));
        teamFrame.pack();
        teamFrame.setVisible(true);
    }
}


class Projects {
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
