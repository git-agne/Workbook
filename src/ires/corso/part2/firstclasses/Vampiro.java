package ires.corso.part2.firstclasses;

import ires.corso.part2.interfaces.Mostro;

public class Vampiro implements Mostro {

    protected int forza;

    public Vampiro() {
        forza = 15;
    }
    @Override
    public void azzanna() {
        forza = forza - 2;
    }

    @Override
    public String getForza() {
        return "Forza rimanente come Vampiro: " + forza;
    }
}
