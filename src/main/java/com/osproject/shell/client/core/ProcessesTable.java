/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.osproject.shell.client.core;

import com.osproject.shell.client.components.LoginFrame;
import com.osproject.shell.client.components.MainFrame;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ksmar
 */
public class ProcessesTable {

    private final MainFrame mainFrame;
    private final LoginFrame loginFrame;

    public ProcessesTable(MainFrame mainFrame, LoginFrame loginFrame) {
        this.mainFrame = mainFrame;
        this.loginFrame = loginFrame;
    }

    public void createProcessesTable() {
        List<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();
        sortKeys.add(new RowSorter.SortKey(8, SortOrder.DESCENDING));
        this.mainFrame.getProcessesTable().setModel(getTableModel());
        this.mainFrame.getProcessesTable().getRowSorter().setSortKeys(sortKeys);
        this.mainFrame.getProcessesTable().revalidate();

        new Timer(3000, (ActionEvent e) -> {
            List<RowSorter.SortKey> oldSortKeys = (List<RowSorter.SortKey>) this.mainFrame.getProcessesTable().getRowSorter().getSortKeys();
            this.mainFrame.getProcessesTable().setModel(getTableModel());
            this.mainFrame.getProcessesTable().getRowSorter().setSortKeys(oldSortKeys);
            this.mainFrame.getProcessesTable().revalidate();
        }).start();
    }

    private DefaultTableModel getTableModel() {
        DefaultTableModel model = new DefaultTableModel();

        try {

            this.loginFrame.getDataOutputStream().writeUTF("5");
            String[] processes = this.loginFrame.getDataInputStream().readUTF().split(":///:");

            for (int i = 0; i < processes.length; i++) {
                processes[i] = processes[i].trim();
            }

            int index = 0;
            int counter = 0;
            for (String data : processes) {
                if (data.contains("PID")) {
                    index = counter;
                    break;
                }
                counter++;
            }

            String[] columns = processes[index].split(" +");
            for (String column : columns) {
                model.addColumn(column);
            }

            List<String> rows = new ArrayList<>();
            for (int i = index + 1; i < processes.length; i++) {
                rows.add(processes[i]);
            }

            for (String row : rows) {
                String[] rowData = row.split(" +");
                model.addRow(rowData);
            }

        } catch (IOException ex) {
            Logger.getLogger(ProcessesTable.class.getName()).log(Level.SEVERE, null, ex);
        }

        return model;
    }

}
