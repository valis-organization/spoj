package oop.exercise2;

public class Main {
    public static void main(String [] args){
        Circle rafal = null;
        try {
            rafal = new Circle(new Radius(new Point(4,5),new Point (4,9)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(rafal.r1.p1.x);
        System.out.println(rafal.r1.getLengthOfRadius());
        System.out.println(rafal.getCircleField());

        Circle robert = new Circle(new Radius(4.0));
        System.out.println(robert.getCircleField());
    }
}
