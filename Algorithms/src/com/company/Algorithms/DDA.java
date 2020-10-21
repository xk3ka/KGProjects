package com.company.Algorithms;

import javax.swing.*;
import java.awt.*;

public class DDA extends JPanel {

    public DDA() {
        super();
    }

    @Override
    public void paint(Graphics g) {
        myDDA(10, 10, 700, 300, g);
    }

    public void myDDA(int x0, int y0, int x1, int y1, Graphics g) {
        float x = x0;
        float y = y0;
        float length = Math.max((x1 - x0), (y1 - y0));
        float dx = (x1 - x0) / length;
        float dy = (y1 - y0) / length;
        for (int i = 0; i <= length; i++) {
            x += dx;
            y += dy;
            g.fillRect((int) x, (int) y, 1, 1);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("DDA");
        frame.add(new DDA());
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setVisible(true);
    }
}
