package com.company.Algorithms;

import javax.swing.*;
import java.awt.*;

public class Bresenham extends JPanel {

    Bresenham() {
        super();
    }

    @Override
    public void paint(Graphics g) {
        myBresenham(10, 10, 700, 300, g);
    }

    public void myBresenham(int x0, int y0, int x1, int y1, Graphics g) {
        int x = x0;
        int y = y0;
        int dx = Math.abs(x1 - x0);
        int dy = Math.abs(y1 - y0);
        int e = 2 * dy - dx;
        if (Math.max(dx, dy) == 0) {
            g.fillRect(x0, y0, 1, 1);
        }
        for (int i = 1; i <= dx; i++) {
            g.fillRect(x, y, 1, 1);
            if (e >= 0) {
                y++;
                e += -2 * dx + 2 * dy;
            } else {
                e += 2 * dy;
            }
            x++;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bresenham");
        frame.add(new Bresenham());
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setVisible(true);
    }
}
