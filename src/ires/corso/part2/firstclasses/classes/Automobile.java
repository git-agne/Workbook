package ires.corso.part2.firstclasses.classes;

public class Automobile {

    private String brand;
    private int displacement;
    private boolean isElectric;

    public void prettyPrint() {
        System.out.printf("Sono un'automobile di marca %s e la mia cilindrata è %d", brand, displacement);
    }

    public Automobile(String brand, int displacement) {
        this.brand = brand;
        this.displacement = displacement;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getDisplacement() {
        return displacement;
    }
    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public boolean isElectric() {
        return isElectric;
    }
    public void setElectric(boolean electric) {
        isElectric = electric;
    }
}
