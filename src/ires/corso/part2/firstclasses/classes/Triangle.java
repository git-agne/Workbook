package ires.corso.part2.firstclasses.classes;

public class Triangle extends MasterShape {

    private double b;
    private double h;

    @Override
    public double computePerimeter() {
        return b * 4;
    }

    @Override
    public double computeArea() {
        return (b * h) / 2;
    }

    public Triangle(double b, double h) {
        this.b = b;
        this.h = h;
    }
}
