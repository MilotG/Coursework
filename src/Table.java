import javax.swing.*;

public class Table {
    String[] columnName = {"Task name", "Team", "Start date", "Completion data"};
    Table1Data clm = new Table1Data();
    Table2Data clm2 = new Table2Data();

    JTable tbl = new JTable(clm.getColumn(), columnName);
    JTable tb2 = new JTable(clm2.getColumn(), columnName);
}
