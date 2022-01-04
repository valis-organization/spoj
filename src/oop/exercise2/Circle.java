package oop.exercise2;

public class Circle {
    public Radius r1;

    Circle(Radius r1) {
        this.r1 = r1;
    }

    double getCircleField() {
        double fieldOfCircle = 3.14 * (r1.getLengthOfRadius() * r1.getLengthOfRadius());
        return fieldOfCircle;
    }
}
