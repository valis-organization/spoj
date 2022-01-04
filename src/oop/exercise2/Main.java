package oop.exercise2;

public class Main {
    public static void main(String [] args) throws Exception {
        Circle rafal = new Circle(new Radius(new Point(4,5),new Point (4,9)));

        System.out.println(rafal.r1.p1.x);
        System.out.println(rafal.getLengthOfRadius());
        System.out.println(rafal.getCircleField());

        Circle robert = new Circle(4);
        System.out.println(robert.getCircleField());
    }
}
