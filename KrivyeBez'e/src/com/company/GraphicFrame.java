package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GraphicFrame extends Frame {

    private final JPanel contentPane;

    public GraphicFrame(Point[] array) {
        contentPane = new JPanel();
        int height = 1000;
        int width = 1000;
        contentPane.setBounds(0, 0, width, height);
        contentPane.setLayout(null);

        JPanel drawPane = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                drawPoints(array, g);
            }
        };


        drawPane.setBounds(0, 0, width, height);

        contentPane.add(drawPane);

        contentPane.setOpaque(true);
    }

    private void drawPoints(Point[] point, Graphics g) {
        ArrayList<Point> points = new ArrayList<>();

        for (int i = 0; i < point.length - 1; i++) {
            g.drawLine((int) point[i].x,
                    (int) point[i].y,
                    (int) point[i + 1].x,
                    (int) point[i + 1].y);
        }

        g.setColor(Color.RED);

        double t = 0;

        while (t <= 1) {
            points.add(rec(point, t)[0]);
            t += 0.000005;
        }

        for (int i = 0; i < points.size() - 1; i++) {
            g.drawLine((int) points.get(i).x, (int) points.get(i).y,
                    (int) points.get(i + 1).x, (int) points.get(i + 1).y);
        }

    }

    /**
     * B(t) = (1-t)*P0 + t*P1 формула для нахождения точки кривой с помощью 2ух точек.
     */
    private Point[] rec(Point[] points, double t) {
        if (points.length == 1) {
            return points;
        }
        Point[] newPoint = new Point[points.length - 1];
        double x;
        double y;
        for (int i = 0; i < points.length - 1; i++) {
            x = (1 - t) * points[i].x + t * points[i + 1].x;
            y = (1 - t) * points[i].y + t * points[i + 1].y;
            newPoint[i] = new Point(x, y);
        }
        return rec(newPoint, t);
    }

    public static void run(Point[] array) {
        JFrame frame = new JFrame("Кривые Безье");
        frame.setSize(750, 750);
        frame.setVisible(true);
        frame.setExtendedState(MAXIMIZED_BOTH);
        frame.setContentPane(new GraphicFrame(array).contentPane);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}