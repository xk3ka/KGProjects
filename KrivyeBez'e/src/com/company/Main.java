package com.company;

public class Main {
    public static void main(String[] args) {
        Point[] array = {new Point(125, 125), new Point(125, 400),
                new Point(450, 400), new Point(600, 125),
                new Point(750, 357), new Point(300, 600),
                new Point(800,600)};
        GraphicFrame.run(array);
    }
}
