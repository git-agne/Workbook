package ires.corso.part2.firstclasses;

public class Square extends MasterShape {

    private double l;

    @Override
    public double computePerimeter() {
        return l * 4;
    }

    @Override
    public double computeArea() {
        return l * l;
    }

    public Square(double l) {
        this.l = l;
    }
}
