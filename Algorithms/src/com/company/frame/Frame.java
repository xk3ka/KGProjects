package com.company.frame;

import javax.swing.*;
import java.awt.*;

public class Frame {
    private JLabel label;
    private JTextField functionField;
    private JButton drawButton;
    private JPanel toolbar;
    private Draw drawJPanel;
    private JPanel contentPanel;

    private final int width = 600;
    private final int height = 600;
    private final int indent = 10;

    public Frame() {
        setLabel();
        setFunctionField();
        setDrawButton();
        setToolbar();
        setDrawPane();
        setContentPane();
    }

    private void setLabel() {
        label = new JLabel("Введите функцию: ");
        label.setBounds(indent, indent, 150, 30);
    }

    private void setFunctionField() {
        functionField = new JTextField();
        functionField.setBounds( indent, 3*indent+5, 200, 30);
    }

    private void setDrawButton() {
        drawButton = new JButton("Построить график");
        drawButton.setBounds(indent, 7*indent, 200, 30);
        drawButton.addActionListener(e -> {
            try {
                drawJPanel.clear(drawJPanel.getGraphics());
                drawJPanel.drawGraph(drawJPanel.getGraphics(), functionField.getText());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }

    private void setToolbar() {
        toolbar = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.WHITE);
                g2.fillRect(1, 1, 220, 110);
            }
        };
        toolbar.setBounds(indent, indent, 220, 110);
        toolbar.setLayout(null);
        toolbar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        toolbar.add(label);
        toolbar.add(functionField);
        toolbar.add(drawButton);
    }

    private void setDrawPane() {
        drawJPanel = new Draw();
        drawJPanel.setBounds(indent * 25, indent, width, height);
        drawJPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private void setContentPane() {
        contentPanel = new JPanel();
        contentPanel.setBounds(0, 0, width, height);
        contentPanel.setLayout(null);
        contentPanel.add(toolbar);
        contentPanel.add(drawJPanel);
        contentPanel.setOpaque(true);
    }

    public static void run() {
        JFrame frame = new JFrame("График функции");
        frame.setPreferredSize(new Dimension(1000, 680));
        frame.setContentPane(new Frame().contentPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
