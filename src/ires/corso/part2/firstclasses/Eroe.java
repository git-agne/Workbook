package ires.corso.part2.firstclasses;

import ires.corso.part2.interfaces.Umano;

public class Eroe implements Umano {

    protected int forza;

    public Eroe() {
        forza = 10;
    }

    @Override
    public void combatti() {
        forza = forza - 3;
    }

    @Override
    public String getForza() {
        return "Forza rimanente come Eroe: " + forza;
    }
}
