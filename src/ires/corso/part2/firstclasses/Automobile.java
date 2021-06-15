package ires.corso.part2.firstclasses;

public class Automobile {

    private String brand;
    private int displacement;
    private boolean isElectric;

    public void prettyPrint() {
        if(isElectric){
            System.out.printf("Sono un'automobile di marca %s, la mia cilindrata è %d e sono elettrica\n", brand, displacement);
        }else
            System.out.printf("Sono un'automobile di marca %s e la mia cilindrata è %d \n", brand, displacement);
    }

    public Automobile(String brand, int displacement) {
        this.brand = brand;
        this.displacement = displacement;
        isElectric = false;
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
