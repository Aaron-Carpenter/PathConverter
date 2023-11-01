package gui;

import functionality.ConversionFunctionality;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;

public class SimpleConverterGUI extends JPanel {
    private JTextField pathField;
    private JTextArea resultArea;

    public SimpleConverterGUI() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        pathField = new JTextField(20);
        add(pathField, BorderLayout.PAGE_START);

        resultArea = new JTextArea(5, 20);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String originalPath = pathField.getText();
                String convertedPath = ConversionFunctionality.convertPath(originalPath);
                resultArea.setText(convertedPath);
            }
        });
        buttonPanel.add(convertButton);

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pathField.setText("");
                resultArea.setText("");
            }
        });
        buttonPanel.add(clearButton);

        JButton copyButton = new JButton("Copy");
        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = resultArea.getText();
                StringSelection selection = new StringSelection(text);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(selection, null);
            }
        });
        buttonPanel.add(copyButton);

        add(buttonPanel, BorderLayout.PAGE_END);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Path Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SimpleConverterGUI panel = new SimpleConverterGUI();
        frame.add(panel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
