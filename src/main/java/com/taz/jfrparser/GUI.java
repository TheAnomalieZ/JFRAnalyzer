package com.taz.jfrparser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by  Maninesan on 9/23/16.
 */
public class GUI extends JFrame {

    private static JButton uploadAFileButton = new JButton();
    private static JPanel panel1;
    private JButton memoryAnalyzeButton = new JButton();
    private JButton cpuAnalyzeButton = new JButton();
    private JTextArea list1 = new JTextArea();
    private JButton refreshFileListButton;

    private JFileChooser chooser = new JFileChooser();



    public GUI() {


        JScrollPane scrollPane = new JScrollPane(list1);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(20,50,450,200);
//        list1.setBounds(20,50,450,200);
        // uploadAFileButton setbounds
        uploadAFileButton.setBounds(500, 100, 200,100);
        uploadAFileButton.setText("Upload JFRs");
        memoryAnalyzeButton.setBounds(150, 300, 200,100);
        memoryAnalyzeButton.setText("Memory");
        cpuAnalyzeButton.setBounds(400, 300, 200,100);
        cpuAnalyzeButton.setText("CPU");
        panel1 = new JPanel(new BorderLayout());
        // JPanel bounds
        panel1.setBounds(0, 0, 800, 400);
//        panel1.setBackground(Color.BLACK);
        //JFrame layout
        this.setLayout(null);

        //JPanel layout
        panel1.setLayout(null);
        // Adding to JFrame
        panel1.add(uploadAFileButton);
        panel1.add(memoryAnalyzeButton);
        panel1.add(cpuAnalyzeButton);
//        panel1.add(list1);
        panel1.add(scrollPane);
        add(panel1);

        // JFrame properties
        setSize(750, 450);
        setBackground(Color.BLACK);
        setTitle("TAZ GUI");
//        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        chooser.setDialogTitle("Choose JFR files");
        chooser.setMultiSelectionEnabled(true);

        uploadAFileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println(e.getActionCommand());
                chooser.showOpenDialog(panel1);
                File[] files = chooser.getSelectedFiles();
                for (File file : files)
                    try {
                        list1.append(file.getCanonicalPath()+" \n");
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
            }
        });

        memoryAnalyzeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println(e.getActionCommand());
            }
        });

        cpuAnalyzeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println(e.getActionCommand());
            }
        });





    }

    public static void main(String[] args) {

        new GUI();


    }
}
