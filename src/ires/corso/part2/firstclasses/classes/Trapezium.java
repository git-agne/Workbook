package ires.corso.part2.firstclasses.classes;

public class Trapezium extends MasterShape {

    private double bMin;
    private double bMaj;
    private double h;
    private double l;

    @Override
    public double computePerimeter() {
        return bMin + bMaj + (l * 2);
    }

    @Override
    public double computeArea() {
        return ((bMaj + bMin) * h) / 2;
    }

    public Trapezium(double bMin, double bMaj, double h) {
        this.bMin = bMin;
        this.bMaj = bMaj;
        this.h = h;
    }
}
