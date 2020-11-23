import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.concurrent.ThreadLocalRandom;

public class GUI {
    static String returnName;
    String Ralph ="Ralph";
    public GUI() {

        ArrayList<String> listOfTeams = new ArrayList<>();
        ArrayList<TaskKotlin> listOfTasks = new ArrayList<>();
        AllTeams allTeams = new AllTeams();
        // Main JFrame
        JFrame frame = new JFrame("Coursework");

        // Main JPanel
        JPanel panel1 = new JPanel(new MigLayout());

        JPanel taskPanel = new JPanel(new MigLayout());
        taskPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder("Add tasks")));

        JPanel teamPanel = new JPanel(new MigLayout());
        teamPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder("Add teams")));


        // Task JLabels
        JLabel taskName = new JLabel("Task name");
        JLabel taskTeam = new JLabel("Team");
        JLabel taskPredecessor = new JLabel("Predecessor");
        JLabel taskDuration = new JLabel("Duration in hours");

        // Task TextFields
        JTextField taskNameField = new JTextField();
        taskNameField.setPreferredSize(new Dimension(200, 24));
        JTextField taskTeamField = new JTextField();
        taskTeamField.setPreferredSize(new Dimension(200, 24));

        Object[] items;
        JComboBox teamLists = new JComboBox();

        JTextField taskPredecessorField = new JTextField();
        taskPredecessorField.setPreferredSize(new Dimension(200, 24));
        JTextField taskDurationField = new JTextField();
        taskDurationField.setPreferredSize(new Dimension(200, 24));


        // Team JLabels
        JLabel teamName = new JLabel("Team name");
        JLabel teamDepartment = new JLabel("Department");

        // Team TextFields
        JTextField teamNameField = new JTextField();
        teamNameField.setPreferredSize(new Dimension(200, 24));
        JTextField teamDepartmentField = new JTextField();
        teamDepartmentField.setPreferredSize(new Dimension(200, 24));


        // JTable
        JTable table = new JTable();
        DefaultTableModel model = (DefaultTableModel) table.getModel();


        table.setBounds(70, 70, 1000, 1000);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setRowSelectionAllowed(true);

        model.addColumn("ID");
        model.addColumn("Task name");
        model.addColumn("Team");
        model.addColumn("Task Predecessor");
        model.addColumn("Duration in hours");


        // Task Buttons
        JButton addTask = new JButton("Add task");
        addTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Generates a random number with the bound set to 100 on line 94
                Random rand = new Random();

                // Creating a task object and passing user input from text fields into object parameters
                TaskKotlin tasks = new TaskKotlin(rand.nextInt(100), taskNameField.getText(), teamLists.getSelectedItem().toString(), taskPredecessorField.getText(), taskDurationField.getText());
                listOfTasks.add(tasks);

                Testing testing = new Testing();
                testing.runTest(tasks);




                taskNameField.setText("");
                taskTeamField.setText("");
                taskPredecessorField.setText("");
                taskDurationField.setText("");


                teamNameField.setText("");
                teamDepartmentField.setText("");

            }
        });


         /*
           This looks for test.txt file on the local machine, once found the for loops reads its contents and splits its based on the location
            of ",". Finally it is added to the JTable.
         */
        JButton loadTable = new JButton("Load Table");
        loadTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePath = "/Users/yunisfarah/Downloads/Coursework/test.txt";
                File file = new File(filePath);
                model.setRowCount(0);
                try {
                    InputStream in;
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String firstLine = br.readLine().trim();
                    Object[] tableLines = br.lines().toArray();

                    for (int i = 0; i < tableLines.length; i++) {
                        String line = tableLines[i].toString().trim();
                        String[] dataRow = line.split(",");
                        model.addRow(dataRow);
                    }


                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Please make sure a test.txt file in present the project folder");
                }


            }
        });


        // Team Button
        JButton addTeamButton = new JButton("Add team");
        addTeamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // If a team name has not been supplied on add team button is pressed (as in team name text field is empty) a message box is shown
                if (teamNameField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please select or enter a team");
                } else {
                    teamLists.addItem(teamNameField.getText());
                    listOfTeams.add(teamNameField.getText());
                    allTeams.setCurrentActiveTeams(listOfTeams);
                    returnName = taskNameField.getText();
                }
            }
        });



        // Adding Task components to panel
        teamPanel.add(teamName, "span");
        teamPanel.add(teamNameField, "span");
        teamPanel.add(teamDepartment, "span");
        teamPanel.add(teamDepartmentField, "span");
        teamPanel.add(addTeamButton, "span");

        panel1.add(new JScrollPane(table));
        panel1.add(loadTable);


        taskPanel.add(taskName, "span");
        taskPanel.add(taskNameField, "span");
        taskPanel.add(taskTeam, "span");
        taskPanel.add(teamLists, "span");
        taskPanel.add(taskPredecessor, "span");
        taskPanel.add(taskPredecessorField, "span");
        taskPanel.add(taskDuration, "span");
        taskPanel.add(taskDurationField, "span");
        taskPanel.add(addTask, "span");


        // Adding components to Main Panel
        panel1.add(teamPanel);
        panel1.add(taskPanel);


        // Setting up JPanel
        frame.add(panel1);

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

               GUI gui = new GUI();
            }
        });
    }
}

