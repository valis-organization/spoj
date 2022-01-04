package oop.exercise2;

public class Radius {
    public Point p1;
    public Point p2;

    Radius(Point p1, Point p2) throws Exception {
        this.p1 = p1;
        this.p2 = p2;
        if (p1.x != p2.x) {
            throw new Exception("The radius always starts at the center of the circle");
        }
    }
}

