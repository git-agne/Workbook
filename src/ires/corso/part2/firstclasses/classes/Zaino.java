package ires.corso.part2.firstclasses.classes;

public class Zaino {

    private String owner;
    private int capacity;
    private boolean isHeavy;

    public void prettyPrint() {
        if(isHeavy){
            System.out.printf("Sono lo zaino di %s, contengo %d litri e sono pesante\n", owner, capacity);
        }else
            System.out.printf("Sono lo zaino di %s e contengo %d litri\n", owner, capacity);
    }

    public Zaino(String owner, int capacity) {
        this.owner = owner;
        this.capacity = capacity;
        isHeavy = false;
    }

    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isHeavy() {
        return isHeavy;
    }
    public void setHeavy(boolean heavy) {
        isHeavy = heavy;
    }
}
