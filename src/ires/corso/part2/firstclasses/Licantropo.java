package ires.corso.part2.firstclasses;

import ires.corso.part2.interfaces.Mostro;
import ires.corso.part2.interfaces.Umano;

public class Licantropo implements Mostro, Umano {

    protected int forzaUmano;
    protected int forzaMostro;
    private boolean isUomo;

    public Licantropo(boolean luna) {
        isUomo = !luna;

        if(luna) {
            forzaMostro = 15;
            forzaUmano = 0;
        }
        else {
            forzaUmano = 10;
            forzaMostro = 0;
        }
    }

    @Override
    public void combatti() {
        if(isUomo) {
            forzaUmano = forzaUmano - 3;
        }
    }

    @Override
    public void azzanna() {
        if(!isUomo) {
            forzaMostro = forzaMostro - 2;
        }
    }

    @Override
    public String getForza() {
        return "Forza rimanente come Umano: " + forzaUmano + "\nForza rimanente come Mostro: " + forzaMostro;
    }
}
