package oop.exercise1;


import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws Exception {

        Line rafal = new Line(new Point(4,8),new Point(7,3));
        System.out.println(rafal.p1.x);
        System.out.println(rafal.p1.y);
        System.out.println(rafal.p2.x);
        System.out.println(rafal.p2.y);
        try{
            Line robert = new Line(new Point(4,2), new Point(3,1));
        }catch (Exception exception){
            System.out.println("The exception was thrown: " + exception.getMessage());
        }
    }
}
