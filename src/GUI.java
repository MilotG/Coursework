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
