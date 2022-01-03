package oop.exercise1;

public class Line {
    public Point p1;
    public Point p2;
    Line(Point p1, Point p2) throws Exception {
        this.p1 = p1;
        this.p2 = p2;
        if(p1.x == p2.x && p1.y == p2.y){
            throw new Exception("The Points cannot be the same");
        }
    }

}
