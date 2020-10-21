package com.company.Algorithms;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class Wu extends JPanel{
    Wu() {
        super();
    }

    @Override
    public void paint(Graphics g2) {
        myWu(10, 10, 700, 300, (Graphics2D)g2);
    }

    public static void myWu(float x0, float y0, float x1, float y1, Graphics2D g2) {
        boolean turned = Math.abs(x1 - x0) < Math.abs(y1 - y0);
        if (turned) {
            float tmp = x0;
            x0 = y0;
            y0 = tmp;
            tmp = x1;
            x1 = y1;
            y1 = tmp;
        }
        if (x0 > x1) {
            float tmp = x1;
            x1 = x0;
            x0 = tmp;
            tmp = y1;
            y1 = y0;
            y0 = tmp;
        }
        float dx = x1 - x0;
        float dy = y1 - y0;
        float gradient = dy / dx;
        float tmpX = Math.round(x0);
        float tmpY = y0 + gradient * (tmpX - x0);
        float xpx0 = tmpX;
        float ypx0 = (int) tmpY;
        if (turned) {
            g2.draw(new Line2D.Float(ypx0, xpx0, ypx0, xpx0));
            g2.draw(new Line2D.Float(ypx0 + 1, xpx0, ypx0 + 1, xpx0));
        } else {
            g2.draw(new Line2D.Float(xpx0, ypx0, xpx0, ypx0));
            g2.draw(new Line2D.Float(xpx0, ypx0 + 1, xpx0, ypx0 + 1));
        }
        float inter = tmpY + gradient;
        tmpX = Math.round(x1);
        tmpY = y1 + gradient * (tmpX - x1);
        float xpx1 = tmpX;
        float yxp1 = (int) tmpY;
        if (turned) {
            g2.draw(new Line2D.Float(yxp1, xpx1, yxp1, xpx1));
            g2.draw(new Line2D.Float(yxp1 + 1, xpx1, yxp1 + 1, xpx1));
        } else {
            g2.draw(new Line2D.Float(xpx1, yxp1, xpx1, yxp1));
            g2.draw(new Line2D.Float(xpx1, yxp1 + 1, xpx1, yxp1 + 1));
        }
        if (turned) {
            for (int y = (int) (xpx0 + 1); y <= xpx1 - 1; y++) {
                g2.draw(new Line2D.Float((int) inter, y, (int) inter, y));
                g2.draw(new Line2D.Float((int) inter + 1, y, (int) inter + 1, y));
                inter += gradient;
            }
        } else {
            for (int x = (int) (xpx0 + 1); x <= xpx1 - 1; x++) {
                g2.draw(new Line2D.Float(x, (int) inter, x, (int) inter));
                g2.draw(new Line2D.Float(x, (int) inter + 1, x, (int) inter + 1));
                inter += gradient;
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Wu");
        frame.add(new Wu());
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setVisible(true);
    }
}
