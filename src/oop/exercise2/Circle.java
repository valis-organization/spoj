package oop.exercise2;

public class Circle {
    public Radius r1;
    public Double lengthOfRadius;

    Circle(Radius r1) {
        this.r1 = r1;
    }

    Circle(double getLengthOfRadius) {
        lengthOfRadius = getLengthOfRadius;
    }

    double getLengthOfRadius() {
        if (lengthOfRadius == null) {
            double lengthOfRadius = Math.abs(Math.abs(r1.p1.y) - Math.abs(r1.p2.y));
            return lengthOfRadius;
        } else {
            return lengthOfRadius;
        }
    }

    double getCircleField() {

        double fieldOfCircle = 3.14 * (getLengthOfRadius() * getLengthOfRadius());
        return fieldOfCircle;
    }
}
